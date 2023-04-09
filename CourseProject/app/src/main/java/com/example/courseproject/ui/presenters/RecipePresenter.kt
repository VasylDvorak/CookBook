package com.example.courseproject.ui.presenters


import com.example.courseproject.domain.repo.retrofit.IRecipeRepo
import com.example.courseproject.entity.categories.GithubUser
import com.example.courseproject.entity.category.GithubRepository
import com.example.courseproject.entity.recipe.Meal
import com.example.courseproject.ui.AndroidScreens
import com.example.courseproject.ui.interfaces.RecipeView
import com.example.courseproject.ui.recipe_fragment.IngredientsResult
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import javax.inject.Inject

class RecipePresenter : MvpPresenter<RecipeView>() {

    @Inject
    lateinit var mainThreadScheduler: Scheduler

    @Inject
    lateinit var recipeRepo: IRecipeRepo

    @Inject
    lateinit var router: Router
    private var currentRecipe: Meal = Meal()


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()

    }

    fun loadRepositories(currentRepository: GithubRepository) {
//App.instance.appComponent.inject(this)

        recipeRepo.getRecipes(currentRepository)
            .observeOn(mainThreadScheduler)
            .subscribe({ repos ->
                if(repos.size !=0){
                currentRecipe = repos.get(0)

                viewState.showRecipe(currentRecipe)}
            }, {
                println("Error: ${it.message} ")
            })


    }


    override fun onDestroy() {
        super.onDestroy()

        viewState.release()
    }

    fun backPressed(): Boolean {
        router.replaceScreen(AndroidScreens().repositories(GithubUser(strCategory = currentRecipe.strCategory!!)))
        return true
    }

fun ingredients()=IngredientsResult().ingredientsList(currentRecipe)

    fun playMovie() {
        currentRecipe.strYoutube?.let{
            router.navigateTo(AndroidScreens().playMovie(it))
        }

    }
}

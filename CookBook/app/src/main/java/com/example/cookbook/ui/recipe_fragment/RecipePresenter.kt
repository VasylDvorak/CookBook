package com.example.cookbook.ui.recipe_fragment

import com.example.cookbook.domain.repo.retrofit.IRecipeRepo
import com.example.cookbook.entity.categories.Category
import com.example.cookbook.entity.menu.Menu
import com.example.cookbook.entity.room.recipe.Meal
import com.example.cookbook.ui.main_activity.AndroidScreens
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

    fun loadMenu(currentItemMenu: Menu) {

        recipeRepo.getRecipes(currentItemMenu)
            .observeOn(mainThreadScheduler)
            .subscribe({ recipe ->
                if(recipe.size !=0){
                    currentRecipe = recipe.get(0)

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
        router.replaceScreen(
            AndroidScreens()
                .menu(Category(strCategory = currentRecipe.strCategory!!)))
        return true
    }

    fun ingredients()= RecipeIngredients().ingredientsList(currentRecipe)

    fun playMovie() {
        currentRecipe.strYoutube?.let{
            router.navigateTo(AndroidScreens().playMovie(it))
        }

    }
}
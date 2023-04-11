package com.example.cookbook.ui.recipe_fragment

import com.example.cookbook.application.App
import com.example.cookbook.R
import com.example.cookbook.domain.repository.retrofit.IRecipeRepo
import com.example.cookbook.domain.entity.categories.Category
import com.example.cookbook.domain.entity.menu.Menu
import com.example.cookbook.domain.entity.recipe.Meal
import com.example.cookbook.ui.main_activity.AndroidScreens
import com.example.cookbook.ui.main_activity.GONE
import com.example.cookbook.ui.main_activity.VISIBLE
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
    private val formIngredientsInstruction = FormIngredientsInstruction()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()

    }



    fun loadRecipe(currentItemMenu: Menu) {
        viewState.progressCircle(VISIBLE)
        recipeRepo.getRecipes(currentItemMenu)
            .observeOn(mainThreadScheduler)
            .subscribe({ recipe ->
                if(recipe.size !=0){
                    viewState.progressCircle(GONE)
                    currentRecipe = recipe.get(0)

                    viewState.showRecipe(currentRecipe)
                    showIngredients()
                    showInstruction()
            }     else{
                    showError()
            }
    }, {
                showError()
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

    private fun showInstruction() {
        viewState.showInstruction(formIngredientsInstruction
            .formInstructionText(currentRecipe.strInstructions?:""))
    }
   private fun showIngredients() {
        viewState.showIngredients(formIngredientsInstruction.ingredientsList(currentRecipe))
    }

    fun playMovie() {
        currentRecipe.strYoutube?.let{
            router.navigateTo(AndroidScreens().playMovie(it))
        }
    }

    fun showError(){
        val context = App.instance.applicationContext
        viewState.apply{
            progressCircle(GONE)
            showToastFragment(context!!.getString(R.string.check_internet))
        }
    }
}
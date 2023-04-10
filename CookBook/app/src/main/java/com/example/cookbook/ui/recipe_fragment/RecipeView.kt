package com.example.cookbook.ui.recipe_fragment

import com.example.cookbook.entity.room.recipe.Meal
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface RecipeView : MvpView {
    fun init()
    fun release()
    fun showRecipe(currentRecipe: Meal)
}

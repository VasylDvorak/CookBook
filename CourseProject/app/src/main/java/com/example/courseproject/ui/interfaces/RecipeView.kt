package com.example.courseproject.ui.interfaces

import com.example.courseproject.entity.recipe.Meal
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface RecipeView : MvpView {
    fun init()
    fun release()
    fun showRecipe(currentRecipe: Meal)
}

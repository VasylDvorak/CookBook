package com.example.cookbook.ui.recipe_fragment

import android.text.SpannableStringBuilder
import com.example.cookbook.domain.entity.recipe.Meal
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface RecipeView : MvpView {
    fun init()
    fun release()
    fun showRecipe(currentRecipe: Meal)
    fun progressCircle(indicate: Int)
    fun showToastFragment(text: String)
    fun showIngredients(text: SpannableStringBuilder)
    fun showInstruction(text: SpannableStringBuilder)
}

package com.example.cookbook.di.recipe

import com.example.cookbook.di.recipe.module.RecipeModule
import com.example.cookbook.ui.recipe_fragment.RecipePresenter
import com.example.cookbook.ui.recipe_fragment.RecipeFragment
import dagger.Subcomponent

@RecipeScope
@Subcomponent(
    modules = [
        RecipeModule::class])

interface RecipeSubcomponent{
    fun inject(recipePresenter: RecipePresenter)
    fun inject(recipeFragment: RecipeFragment)

}
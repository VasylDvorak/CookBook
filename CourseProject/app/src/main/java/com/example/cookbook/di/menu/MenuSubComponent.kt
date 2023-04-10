package com.example.cookbook.di.menu

import com.example.cookbook.di.recipe.RecipeSubcomponent
import com.example.cookbook.di.menu.module.MenuModule
import com.example.cookbook.ui.menu_fragment.MenuPresenter
import com.example.cookbook.ui.menu_fragment.MenuRVAdapter
import dagger.Subcomponent

@MenuScope
@Subcomponent(
    modules = [
        MenuModule::class])

interface MenuSubcomponent {
    fun recipeSubcomponent(): RecipeSubcomponent
    fun inject(menuPresenter: MenuPresenter)
    fun inject(menuRVAdapter: MenuRVAdapter)
}
package com.example.courseproject.di.recipe

import com.example.courseproject.di.recipe.module.RecipeModule
import com.example.courseproject.di.repository.module.RepositoryModule
import com.example.courseproject.ui.presenters.RecipePresenter
import com.example.courseproject.ui.presenters.RepositoriesPresenter
import com.example.courseproject.ui.recipe_fragment.RecipeFragment
import com.example.courseproject.ui.repositories.RepositoriesRVAdapter
import dagger.Subcomponent

@RecipeScope
@Subcomponent(
    modules = [
        RecipeModule::class])

interface RecipeSubcomponent{
    fun inject(recipePresenter: RecipePresenter)
    fun inject(recipeFragment: RecipeFragment)

}
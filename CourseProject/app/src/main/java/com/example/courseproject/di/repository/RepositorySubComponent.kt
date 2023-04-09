package com.example.courseproject.di.repository

import com.example.courseproject.di.recipe.RecipeSubcomponent
import com.example.courseproject.di.repository.module.RepositoryModule
import com.example.courseproject.ui.presenters.RepositoriesPresenter
import com.example.courseproject.ui.repositories.RepositoriesRVAdapter
import com.example.courseproject.ui.users.UsersRVAdapter
import dagger.Subcomponent

@RepositoryScope
@Subcomponent(
    modules = [
        RepositoryModule::class])

interface RepositorySubcomponent {
    fun recipeSubcomponent(): RecipeSubcomponent
    fun inject(repositoryPresenter: RepositoriesPresenter)
    fun inject(repositoriesRVAdapter: RepositoriesRVAdapter)
}
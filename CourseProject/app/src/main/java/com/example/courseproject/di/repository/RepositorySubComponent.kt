package com.example.courseproject.di.repository

import com.example.courseproject.di.repository.module.RepositoryModule
import com.example.courseproject.ui.presenters.RepositoriesPresenter
import dagger.Subcomponent

@RepositoryScope
@Subcomponent(
    modules = [
        RepositoryModule::class])

interface RepositorySubcomponent {
    fun inject(repositoryPresenter: RepositoriesPresenter)
}
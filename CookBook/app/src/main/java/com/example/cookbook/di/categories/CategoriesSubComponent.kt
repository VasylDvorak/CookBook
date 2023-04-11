package com.example.cookbook.di.categories


import com.example.cookbook.di.menu.MenuSubcomponent
import com.example.cookbook.di.categories.module.CategoriesModule
import com.example.cookbook.ui.categories_fragment.categories_presenters.CategoriesPresenter
import com.example.cookbook.ui.categories_fragment.CategoriesRVAdapter
import dagger.Subcomponent

@CategoriesScope
@Subcomponent(
    modules = [
        CategoriesModule::class
    ]
)
interface CategoriesSubcomponent {
   fun menuSubcomponent(): MenuSubcomponent
    fun inject(categoriesPresenter: CategoriesPresenter)
    fun inject(categoriesRVAdapter: CategoriesRVAdapter)
}
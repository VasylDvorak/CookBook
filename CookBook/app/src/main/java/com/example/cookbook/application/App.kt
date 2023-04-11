package com.example.cookbook.application

import android.app.Application
import com.example.cookbook.di.AppComponent
import com.example.cookbook.di.DaggerAppComponent
import com.example.cookbook.di.application_modules.AppModule
import com.example.cookbook.di.recipe.IRecipeScopeContainer
import com.example.cookbook.di.recipe.RecipeSubcomponent
import com.example.cookbook.di.menu.IMenuScopeContainer
import com.example.cookbook.di.menu.MenuSubcomponent
import com.example.cookbook.di.categories.ICategoriesScopeContainer
import com.example.cookbook.di.categories.CategoriesSubcomponent


class App : Application(), ICategoriesScopeContainer, IMenuScopeContainer, IRecipeScopeContainer {

    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent
        private set
    var categoriesSubcomponent: CategoriesSubcomponent? = null
        private set
    var menuSubcomponent: MenuSubcomponent? = null
        private set
    var recipeSubcomponent: RecipeSubcomponent? = null
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    fun initCategorySubcomponent() = appComponent.categoriesSubcomponent().also {
        categoriesSubcomponent = it
    }

    fun initMenuSubcomponent() =
        categoriesSubcomponent?.menuSubcomponent().also {
            menuSubcomponent = it
        }
    fun initRecipeSubcomponent() =
        menuSubcomponent?.recipeSubcomponent().also {
            recipeSubcomponent = it
        }

    override fun releaseCategoriesSubComponent() {
        categoriesSubcomponent = null
    }

    override fun releaseMenuSubComponent() {
        menuSubcomponent = null
    }
    override fun releaseRecipeSubComponent() {
        recipeSubcomponent = null
    }

}

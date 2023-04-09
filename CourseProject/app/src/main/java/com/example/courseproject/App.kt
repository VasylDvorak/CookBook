package com.example.courseproject

import android.app.Application
import com.example.courseproject.di.AppComponent
import com.example.courseproject.di.DaggerAppComponent
import com.example.courseproject.di.modules.AppModule
import com.example.courseproject.di.recipe.IRecipeScopeContainer
import com.example.courseproject.di.recipe.RecipeSubcomponent
import com.example.courseproject.di.repository.IRepositoryScopeContainer
import com.example.courseproject.di.repository.RepositorySubcomponent
import com.example.courseproject.di.user.IUserScopeContainer
import com.example.courseproject.di.user.UserSubcomponent


class App : Application(), IUserScopeContainer, IRepositoryScopeContainer, IRecipeScopeContainer {

    companion object {
        lateinit var instance: App
        var appInstance: App? =
            null  // Оставил для вызова App.appInstance?.applicationContext из любого места программы
    }

    lateinit var appComponent: AppComponent
        private set
    var userSubcomponent: UserSubcomponent? = null
        private set
    var repositorySubcomponent: RepositorySubcomponent? = null
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

    fun initUserSubcomponent() = appComponent.userSubcomponent().also {
        userSubcomponent = it
    }

    fun initRepositorySubcomponent() =
        userSubcomponent?.repositorySubcomponent().also {
            repositorySubcomponent = it
        }
    fun initRecipeSubcomponent() =
        repositorySubcomponent?.recipeSubcomponent().also {
            recipeSubcomponent = it
        }

    override fun releaseUserSubComponent() {
        userSubcomponent = null
    }

    override fun releaseRepositorySubComponent() {
        repositorySubcomponent = null
    }
    override fun releaseRecipeSubComponent() {
        recipeSubcomponent = null
    }
}

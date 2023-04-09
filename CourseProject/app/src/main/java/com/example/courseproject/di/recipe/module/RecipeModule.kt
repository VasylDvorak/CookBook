package com.example.courseproject.di.recipe.module


import com.example.courseproject.App
import com.example.courseproject.di.recipe.IRecipeScopeContainer
import com.example.courseproject.di.recipe.RecipeScope
import com.example.courseproject.domain.api.IDataSource
import com.example.courseproject.domain.cache.IRecipeCache
import com.example.courseproject.domain.cache.room.RoomRecipeCache
import com.example.courseproject.domain.network.INetworkStatus
import com.example.courseproject.domain.repo.retrofit.IRecipeRepo
import com.example.courseproject.domain.repo.retrofit.RetrofitRecipeRepo
import dagger.Module
import dagger.Provides


@Module
open class RecipeModule {
    @Provides
    fun recipeCache(): IRecipeCache {
        return RoomRecipeCache()
    }

    @RecipeScope
    @Provides
    open fun recipeRepo(api: IDataSource, networkStatus: INetworkStatus):
            IRecipeRepo {
        return RetrofitRecipeRepo(api, networkStatus)
    }

    @RecipeScope
    @Provides
    open fun scopeContainer(app: App): IRecipeScopeContainer = app


}
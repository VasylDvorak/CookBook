package com.example.cookbook.di.recipe.module


import com.example.cookbook.App
import com.example.cookbook.di.recipe.IRecipeScopeContainer
import com.example.cookbook.di.recipe.RecipeScope
import com.example.cookbook.domain.api.IDataSource
import com.example.cookbook.domain.cache.IRecipeCache
import com.example.cookbook.domain.cache.room.RoomRecipeCache
import com.example.cookbook.domain.network.INetworkStatus
import com.example.cookbook.domain.repo.retrofit.IRecipeRepo
import com.example.cookbook.domain.repo.retrofit.RetrofitRecipeRepo
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
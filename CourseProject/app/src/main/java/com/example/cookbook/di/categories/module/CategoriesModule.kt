package com.example.cookbook.di.categories.module


import com.example.cookbook.App
import com.example.cookbook.di.categories.ICategoriesScopeContainer
import com.example.cookbook.domain.api.IDataSource
import com.example.cookbook.domain.cache.ICategoriesCache
import com.example.cookbook.domain.cache.room.RoomCategoriesCache
import com.example.cookbook.domain.network.INetworkStatus
import com.example.cookbook.domain.repo.ICategoriesRepo
import com.example.cookbook.domain.repo.retrofit.RetrofitCategoriesRepo
import com.example.cookbook.di.categories.CategoriesScope

import dagger.Module
import dagger.Provides

@Module
open class CategoriesModule {
    @Provides
    fun categoriesCache(): ICategoriesCache {
        return RoomCategoriesCache()
    }
    @CategoriesScope
    @Provides
    open fun categoriesRepo(api: IDataSource, networkStatus: INetworkStatus): ICategoriesRepo {
        return RetrofitCategoriesRepo(api, networkStatus)
    }
    @CategoriesScope
    @Provides
    open fun scopeContainer(app: App): ICategoriesScopeContainer = app
}
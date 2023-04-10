package com.example.cookbook.di.menu.module

import com.example.cookbook.App
import com.example.cookbook.di.menu.IMenuScopeContainer
import com.example.cookbook.di.menu.MenuScope
import com.example.cookbook.domain.api.IDataSource
import com.example.cookbook.domain.cache.IMenuCache
import com.example.cookbook.domain.cache.room.RoomMenuCache
import com.example.cookbook.domain.network.INetworkStatus
import com.example.cookbook.domain.repo.retrofit.IMenuRepo
import com.example.cookbook.domain.repo.retrofit.RetrofitMenuRepo
import dagger.Module
import dagger.Provides

@Module
open class MenuModule {
    @Provides
    fun menuCache(): IMenuCache {
        return RoomMenuCache()
    }

    @MenuScope
    @Provides
    open fun menuRepo(api: IDataSource, networkStatus: INetworkStatus):
            IMenuRepo {
        return RetrofitMenuRepo(api, networkStatus)
    }

    @MenuScope
    @Provides
    open fun scopeContainer(app: App): IMenuScopeContainer = app

}
package com.example.courseproject.di.user.module


import com.example.courseproject.App
import com.example.courseproject.di.user.IUserScopeContainer
import com.example.courseproject.domain.api.IDataSource
import com.example.courseproject.domain.cache.IGithubUsersCache
import com.example.courseproject.domain.cache.room.RoomGithubUsersCache
import com.example.courseproject.domain.network.INetworkStatus
import com.example.courseproject.domain.repo.IGithubUsersRepo
import com.example.courseproject.domain.repo.retrofit.RetrofitGithubUsersRepo
import com.example.courseproject.di.user.UserScope

import dagger.Module
import dagger.Provides

@Module
open class UserModule {
    @Provides
    fun usersCache(): IGithubUsersCache {
        return RoomGithubUsersCache()
    }
    @UserScope
    @Provides
    open fun usersRepo(api: IDataSource, networkStatus: INetworkStatus): IGithubUsersRepo {
        return RetrofitGithubUsersRepo(api, networkStatus)
    }
    @UserScope
    @Provides
    open fun scopeContainer(app: App): IUserScopeContainer = app
}
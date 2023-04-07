package com.example.courseproject.di.repository.module


import com.example.courseproject.App
import com.example.courseproject.di.repository.IRepositoryScopeContainer
import com.example.courseproject.di.repository.RepositoryScope
import com.example.courseproject.domain.api.IDataSource
import com.example.courseproject.domain.cache.IGithubRepositoriesCache
import com.example.courseproject.domain.cache.room.RoomGithubRepositoriesCache
import com.example.courseproject.domain.network.INetworkStatus
import com.example.courseproject.domain.repo.retrofit.IGithubRepositoriesRepo
import com.example.courseproject.domain.repo.retrofit.RetrofitGithubRepositoriesRepo
import dagger.Module
import dagger.Provides


@Module
open class RepositoryModule {
    @Provides
    fun repositoriesCache(): IGithubRepositoriesCache {
        return RoomGithubRepositoriesCache()
    }

    @RepositoryScope
    @Provides
    open fun repositoriesRepo(api: IDataSource, networkStatus: INetworkStatus):
            IGithubRepositoriesRepo {
        return RetrofitGithubRepositoriesRepo(api, networkStatus)
    }

    @RepositoryScope
    @Provides
    open fun scopeContainer(app: App): IRepositoryScopeContainer = app


}
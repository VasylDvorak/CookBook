package com.example.courseproject.di.modules


import com.example.courseproject.domain.api.IDataSource
import com.example.courseproject.domain.network.INetworkStatus
import com.example.courseproject.domain.repo.IGithubUsersRepo
import com.example.courseproject.domain.repo.retrofit.IGithubRepositoriesRepo
import com.example.courseproject.domain.repo.retrofit.RetrofitGithubRepositoriesRepo
import com.example.courseproject.domain.repo.retrofit.RetrofitGithubUsersRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {

    @Singleton
    @Provides
    fun usersRepo(api: IDataSource, networkStatus: INetworkStatus): IGithubUsersRepo =
        RetrofitGithubUsersRepo(api, networkStatus)

    @Singleton
    @Provides
    fun repositoriesRepo(api: IDataSource, networkStatus: INetworkStatus): IGithubRepositoriesRepo =
        RetrofitGithubRepositoriesRepo(api, networkStatus)


}
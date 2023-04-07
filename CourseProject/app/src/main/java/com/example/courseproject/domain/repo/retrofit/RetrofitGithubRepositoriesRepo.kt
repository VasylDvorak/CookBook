package com.example.courseproject.domain.repo.retrofit

import com.example.courseproject.App
import com.example.courseproject.domain.api.IDataSource
import com.example.courseproject.domain.cache.room.RoomGithubRepositoriesCache
import com.example.courseproject.domain.network.INetworkStatus
import com.example.courseproject.entity.GithubUser
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class RetrofitGithubRepositoriesRepo(
    val api: IDataSource, val networkStatus:
    INetworkStatus
) : IGithubRepositoriesRepo {
@Inject
lateinit var repositoriesCache: RoomGithubRepositoriesCache

    override fun getRepositories(user: GithubUser) =
        networkStatus.isOnlineSingle().flatMap { isOnline ->
            App.instance.appComponent.inject(this)
            if (isOnline) {
                repositoriesCache.newData(user, api)
            } else {
                repositoriesCache.fromDataBaseData(user)
            }
        }.subscribeOn(Schedulers.io())
}

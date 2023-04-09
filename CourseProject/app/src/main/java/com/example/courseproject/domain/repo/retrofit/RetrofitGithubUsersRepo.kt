package com.example.courseproject.domain.repo.retrofit

import com.example.courseproject.App
import com.example.courseproject.domain.api.IDataSource
import com.example.courseproject.domain.cache.room.RoomGithubUsersCache
import com.example.courseproject.domain.network.INetworkStatus
import com.example.courseproject.domain.repo.IGithubUsersRepo
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class RetrofitGithubUsersRepo(
    val api: IDataSource, val networkStatus: INetworkStatus
) : IGithubUsersRepo {
@Inject
lateinit var userCache: RoomGithubUsersCache


    override fun getUsers() = networkStatus.isOnlineSingle().flatMap { isOnline ->
        App.instance.appComponent.inject(this)
        if (isOnline) {

            userCache.newData(api)

        } else {
            userCache.fromDataBaseData()
        }
    }.subscribeOn(Schedulers.io())
}

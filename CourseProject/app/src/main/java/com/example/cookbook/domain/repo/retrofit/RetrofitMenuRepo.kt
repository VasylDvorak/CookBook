package com.example.cookbook.domain.repo.retrofit

import com.example.cookbook.App
import com.example.cookbook.domain.api.IDataSource
import com.example.cookbook.domain.cache.room.RoomMenuCache
import com.example.cookbook.domain.network.INetworkStatus
import com.example.cookbook.entity.categories.Category
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class RetrofitMenuRepo(
    val api: IDataSource, val networkStatus:
    INetworkStatus
) : IMenuRepo {
@Inject
lateinit var menuCache: RoomMenuCache

    override fun getMenu(category: Category) =
        networkStatus.isOnlineSingle().flatMap { isOnline ->
            App.instance.appComponent.inject(this)
            if (isOnline) {
                menuCache.newData(category, api)
            } else {
                menuCache.fromDataBaseData(category)
            }
        }.subscribeOn(Schedulers.io())
}

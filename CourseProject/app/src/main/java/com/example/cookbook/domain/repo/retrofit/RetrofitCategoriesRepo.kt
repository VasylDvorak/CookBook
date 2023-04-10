package com.example.cookbook.domain.repo.retrofit

import com.example.cookbook.App
import com.example.cookbook.domain.api.IDataSource
import com.example.cookbook.domain.cache.room.RoomCategoriesCache
import com.example.cookbook.domain.network.INetworkStatus
import com.example.cookbook.domain.repo.ICategoriesRepo
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class RetrofitCategoriesRepo(
    val api: IDataSource, val networkStatus: INetworkStatus
) : ICategoriesRepo {
@Inject
lateinit var categoriesCache: RoomCategoriesCache

    override fun getCategories() = networkStatus.isOnlineSingle().flatMap { isOnline ->
        App.instance.appComponent.inject(this)
        if (isOnline) {

            categoriesCache.newData(api)

        } else {
            categoriesCache.fromDataBaseData()
        }
    }.subscribeOn(Schedulers.io())
}

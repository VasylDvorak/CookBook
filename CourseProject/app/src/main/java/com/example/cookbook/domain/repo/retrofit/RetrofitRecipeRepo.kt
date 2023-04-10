package com.example.cookbook.domain.repo.retrofit

import com.example.cookbook.App
import com.example.cookbook.domain.api.IDataSource
import com.example.cookbook.domain.cache.room.RoomRecipeCache
import com.example.cookbook.domain.network.INetworkStatus
import com.example.cookbook.entity.menu.Menu
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class RetrofitRecipeRepo (
    val api: IDataSource, val networkStatus: INetworkStatus
) : IRecipeRepo {
    @Inject
    lateinit var recipeCache: RoomRecipeCache

    override fun getRecipes(currentItemMenu: Menu) =
        networkStatus.isOnlineSingle().flatMap { isOnline ->
            App.instance.appComponent.inject(this)
            if (isOnline) {
                recipeCache.newData(currentItemMenu, api)
            } else {
                recipeCache.fromDataBaseData(currentItemMenu)
            }
        }.subscribeOn(Schedulers.io())


}
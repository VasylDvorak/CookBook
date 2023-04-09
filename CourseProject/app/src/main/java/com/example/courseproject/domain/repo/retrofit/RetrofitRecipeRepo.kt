package com.example.courseproject.domain.repo.retrofit

import com.example.courseproject.App
import com.example.courseproject.domain.api.IDataSource
import com.example.courseproject.domain.cache.room.RoomRecipeCache
import com.example.courseproject.domain.network.INetworkStatus
import com.example.courseproject.entity.category.GithubRepository
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class RetrofitRecipeRepo (
    val api: IDataSource, val networkStatus: INetworkStatus
) : IRecipeRepo {
    @Inject
    lateinit var recipeCache: RoomRecipeCache

    override fun getRecipes(currentRepository: GithubRepository) =
        networkStatus.isOnlineSingle().flatMap { isOnline ->
            App.instance.appComponent.inject(this)
            if (isOnline) {
                recipeCache.newData(currentRepository, api)
            } else {
                recipeCache.fromDataBaseData(currentRepository)
            }
        }.subscribeOn(Schedulers.io())


}
package com.example.courseproject.domain.cache.room

import com.example.courseproject.App
import com.example.courseproject.domain.api.IDataSource
import com.example.courseproject.domain.cache.IGithubRepositoriesCache
import com.example.courseproject.entity.category.GithubRepository
import com.example.courseproject.entity.categories.GithubUser
import com.example.courseproject.entity.room.Database
import com.example.courseproject.entity.room.RoomGithubRepository
import com.google.gson.annotations.Expose
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject


class RoomGithubRepositoriesCache : IGithubRepositoriesCache {
    @Inject
    lateinit var database: Database
    init{
        App.instance.appComponent.inject(this)
    }
    override fun newData(user: GithubUser, api: IDataSource): Single<List<GithubRepository>> {
        return user.strCategory?.let { url ->
            api.getRepositories(url)
                .flatMap { repositories ->
                    Single.fromCallable {
                        val roomUser = user.strCategory.let {
                            database.userDao.findByLogin(it)
                        }
                       val meals = repositories.meals
                        val roomRepos = meals.map {
                            RoomGithubRepository(
                                it.idMeal, it.strMeal?: "", it.strMealThumb ?: "",
                                roomUser.idCategory
                            )
                        }


                        database.repositoryDao.insert(roomRepos)
                        meals

                    }
                }
        }
            ?: Single.error<List<GithubRepository>>(RuntimeException("User has no repos url"))
                .subscribeOn(Schedulers.io())
    }


    override fun fromDataBaseData(user: GithubUser): Single<List<GithubRepository>> {
        return Single.fromCallable {
            val roomUser = user.strCategory.let { database.userDao.findByLogin(it) }

            database.repositoryDao.findForUser(roomUser.idCategory).map {
                GithubRepository(it.idMeal, it.strMeal, it.strMealThumb)
            }
        }
    }
}
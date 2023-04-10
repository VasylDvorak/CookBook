package com.example.cookbook.domain.cache.room

import com.example.cookbook.App
import com.example.cookbook.domain.api.IDataSource
import com.example.cookbook.domain.cache.IMenuCache
import com.example.cookbook.entity.menu.Menu
import com.example.cookbook.entity.categories.Category
import com.example.cookbook.entity.room.Database
import com.example.cookbook.entity.room.RoomMenu
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class RoomMenuCache : IMenuCache {
    @Inject
    lateinit var database: Database
    init{
        App.instance.appComponent.inject(this)
    }
    override fun newData(category: Category, api: IDataSource): Single<List<Menu>> {
        return category.strCategory?.let { url ->
            api.getMenu(url)
                .flatMap { listMenu ->
                    Single.fromCallable {
                        val roomCategory = category.strCategory.let {
                            database.categoriesDao.findByCategory(it)
                        }
                       val meals = listMenu.meals
                        val roomMenu = meals.map {
                            RoomMenu(
                                it.idMeal, it.strMeal?: "", it.strMealThumb ?: "",
                                roomCategory.idCategory
                            )
                        }


                        database.menuDao.insert(roomMenu)
                        meals

                    }
                }
        }
            ?: Single.error<List<Menu>>(RuntimeException("Category has no menu url"))
                .subscribeOn(Schedulers.io())
    }


    override fun fromDataBaseData(category: Category): Single<List<Menu>> {
        return Single.fromCallable {
            val roomCategory = category.strCategory.let { database.categoriesDao.findByCategory(it) }

            database.menuDao.findForCategory(roomCategory.idCategory).map {
                Menu(it.idMeal, it.strMeal, it.strMealThumb)
            }
        }
    }
}
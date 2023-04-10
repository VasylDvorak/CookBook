package com.example.cookbook.domain.cache.room


import com.example.cookbook.App
import com.example.cookbook.domain.api.IDataSource
import com.example.cookbook.domain.cache.ICategoriesCache
import com.example.cookbook.entity.categories.Category
import com.example.cookbook.entity.room.Database
import com.example.cookbook.entity.room.RoomCategory
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RoomCategoriesCache : ICategoriesCache {
    @Inject
    lateinit var database: Database
    init{
        App.instance.appComponent.inject(this)
    }

    override fun newData(
        api: IDataSource
    ): Single<List<Category>> {
        return api.getCategories()
            .flatMap { categories ->
                Single.fromCallable {
                   val input_categories = categories.categories
                    val roomCategories = input_categories.map { category ->

                        RoomCategory(
                            category.idCategory,
                            category.strCategory, category.strCategoryThumb ?: "",
                            category.strCategoryDescription ?: ""
                        )
                    }

                    database.categoriesDao.insert(roomCategories)

                    Thread { RoomPictureCache().newData(input_categories) }.start()
                    input_categories

                }
            }
    }

    override fun fromDataBaseData(): Single<List<Category>> {

        return Single.fromCallable {
            var out = database.categoriesDao.getAll().map { roomCategory ->
                Category(
                    roomCategory.idCategory, roomCategory.strCategory, roomCategory.strCategoryThumb,
                    roomCategory.strCategoryDescription
                )
            }
            out.forEach {
                val roomCategoryFind = it.strCategory.let { database.categoriesDao.findByCategory(it) }
                it.strCategoryThumb = database.pictureDao.findForCategory(roomCategoryFind.idCategory).local_path
            }
            out
        }
    }

}
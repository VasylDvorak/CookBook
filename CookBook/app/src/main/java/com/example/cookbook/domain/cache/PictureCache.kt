package com.example.cookbook.domain.cache

import android.database.sqlite.SQLiteConstraintException
import com.example.cookbook.application.App
import com.example.cookbook.domain.cache.cahe_interfaces.IPictureCache
import com.example.cookbook.domain.entity.PictureEnity
import com.example.cookbook.domain.entity.entity_categories.Category
import com.example.cookbook.data.room.Database
import com.example.cookbook.data.room.RoomPicture
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
class PictureCache : IPictureCache {
    @Inject
    lateinit var database: Database
    init{
        App.instance.appComponent.inject(this)
    }
    override fun newData(categories: List<Category>) {
         val roomPicture = categories.map {
            RoomPicture(
                it.idCategory, it.strCategoryThumb ?: "",SaveURLtoFile().saveInFile(it)
            )
        }
        try {
            database.pictureDao.insert(roomPicture)
        }catch (e: SQLiteConstraintException){}
    }

    override fun fromDataBaseData(): Single<List<PictureEnity>> {
        return Single.fromCallable {
            database.pictureDao.getAll().map {
                PictureEnity(it.idCategory, it.strCategoryThumb, it.local_path)
            }
        }
    }

}
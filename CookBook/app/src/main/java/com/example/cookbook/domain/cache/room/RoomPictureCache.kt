package com.example.cookbook.domain.cache.room

import android.os.Environment
import com.example.cookbook.App
import com.example.cookbook.domain.cache.IPictureCache
import com.example.cookbook.entity.PictureEnity
import com.example.cookbook.entity.categories.Category
import com.example.cookbook.entity.room.Database
import com.example.cookbook.entity.room.RoomPicture
import io.reactivex.rxjava3.core.Single
import java.io.File
import javax.inject.Inject
class RoomPictureCache : IPictureCache {
    @Inject
    lateinit var database: Database
    init{
        App.instance.appComponent.inject(this)
    }
    override fun newData(categories: List<Category>) {

        deleteAllPicturesAndLinks()

        val roomPicture = categories.map {
            RoomPicture(
                it.idCategory, it.strCategoryThumb ?: "", SaveURLtoFile().saveInFile(it)
            )
        }
        database.pictureDao.insert(roomPicture)
    }


    override fun fromDataBaseData(): Single<List<PictureEnity>> {
        return Single.fromCallable {
            database.pictureDao.getAll().map {
                PictureEnity(it.idCategory, it.strCategoryThumb, it.local_path)
            }
        }
    }

    private fun deleteAllPicturesAndLinks() {
        val path =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
                .toString() + "/Cookbook"
        File(path).delete()
       // database.pictureDao.deleteAll()
    }

}
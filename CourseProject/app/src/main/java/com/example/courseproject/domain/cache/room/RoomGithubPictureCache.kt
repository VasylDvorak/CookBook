package com.example.courseproject.domain.cache.room

import android.os.Environment
import com.example.courseproject.App
import com.example.courseproject.domain.cache.IGithubPictureCache
import com.example.courseproject.entity.GithubPicture
import com.example.courseproject.entity.GithubUser
import com.example.courseproject.entity.room.Database
import com.example.courseproject.entity.room.RoomGithubPicture
import io.reactivex.rxjava3.core.Single
import java.io.File
import javax.inject.Inject

class RoomGithubPictureCache : IGithubPictureCache {
    @Inject
    lateinit var database: Database
    init{
        App.instance.appComponent.inject(this)
    }
    override fun newData(users: List<GithubUser>) {

        deleteAllPicturesAndLinks()

        val roomPicture = users.map {
            RoomGithubPicture(
                it.id, it.avatar_url ?: "", SaveURLtoFile().saveInFile(it)
            )
        }
        database.pictureDao.insert(roomPicture)
    }


    override fun fromDataBaseData(): Single<List<GithubPicture>> {
        return Single.fromCallable {
            database.pictureDao.getAll().map {
                GithubPicture(it.id, it.avatar_url, it.local_path)
            }
        }
    }

    private fun deleteAllPicturesAndLinks() {
        val path =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
                .toString() + "/GitHubUsers"
        File(path).delete()
       // database.pictureDao.deleteAll()
    }

}
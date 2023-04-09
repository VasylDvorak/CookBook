package com.example.courseproject.domain.cache.room


import com.example.courseproject.App
import com.example.courseproject.domain.api.IDataSource
import com.example.courseproject.domain.cache.IGithubUsersCache
import com.example.courseproject.entity.categories.GithubUser
import com.example.courseproject.entity.room.Database
import com.example.courseproject.entity.room.RoomGithubUser
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RoomGithubUsersCache : IGithubUsersCache {
    @Inject
    lateinit var database: Database
    init{
        App.instance.appComponent.inject(this)
    }

    override fun newData(
        api: IDataSource
    ): Single<List<GithubUser>> {
        return api.getUsers()
            .flatMap { users ->
                Single.fromCallable {
                   val users_categories = users.categories
                    val roomUsers = users_categories.map { user ->

                        RoomGithubUser(
                            user.idCategory,
                            user.strCategory, user.strCategoryThumb ?: "",
                            user.strCategoryDescription ?: ""
                        )
                    }

                    database.userDao.insert(roomUsers)

                    Thread { RoomGithubPictureCache().newData(users_categories) }.start()
                    users_categories


                }
            }
    }

    override fun fromDataBaseData(): Single<List<GithubUser>> {

        return Single.fromCallable {
            var out = database.userDao.getAll().map { roomUser ->
                GithubUser(
                    roomUser.idCategory, roomUser.strCategory, roomUser.strCategoryThumb,
                    roomUser.strCategoryDescription
                )
            }
            out.forEach {
                val roomUser = it.strCategory.let { database.userDao.findByLogin(it) }
                it.strCategoryThumb = database.pictureDao.findForUser(roomUser.idCategory).local_path
            }
            out
        }
    }

}
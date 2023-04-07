package com.example.courseproject.di.modules

import androidx.room.Room
import com.example.courseproject.App
import com.example.courseproject.domain.cache.IGithubPictureCache

import com.example.courseproject.domain.cache.room.RoomGithubPictureCache
import com.example.courseproject.domain.cache.room.RoomGithubRepositoriesCache
import com.example.courseproject.domain.cache.room.RoomGithubUsersCache
import com.example.courseproject.entity.room.Database
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun database(app: App): Database= Room.databaseBuilder(app, Database::class.java,
        Database.DB_NAME).build()
    @Singleton
    @Provides
    fun roomGithubUsersCache(): RoomGithubUsersCache = RoomGithubUsersCache()
    @Singleton
    @Provides
    fun roomGithubRepositoriesCache(): RoomGithubRepositoriesCache = RoomGithubRepositoriesCache()

    @Singleton
    @Provides
    fun roomGithubPictureCache(): RoomGithubPictureCache = RoomGithubPictureCache()


    @Singleton
    @Provides
    fun pictureCache(): IGithubPictureCache = RoomGithubPictureCache()



}
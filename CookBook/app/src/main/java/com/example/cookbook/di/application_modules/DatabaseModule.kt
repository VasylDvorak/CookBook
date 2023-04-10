package com.example.cookbook.di.application_modules

import androidx.room.Room
import com.example.cookbook.App
import com.example.cookbook.domain.cache.IPictureCache
import com.example.cookbook.domain.cache.room.RoomCategoriesCache
import com.example.cookbook.domain.cache.room.RoomMenuCache
import com.example.cookbook.domain.cache.room.RoomPictureCache
import com.example.cookbook.domain.cache.room.RoomRecipeCache
import com.example.cookbook.entity.room.Database
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
    fun roomCategoriesCache(): RoomCategoriesCache = RoomCategoriesCache()
    @Singleton
    @Provides
    fun roomMenuCache(): RoomMenuCache = RoomMenuCache()
    @Singleton
    @Provides
    fun roomRecipeCache(): RoomRecipeCache = RoomRecipeCache()

    @Singleton
    @Provides
    fun roomPictureCache(): RoomPictureCache = RoomPictureCache()


    @Singleton
    @Provides
    fun pictureCache(): IPictureCache = RoomPictureCache()



}
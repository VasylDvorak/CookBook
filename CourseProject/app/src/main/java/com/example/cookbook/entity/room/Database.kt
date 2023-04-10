package com.example.cookbook.entity.room

import androidx.room.RoomDatabase
import com.example.cookbook.entity.room.dao.PictureDao
import com.example.cookbook.entity.room.dao.RecipeDao
import com.example.cookbook.entity.room.dao.MenuDao
import com.example.cookbook.entity.room.dao.CategoriesDao

@androidx.room.Database(
    entities = [RoomCategory::class,
        RoomMenu::class,
        RoomRecipe::class,
        RoomPicture::class],
    version = 1
)
abstract class Database : RoomDatabase() {
    abstract val categoriesDao: CategoriesDao
    abstract val menuDao: MenuDao
    abstract val recipeDao: RecipeDao
    abstract val pictureDao: PictureDao

    companion object {
        const val DB_NAME = "database_cookbook.db"

    }


}

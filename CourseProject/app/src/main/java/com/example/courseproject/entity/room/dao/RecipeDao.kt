package com.example.courseproject.entity.room.dao

import androidx.room.*
import com.example.courseproject.entity.room.RoomGithubRepository
import com.example.courseproject.entity.room.RoomRecipe


@Dao
interface RecipeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(recipe: RoomRecipe)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg recipes: RoomRecipe)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(recipes: List<RoomRecipe>)

    @Update
    fun update(recipe: RoomRecipe)

    @Update
    fun update(vararg recipes: RoomRecipe)

    @Update
    fun update(recipes: List<RoomRecipe>)

    @Delete
    fun delete(recipe: RoomRecipe)

    @Delete
    fun delete(vararg recipes: RoomRecipe)

    @Delete
    fun delete(recipes: List<RoomRecipe>)

    @Query("SELECT * FROM RoomRecipe")
    fun getAll(): List<RoomRecipe>

    @Query("SELECT * FROM RoomRecipe WHERE idMeal = :idMeal")
    fun findForRepository(idMeal: String): List<RoomRecipe>


}
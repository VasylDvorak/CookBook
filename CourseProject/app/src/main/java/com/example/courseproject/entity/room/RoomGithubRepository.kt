package com.example.courseproject.entity.room

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = RoomGithubUser::class,
        parentColumns = ["idCategory"],
        childColumns = ["idCategory"],
        onDelete = ForeignKey.CASCADE
    )]
)

data class RoomGithubRepository(
    @PrimaryKey var idMeal: String,
    var strMeal: String,
    var strMealThumb: String,
    var idCategory: String
)

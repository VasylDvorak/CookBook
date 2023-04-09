package com.example.courseproject.entity.room

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

@Entity(
    foreignKeys = [ForeignKey(
        entity = RoomGithubUser::class,
        parentColumns = ["idCategory"],
        childColumns = ["idCategory"],
        onDelete = ForeignKey.CASCADE
    )]
)

data class RoomGithubPicture(
    @PrimaryKey var idCategory: String,
    var strCategoryThumb: String,
    var local_path: String
)

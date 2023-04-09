package com.example.courseproject.entity.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

@Entity
data class RoomGithubUser(
    @PrimaryKey var idCategory: String,
var strCategory: String,
var strCategoryThumb: String? =null,
var strCategoryDescription: String? =null
)
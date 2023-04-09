package com.example.courseproject.entity.categories

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUser (
   @Expose var idCategory: String="",
   @Expose var strCategory: String="",
   @Expose var strCategoryThumb: String? =null,
   @Expose var strCategoryDescription: String? =null
) : Parcelable

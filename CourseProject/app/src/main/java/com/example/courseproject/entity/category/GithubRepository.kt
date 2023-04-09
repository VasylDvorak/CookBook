package com.example.courseproject.entity.category

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
class GithubRepository(
    @Expose var idMeal: String,
    @Expose var strMeal: String? = null,
    @Expose var strMealThumb: String? = null
) : Parcelable


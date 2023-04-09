package com.example.courseproject.entity.recipe


import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.Expose

@Parcelize
data class Recipe(
    @Expose var meals: List<Meal>
) : Parcelable
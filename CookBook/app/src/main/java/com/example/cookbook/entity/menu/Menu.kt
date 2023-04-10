package com.example.cookbook.entity.menu

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
class Menu(
    @Expose var idMeal: String,
    @Expose var strMeal: String? = null,
    @Expose var strMealThumb: String? = null
) : Parcelable


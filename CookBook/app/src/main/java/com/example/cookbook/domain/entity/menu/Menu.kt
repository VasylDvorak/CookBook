package com.example.cookbook.domain.entity.menu

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
class Menu(
    @Expose var idMeal: String,
    @Expose var strMeal: String = "",
    @Expose var strMealThumb: String = ""
) : Parcelable


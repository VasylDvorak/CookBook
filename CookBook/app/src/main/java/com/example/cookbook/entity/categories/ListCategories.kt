package com.example.cookbook.entity.categories

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class ListCategories(
    @Expose val categories: List<Category>
)  : Parcelable
package com.example.courseproject.entity.categories

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class Categories(
    @Expose val categories: List<GithubUser>
)  : Parcelable
package com.example.courseproject.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
class GithubPicture(
    @Expose var idCategory: String,
    @Expose var strCategoryThumb: String,
    @Expose var local_path: String
) : Parcelable
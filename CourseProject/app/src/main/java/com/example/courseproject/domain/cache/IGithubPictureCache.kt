package com.example.courseproject.domain.cache

import com.example.courseproject.entity.GithubPicture
import com.example.courseproject.entity.categories.GithubUser
import io.reactivex.rxjava3.core.Single

interface IGithubPictureCache {
    fun newData(users: List<GithubUser>)
    fun fromDataBaseData(): Single<List<GithubPicture>>
}
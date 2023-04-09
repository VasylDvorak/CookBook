package com.example.courseproject.domain.repo

import com.example.courseproject.entity.categories.GithubUser
import io.reactivex.rxjava3.core.Single

interface IGithubUsersRepo {
    fun getUsers (): Single<List<GithubUser>>
}

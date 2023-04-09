package com.example.courseproject.domain.repo.retrofit

import com.example.courseproject.entity.category.GithubRepository
import com.example.courseproject.entity.categories.GithubUser
import io.reactivex.rxjava3.core.Single

interface IGithubRepositoriesRepo {
    fun getRepositories (currentUser : GithubUser): Single<List<GithubRepository>>
}

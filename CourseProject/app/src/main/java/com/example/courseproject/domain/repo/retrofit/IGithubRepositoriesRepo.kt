package com.example.courseproject.domain.repo.retrofit

import com.example.courseproject.entity.GithubRepository
import com.example.courseproject.entity.GithubUser
import io.reactivex.rxjava3.core.Single

interface IGithubRepositoriesRepo {
    fun getRepositories (currentUser : GithubUser): Single<List<GithubRepository>>
}

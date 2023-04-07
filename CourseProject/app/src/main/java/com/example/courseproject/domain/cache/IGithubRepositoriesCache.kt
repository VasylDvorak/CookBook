package com.example.courseproject.domain.cache

import com.example.courseproject.domain.api.IDataSource
import com.example.courseproject.entity.GithubRepository
import com.example.courseproject.entity.GithubUser
import io.reactivex.rxjava3.core.Single

interface IGithubRepositoriesCache {
    fun newData(user: GithubUser, api: IDataSource): Single<List<GithubRepository>>
    fun fromDataBaseData(user: GithubUser): Single<List<GithubRepository>>
}
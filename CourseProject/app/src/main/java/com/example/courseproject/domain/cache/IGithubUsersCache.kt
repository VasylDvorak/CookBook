package com.example.courseproject.domain.cache

import com.example.courseproject.domain.api.IDataSource
import com.example.courseproject.entity.GithubUser
import io.reactivex.rxjava3.core.Single

interface IGithubUsersCache {
    fun newData(api: IDataSource): Single<List<GithubUser>>
    fun fromDataBaseData(): Single<List<GithubUser>>
}
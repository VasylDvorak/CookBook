package com.example.courseproject.domain.api


import com.example.courseproject.entity.GithubRepository
import com.example.courseproject.entity.GithubUser
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface IDataSource {

    @GET( "/users" )
    fun getUsers (): Single<List<GithubUser>>

    @GET
    fun getRepositories (@Url url:String): Single<List<GithubRepository>>

}

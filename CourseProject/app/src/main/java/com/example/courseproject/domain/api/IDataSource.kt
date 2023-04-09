package com.example.courseproject.domain.api


import com.example.courseproject.entity.categories.Categories
import com.example.courseproject.entity.category.Category
import com.example.courseproject.entity.category.GithubRepository
import com.example.courseproject.entity.recipe.Recipe
import io.reactivex.rxjava3.core.Single
import retrofit2.http.*

interface IDataSource {

    @GET("api/json/v1/1/{categories}")
    fun getUsers (
        @Path("categories") request: String = "categories.php"
        ): Single<Categories>

    @GET("api/json/v1/1/filter.php")
    fun getRepositories (@Query("c") c: String?): Single<Category>

    @GET("api/json/v1/1/lookup.php")
    fun getRecipe (@Query("i") i: String?): Single<Recipe>
}

package com.example.cookbook.domain.api


import com.example.cookbook.entity.categories.ListCategories
import com.example.cookbook.entity.menu.ListMenu
import com.example.cookbook.entity.room.recipe.Recipe
import io.reactivex.rxjava3.core.Single
import retrofit2.http.*

interface IDataSource {

    @GET("api/json/v1/1/{categories}")
    fun getCategories (
        @Path("categories") request: String = "categories.php"
        ): Single<ListCategories>

    @GET("api/json/v1/1/filter.php")
    fun getMenu (@Query("c") c: String?): Single<ListMenu>

    @GET("api/json/v1/1/lookup.php")
    fun getRecipe (@Query("i") i: String?): Single<Recipe>
}

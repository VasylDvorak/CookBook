package com.example.cookbook.data.network.api


import com.example.cookbook.domain.entity.categories.ListCategories
import com.example.cookbook.domain.entity.menu.ListMenu
import com.example.cookbook.domain.entity.recipe.Recipe
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

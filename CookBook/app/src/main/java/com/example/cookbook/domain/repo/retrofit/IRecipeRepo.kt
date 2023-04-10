package com.example.cookbook.domain.repo.retrofit

import com.example.cookbook.entity.menu.Menu
import com.example.cookbook.entity.room.recipe.Meal
import io.reactivex.rxjava3.core.Single

interface IRecipeRepo {
    fun getRecipes (currentItemMenu : Menu): Single<List<Meal>>
}

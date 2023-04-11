package com.example.cookbook.domain.repository.retrofit

import com.example.cookbook.domain.entity.menu.Menu
import com.example.cookbook.domain.entity.recipe.Meal
import io.reactivex.rxjava3.core.Single

interface IRecipeRepo {
    fun getRecipes (currentItemMenu : Menu): Single<List<Meal>>
}

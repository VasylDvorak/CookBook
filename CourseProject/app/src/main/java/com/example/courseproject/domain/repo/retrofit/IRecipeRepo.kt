package com.example.courseproject.domain.repo.retrofit

import com.example.courseproject.entity.category.GithubRepository
import com.example.courseproject.entity.categories.GithubUser
import com.example.courseproject.entity.recipe.Meal
import io.reactivex.rxjava3.core.Single

interface IRecipeRepo {
    fun getRecipes (currentRepository : GithubRepository): Single<List<Meal>>
}

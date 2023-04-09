package com.example.courseproject.domain.cache

import com.example.courseproject.domain.api.IDataSource
import com.example.courseproject.entity.category.GithubRepository
import com.example.courseproject.entity.categories.GithubUser
import com.example.courseproject.entity.recipe.Meal
import com.example.courseproject.entity.recipe.Recipe
import io.reactivex.rxjava3.core.Single

interface IRecipeCache {
    fun newData(repository: GithubRepository, api: IDataSource): Single<List<Meal>>
    fun fromDataBaseData(repository: GithubRepository): Single<List<Meal>>
}
package com.example.cookbook.domain.cache

import com.example.cookbook.domain.api.IDataSource
import com.example.cookbook.entity.menu.Menu
import com.example.cookbook.entity.room.recipe.Meal
import io.reactivex.rxjava3.core.Single

interface IRecipeCache {
    fun newData(repository: Menu, api: IDataSource): Single<List<Meal>>
    fun fromDataBaseData(repository: Menu): Single<List<Meal>>
}
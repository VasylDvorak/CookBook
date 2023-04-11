package com.example.cookbook.domain.cache.cahe_interfaces

import com.example.cookbook.data.network.api.IDataSource
import com.example.cookbook.domain.entity.menu.Menu
import com.example.cookbook.domain.entity.recipe.Meal
import io.reactivex.rxjava3.core.Single

interface IRecipeCache {
    fun newData(repository: Menu, api: IDataSource): Single<List<Meal>>
    fun fromDataBaseData(repository: Menu): Single<List<Meal>>
}
package com.example.cookbook.domain.cache

import com.example.cookbook.domain.api.IDataSource
import com.example.cookbook.entity.menu.Menu
import com.example.cookbook.entity.categories.Category
import io.reactivex.rxjava3.core.Single

interface IMenuCache {
    fun newData(category: Category, api: IDataSource): Single<List<Menu>>
    fun fromDataBaseData(user: Category): Single<List<Menu>>
}
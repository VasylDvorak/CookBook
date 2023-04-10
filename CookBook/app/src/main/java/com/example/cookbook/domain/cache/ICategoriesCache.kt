package com.example.cookbook.domain.cache

import com.example.cookbook.domain.api.IDataSource
import com.example.cookbook.entity.categories.Category
import io.reactivex.rxjava3.core.Single

interface ICategoriesCache {
    fun newData(api: IDataSource): Single<List<Category>>
    fun fromDataBaseData(): Single<List<Category>>
}
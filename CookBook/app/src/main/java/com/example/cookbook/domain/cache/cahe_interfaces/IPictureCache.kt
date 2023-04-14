package com.example.cookbook.domain.cache.cahe_interfaces

import com.example.cookbook.domain.entity.PictureEnity
import com.example.cookbook.domain.entity.entity_categories.Category
import io.reactivex.rxjava3.core.Single

interface IPictureCache {
    fun newData(categories: List<Category>)
    fun fromDataBaseData(): Single<List<PictureEnity>>
}
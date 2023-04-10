package com.example.cookbook.domain.cache

import com.example.cookbook.entity.PictureEnity
import com.example.cookbook.entity.categories.Category
import io.reactivex.rxjava3.core.Single

interface IPictureCache {
    fun newData(categories: List<Category>)
    fun fromDataBaseData(): Single<List<PictureEnity>>
}
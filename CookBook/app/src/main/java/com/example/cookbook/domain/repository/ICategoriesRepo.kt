package com.example.cookbook.domain.repository

import com.example.cookbook.domain.entity.categories.Category
import io.reactivex.rxjava3.core.Single

interface ICategoriesRepo {
    fun getCategories (): Single<List<Category>>
}

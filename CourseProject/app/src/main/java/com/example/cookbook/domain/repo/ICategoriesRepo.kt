package com.example.cookbook.domain.repo

import com.example.cookbook.entity.categories.Category
import io.reactivex.rxjava3.core.Single

interface ICategoriesRepo {
    fun getCategories (): Single<List<Category>>
}

package com.example.cookbook.domain.repository.retrofit

import com.example.cookbook.domain.entity.menu.Menu
import com.example.cookbook.domain.entity.categories.Category
import io.reactivex.rxjava3.core.Single

interface IMenuRepo {
    fun getMenu (currentCategory : Category): Single<List<Menu>>
}

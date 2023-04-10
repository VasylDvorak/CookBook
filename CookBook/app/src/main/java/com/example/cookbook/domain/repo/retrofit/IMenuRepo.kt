package com.example.cookbook.domain.repo.retrofit

import com.example.cookbook.entity.menu.Menu
import com.example.cookbook.entity.categories.Category
import io.reactivex.rxjava3.core.Single

interface IMenuRepo {
    fun getMenu (currentCategory : Category): Single<List<Menu>>
}

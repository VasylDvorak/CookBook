package com.example.cookbook.ui.categories_fragment

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface CategoriesView : MvpView {
    fun init()
    fun updateList()
    fun release()
}

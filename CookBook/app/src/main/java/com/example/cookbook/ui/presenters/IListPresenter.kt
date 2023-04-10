package com.example.cookbook.ui.presenters

import com.example.cookbook.ui.categories_fragment.IItemView
import com.example.cookbook.ui.categories_fragment.CategoryItemView

interface IListPresenter <V : IItemView> {

    var itemClickListener: ((V) -> Unit )?
    fun bindView (view: V)
    fun getCount (): Int }

interface ICategoryListPresenter : IListPresenter<CategoryItemView>


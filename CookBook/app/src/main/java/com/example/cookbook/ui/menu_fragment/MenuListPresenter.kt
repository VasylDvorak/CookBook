package com.example.cookbook.ui.menu_fragment

import com.example.cookbook.domain.repo.MenuItemView
import com.example.cookbook.domain.repo.MenItemView


interface MenuListPresenter <V : MenuItemView> {

    var itemClickListener: ((V) -> Unit )?
    fun bindView (view: V)
    fun getCount (): Int }


interface MenListPresenter : MenuListPresenter<MenItemView>

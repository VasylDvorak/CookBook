package com.example.courseproject.ui.presenters

import com.example.courseproject.ui.users.IItemView
import com.example.courseproject.ui.users.UserItemView

interface IListPresenter <V : IItemView> {

    var itemClickListener: ((V) -> Unit )?
    fun bindView (view: V)
    fun getCount (): Int }

interface IUserListPresenter : IListPresenter<UserItemView>


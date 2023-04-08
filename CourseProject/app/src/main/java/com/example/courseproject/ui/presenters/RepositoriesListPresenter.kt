package com.example.courseproject.ui.presenters

import com.example.courseproject.domain.repo.ReposItemView
import com.example.courseproject.domain.repo.RepositoryItemView

interface RepositoriesListPresenter <V : RepositoryItemView> {

    var itemClickListener: ((V) -> Unit )?
    fun bindView (view: V)
    fun getCount (): Int }


interface RepositListPresenter : RepositoriesListPresenter<ReposItemView>

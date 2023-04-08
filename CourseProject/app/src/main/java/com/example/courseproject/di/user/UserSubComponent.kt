package com.example.courseproject.di.user


import com.example.courseproject.di.repository.RepositorySubcomponent
import com.example.courseproject.di.user.module.UserModule
import com.example.courseproject.ui.presenters.UsersPresenter
import com.example.courseproject.ui.users.UsersRVAdapter
import dagger.Subcomponent

@UserScope
@Subcomponent(
    modules = [
        UserModule::class
    ]
)
interface UserSubcomponent {
   fun repositorySubcomponent(): RepositorySubcomponent
    fun inject(usersPresenter: UsersPresenter)
    fun inject(usersRVAdapter: UsersRVAdapter)
}
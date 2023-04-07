package com.example.courseproject.ui

import android.os.Bundle
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.example.courseproject.entity.GithubRepository
import com.example.courseproject.entity.GithubUser
import com.example.courseproject.ui.interfaces.IScreens
import com.example.courseproject.ui.repositories.CURRENT_USER
import com.example.courseproject.ui.repositories.RepositoriesFragment
import com.example.courseproject.ui.users.UsersFragment

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }


    override fun repositories(currentUser: GithubUser): Screen = FragmentScreen {
        RepositoriesFragment.newInstance(Bundle().apply {
            putParcelable(
                CURRENT_USER,
                currentUser
            )
        })
    }

    override fun aboutRepository(infoRepository: GithubRepository): Screen = FragmentScreen {
        AboutRepositoryFragment.newInstance(Bundle().apply {
            putParcelable(
                REPOSITORY,
                infoRepository
            )
        })
    }


}




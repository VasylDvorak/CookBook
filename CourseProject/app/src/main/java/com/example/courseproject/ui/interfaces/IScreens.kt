package com.example.courseproject.ui.interfaces

import com.github.terrakok.cicerone.Screen
import com.example.courseproject.entity.GithubRepository
import com.example.courseproject.entity.GithubUser

interface IScreens {

    fun users(): Screen
    fun aboutRepository(infoRepository: GithubRepository): Screen
    fun repositories(currentUser: GithubUser): Screen

}

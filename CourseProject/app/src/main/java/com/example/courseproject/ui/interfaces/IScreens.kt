package com.example.courseproject.ui.interfaces

import com.github.terrakok.cicerone.Screen
import com.example.courseproject.entity.category.GithubRepository
import com.example.courseproject.entity.categories.GithubUser

interface IScreens {

    fun users(): Screen
    fun aboutRecipe(infoRepository: GithubRepository): Screen
    fun repositories(currentUser: GithubUser): Screen
    fun playMovie(playMovie: String): Screen

}

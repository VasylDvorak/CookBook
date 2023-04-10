package com.example.cookbook.ui.main_activity.interfaces

import com.github.terrakok.cicerone.Screen
import com.example.cookbook.entity.menu.Menu
import com.example.cookbook.entity.categories.Category

interface IScreens {

    fun categories(): Screen
    fun aboutRecipe(infoMenu: Menu): Screen
    fun menu(currentCategory: Category): Screen
    fun playMovie(playMovie: String): Screen

}

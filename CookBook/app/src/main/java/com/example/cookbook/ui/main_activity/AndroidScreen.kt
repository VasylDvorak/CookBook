package com.example.cookbook.ui.main_activity

import android.os.Bundle
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.example.cookbook.entity.menu.Menu
import com.example.cookbook.entity.categories.Category
import com.example.cookbook.ui.main_activity.interfaces.IScreens
import com.example.cookbook.ui.play_movie_fragment.PLAY_MOVIE
import com.example.cookbook.ui.play_movie_fragment.PlayMovieFragment
import com.example.cookbook.ui.recipe_fragment.CURRENT_RECIPE
import com.example.cookbook.ui.recipe_fragment.RecipeFragment
import com.example.cookbook.ui.menu_fragment.CURRENT_CATEGORY
import com.example.cookbook.ui.menu_fragment.MenuFragment
import com.example.cookbook.ui.categories_fragment.CategoriesFragment

class AndroidScreens : IScreens {
    override fun categories() = FragmentScreen { CategoriesFragment.newInstance() }


    override fun menu(currentCategory: Category): Screen = FragmentScreen {
        MenuFragment.newInstance(Bundle().apply {
            putParcelable(
                CURRENT_CATEGORY,
                currentCategory
            )
        })
    }

    override fun aboutRecipe(infoMenu: Menu): Screen = FragmentScreen {
        RecipeFragment.newInstance(Bundle().apply {
            putParcelable(
                CURRENT_RECIPE,
                infoMenu
            )
        })
    }
    override fun playMovie(playMovie: String): Screen = FragmentScreen {
        PlayMovieFragment.newInstance(Bundle().apply {
            putString(
                PLAY_MOVIE,
                playMovie
            )
        })
    }



}




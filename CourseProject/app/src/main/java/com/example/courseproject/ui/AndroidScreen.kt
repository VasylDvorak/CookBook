package com.example.courseproject.ui

import android.os.Bundle
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.example.courseproject.entity.category.GithubRepository
import com.example.courseproject.entity.categories.GithubUser
import com.example.courseproject.ui.interfaces.IScreens
import com.example.courseproject.ui.play_movie_fragment.PLAY_MOVIE
import com.example.courseproject.ui.play_movie_fragment.PlayMovieFragment
import com.example.courseproject.ui.recipe_fragment.CURRENT_RECIPE
import com.example.courseproject.ui.recipe_fragment.RecipeFragment
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

    override fun aboutRecipe(infoRepository: GithubRepository): Screen = FragmentScreen {
        RecipeFragment.newInstance(Bundle().apply {
            putParcelable(
                CURRENT_RECIPE,
                infoRepository
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




package com.example.cookbook.ui.main_activity

import com.example.cookbook.ui.main_activity.interfaces.MainView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import javax.inject.Inject

class MainPresenter () :
    MvpPresenter<MainView>() {
    @Inject
    lateinit var router: Router
    override fun onFirstViewAttach () {
        super.onFirstViewAttach()
        router.replaceScreen(AndroidScreens().categories())
    }

    fun backClicked () {
        router.exit()
    }
}

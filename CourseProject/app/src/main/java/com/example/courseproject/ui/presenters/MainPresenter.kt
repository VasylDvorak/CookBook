package com.example.courseproject.ui.presenters

import com.example.courseproject.ui.AndroidScreens
import com.example.courseproject.ui.interfaces.MainView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import javax.inject.Inject

class MainPresenter () :
    MvpPresenter<MainView>() {
    @Inject
    lateinit var router: Router
    override fun onFirstViewAttach () {
        super.onFirstViewAttach()
        router.replaceScreen(AndroidScreens().users())
    }

    fun backClicked () {
        router.exit()
    }
}

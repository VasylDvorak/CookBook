package com.example.cookbook.ui.menu_fragment


import com.example.cookbook.domain.repo.MenItemView
import com.example.cookbook.domain.repo.retrofit.IMenuRepo
import com.example.cookbook.entity.categories.Category
import com.example.cookbook.entity.menu.Menu
import com.example.cookbook.ui.categories_fragment.CategoriesView
import com.example.cookbook.ui.main_activity.AndroidScreens
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import javax.inject.Inject

class MenuPresenter: MvpPresenter<CategoriesView>() {

    @Inject
    lateinit var mainThreadScheduler: Scheduler
    @Inject
    lateinit var menuRepo: IMenuRepo
    @Inject
    lateinit var router:Router


    class MenuListPresenter : MenListPresenter {
        val menus = mutableListOf<Menu>()
        override var itemClickListener: ((MenItemView) -> Unit)? = null
        override fun getCount() = menus.size
        override fun bindView(view: MenItemView) {
            val menu = menus[view.pos]
            menu.let { it.strMeal?.let { it_one -> view.setName(it_one) } }
           menu.let { it.strMealThumb?.let { it_one -> view.loadPicture(it_one) } }
        }
    }



    val menuListPresenter = MenuListPresenter()


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()

    }

    fun loadMenu(currentCategory: Category) {
        menuRepo.getMenu(currentCategory)
            .observeOn(mainThreadScheduler)
            .subscribe({ menus ->
                menuListPresenter.menus.apply {
                    clear()
                    addAll(menus)
                }

                viewState.updateList()
            }, {
                println("Error: ${it.message} ")
            })

        menuListPresenter.itemClickListener = { itemView ->
            val infoMenu = menuListPresenter.menus[itemView.pos]


            router.navigateTo(AndroidScreens().aboutRecipe(infoMenu))
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        viewState.release()
    }
    fun backPressed(): Boolean {
        router.replaceScreen(AndroidScreens().categories())
        return true
    }
}

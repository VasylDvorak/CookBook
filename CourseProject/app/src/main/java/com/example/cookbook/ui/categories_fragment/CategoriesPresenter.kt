package com.example.cookbook.ui.categories_fragment

import com.github.terrakok.cicerone.Router
import com.example.cookbook.domain.repo.ICategoriesRepo
import com.example.cookbook.entity.categories.Category
import com.example.cookbook.ui.main_activity.AndroidScreens
import com.example.cookbook.ui.presenters.ICategoryListPresenter
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import javax.inject.Inject

class CategoriesPresenter: MvpPresenter<CategoriesView>() {
    @Inject
    lateinit var  mainThreadScheduler: Scheduler
@Inject
lateinit var categoriesRepo:ICategoriesRepo
@Inject
lateinit var router:Router
    inner class CategoriesListPresenter : ICategoryListPresenter {
        val categories = mutableListOf<Category>()
        override var itemClickListener: ((CategoryItemView) -> Unit)? = null
        override fun getCount() = categories.size
        override fun bindView(view: CategoryItemView) {
            val category = categories[view.pos]
            category.apply {
              strCategory.let { view.setName(it) }
              strCategoryThumb?.let {
                    view.loadPicture(it)
                }
            }

        }
    }


    val categoriesListPresenter = CategoriesListPresenter()


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        categoriesListPresenter.itemClickListener = { itemView ->
            val currentCategory = categoriesListPresenter.categories[itemView.pos]
//  переход на экран пользователя c помощью router.navigateTo
            currentCategory.let {
                router.navigateTo(AndroidScreens().menu(currentCategory))
            }
        }
    }

    fun loadData() {
        categoriesRepo.getCategories()
            .observeOn(mainThreadScheduler)
            .subscribe({ categories ->
                categoriesListPresenter.categories.clear()
                categoriesListPresenter.categories.addAll(categories)
                viewState.updateList()
            }, {
                println("Error: ${it.message} ")
            })
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

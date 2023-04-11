package com.example.cookbook.ui.categories_fragment.categories_presenters

import com.example.cookbook.application.App
import com.example.cookbook.R
import com.github.terrakok.cicerone.Router
import com.example.cookbook.domain.repository.ICategoriesRepo
import com.example.cookbook.domain.entity.categories.Category
import com.example.cookbook.ui.categories_fragment.CategoriesView
import com.example.cookbook.ui.categories_fragment.CategoryItemView
import com.example.cookbook.ui.main_activity.AndroidScreens
import com.example.cookbook.ui.main_activity.GONE
import com.example.cookbook.ui.main_activity.VISIBLE
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
        loadCategories()

        categoriesListPresenter.itemClickListener = { itemView ->
            val currentCategory = categoriesListPresenter.categories[itemView.pos]

            currentCategory.let {
                router.navigateTo(AndroidScreens().menu(currentCategory))
            }
        }
    }

    fun loadCategories() {
        viewState.progressCircle(VISIBLE)
        categoriesRepo.getCategories()
            .observeOn(mainThreadScheduler)
            .subscribe({ categories ->
                if(categories.size !=0){
                    viewState.progressCircle(GONE)
                    categoriesListPresenter.categories.apply {
                        clear()
                        addAll(categories)
                    }
                    viewState.updateList()}
                else{
                    showError()
                }
            }, {
                showError()
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

    fun showError(){
        val context = App.instance.applicationContext
        viewState.apply{
            progressCircle(GONE)
            showToastFragment(context!!.getString(R.string.check_internet))
        }
    }
}

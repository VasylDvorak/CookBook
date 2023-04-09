package com.example.courseproject.ui.presenters


import com.example.courseproject.domain.repo.ReposItemView
import com.example.courseproject.domain.repo.retrofit.IGithubRepositoriesRepo
import com.example.courseproject.entity.category.GithubRepository
import com.example.courseproject.entity.categories.GithubUser
import com.example.courseproject.ui.AndroidScreens
import com.example.courseproject.ui.interfaces.UsersView
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import javax.inject.Inject

class RepositoriesPresenter: MvpPresenter<UsersView>() {

    @Inject
    lateinit var mainThreadScheduler: Scheduler
    @Inject
    lateinit var repositoriesRepo: IGithubRepositoriesRepo
    @Inject
    lateinit var router:Router


    class RepositoriesListPresenter : RepositListPresenter {
        val repositories = mutableListOf<GithubRepository>()
        override var itemClickListener: ((ReposItemView) -> Unit)? = null
        override fun getCount() = repositories.size
        override fun bindView(view: ReposItemView) {
            val repository = repositories[view.pos]
            repository.let { it.strMeal?.let { it_one -> view.setName(it_one) } }
           repository.let { it.strMealThumb?.let { it_one -> view.loadAvatar(it_one) } }
        }
    }



    val repositoriesListPresenter = RepositoriesListPresenter()


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()

    }

    fun loadRepositories(currentUser: GithubUser) {
//App.instance.appComponent.inject(this)
        repositoriesRepo.getRepositories(currentUser)
            .observeOn(mainThreadScheduler)
            .subscribe({ repos ->
                repositoriesListPresenter.repositories.clear()
                repositoriesListPresenter.repositories.addAll(repos)

                viewState.updateList()
            }, {
                println("Error: ${it.message} ")
            })

        repositoriesListPresenter.itemClickListener = { itemView ->
            val infoRepository = repositoriesListPresenter.repositories[itemView.pos]


            router.navigateTo(AndroidScreens().aboutRecipe(infoRepository))
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        viewState.release()
    }
    fun backPressed(): Boolean {
        router.replaceScreen(AndroidScreens().users())
        return true
    }
}

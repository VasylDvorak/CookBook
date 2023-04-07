package com.example.courseproject.ui.repositories

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.courseproject.App
import com.example.courseproject.databinding.FragmentRepositoriesBinding
import com.example.courseproject.entity.GithubUser
import com.example.courseproject.ui.interfaces.BackButtonListener
import com.example.courseproject.ui.interfaces.UsersView
import com.example.courseproject.ui.presenters.RepositoriesPresenter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

const val CURRENT_USER = "current_user"

class RepositoriesFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {

    private lateinit var currentUser: GithubUser

    companion object {
        fun newInstance(bundle: Bundle): RepositoriesFragment {
            val fragment = RepositoriesFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    private var _vb: FragmentRepositoriesBinding? = null
    private val vb
        get() = _vb!!


    private val presenter: RepositoriesPresenter by moxyPresenter {
        RepositoriesPresenter(
            AndroidSchedulers.mainThread()
        ).apply {
            App.instance.appComponent.inject(this)
        }
    }
    var adapter: RepositoriesRVAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        currentUser = (arguments?.getParcelable(CURRENT_USER) as GithubUser?)!!
        _vb = FragmentRepositoriesBinding.inflate(inflater, container, false)

        return vb.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _vb = null
    }

    @SuppressLint("SuspiciousIndentation")
    override fun init() {
        vb.apply {
            rvRepositories.layoutManager = LinearLayoutManager(context)
            currentUser.let { presenter.loadRepositories(it) }
            adapter = RepositoriesRVAdapter(presenter.repositoriesListPresenter)
            vb.rvRepositories.adapter = adapter
        }
    }


    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()

}

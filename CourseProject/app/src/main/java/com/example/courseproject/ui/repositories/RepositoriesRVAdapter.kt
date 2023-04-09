package com.example.courseproject.ui.repositories

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.courseproject.databinding.ItemRepositoryBinding
import com.example.courseproject.databinding.ItemUserBinding
import com.example.courseproject.domain.image.IImageLoader
import com.example.courseproject.domain.repo.ReposItemView
import com.example.courseproject.ui.presenters.RepositListPresenter
import com.example.courseproject.ui.users.UserItemView
import javax.inject.Inject

class RepositoriesRVAdapter(val presenter: RepositListPresenter) :
    RecyclerView.Adapter<RepositoriesRVAdapter.ViewHolder>() {





    @Inject
    lateinit var imageLoader: IImageLoader<ImageView>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemRepositoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        ).apply {
            itemView.setOnClickListener {
                presenter.itemClickListener?.invoke(this)
            }
        }

    override fun getItemCount() = presenter.getCount()


    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        presenter.bindView(holder.apply { pos = position })


    inner class ViewHolder(val vb: ItemRepositoryBinding) :
        RecyclerView.ViewHolder(vb.root), ReposItemView {
        override var pos = -1
        override fun setName(text: String) = with(vb) {
            tvLogin.text = text
        }


        override fun loadAvatar(url: String) {
            imageLoader.loadInto(url, vb.ivAvatar)
        }

    }
}

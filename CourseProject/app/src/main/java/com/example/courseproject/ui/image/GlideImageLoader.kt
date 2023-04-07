package com.example.courseproject.ui.image

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.courseproject.domain.image.IImageLoader


class GlideImageLoader :

    IImageLoader <ImageView > {
    override fun loadInto(url: String, container: ImageView) {
        Glide.with(container.context)
            .load(url)
            .placeholder(com.example.courseproject.R.drawable.ic_baseline_badge_24)
            .into(container)


    }
}

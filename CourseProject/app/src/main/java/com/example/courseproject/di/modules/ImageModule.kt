package com.example.courseproject.di.modules

import android.widget.ImageView
import com.example.courseproject.domain.image.IImageLoader
import com.example.courseproject.ui.image.GlideImageLoader
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ImageModule {

    @Singleton
    @Provides
    fun imageLoader(): IImageLoader<ImageView> = GlideImageLoader()
}
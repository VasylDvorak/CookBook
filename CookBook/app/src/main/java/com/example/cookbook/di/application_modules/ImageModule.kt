package com.example.cookbook.di.application_modules

import android.widget.ImageView
import com.example.cookbook.domain.image.IImageLoader
import com.example.cookbook.ui.utils.image_loader.GlideImageLoader
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ImageModule {
    @Singleton
    @Provides
    fun imageLoader(): IImageLoader<ImageView> = GlideImageLoader()
}
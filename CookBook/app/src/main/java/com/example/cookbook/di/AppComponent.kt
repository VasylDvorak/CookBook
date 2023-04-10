package com.example.cookbook.di

import com.example.cookbook.di.application_modules.*
import com.example.cookbook.di.categories.CategoriesSubcomponent
import com.example.cookbook.domain.cache.room.RoomPictureCache
import com.example.cookbook.domain.cache.room.RoomRecipeCache
import com.example.cookbook.domain.cache.room.RoomMenuCache
import com.example.cookbook.domain.cache.room.RoomCategoriesCache
import com.example.cookbook.domain.repo.retrofit.RetrofitMenuRepo
import com.example.cookbook.domain.repo.retrofit.RetrofitCategoriesRepo
import com.example.cookbook.domain.repo.retrofit.RetrofitRecipeRepo
import com.example.cookbook.ui.main_activity.MainActivity
import com.example.cookbook.ui.main_activity.MainPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        CiceroneModule::class,
        DatabaseModule::class,
        ApiModule::class,
        ImageModule::class
    ]
)
interface AppComponent {
    fun categoriesSubcomponent(): CategoriesSubcomponent

    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)

    fun inject(retrofitCategoriesRepo: RetrofitCategoriesRepo)
    fun inject(roomCategoriesCache: RoomCategoriesCache)

    fun inject(retrofitMenuRepo: RetrofitMenuRepo)
    fun inject(roomMenuCache: RoomMenuCache)

    fun inject(retrofitRecipeRepo: RetrofitRecipeRepo)
    fun inject(roomRecipeCache: RoomRecipeCache)

    fun inject(roomPictureCache: RoomPictureCache)

}
package com.example.courseproject.di

import com.example.courseproject.di.modules.*
import com.example.courseproject.di.user.UserSubcomponent
import com.example.courseproject.domain.cache.room.RoomGithubPictureCache
import com.example.courseproject.domain.cache.room.RoomRecipeCache
import com.example.courseproject.domain.cache.room.RoomGithubRepositoriesCache
import com.example.courseproject.domain.cache.room.RoomGithubUsersCache
import com.example.courseproject.domain.repo.retrofit.RetrofitGithubRepositoriesRepo
import com.example.courseproject.domain.repo.retrofit.RetrofitGithubUsersRepo
import com.example.courseproject.domain.repo.retrofit.RetrofitRecipeRepo
import com.example.courseproject.ui.MainActivity
import com.example.courseproject.ui.presenters.MainPresenter
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
    fun userSubcomponent(): UserSubcomponent

    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(retrofitGithubUsersRepo: RetrofitGithubUsersRepo)
    fun inject(roomGithubUsersCache: RoomGithubUsersCache)
    fun inject(retrofitGithubRepositoriesRepo: RetrofitGithubRepositoriesRepo)
    fun inject(roomGithubRepositoriesCache: RoomGithubRepositoriesCache)

    fun inject(retrofitRecipeRepo: RetrofitRecipeRepo)

    fun inject(roomGithubRecipeCache: RoomRecipeCache)
    fun inject(roomGithubPictureCache: RoomGithubPictureCache)

}
package com.example.courseproject.di



import com.example.courseproject.di.modules.*
import com.example.courseproject.domain.cache.room.RoomGithubPictureCache
import com.example.courseproject.domain.cache.room.RoomGithubRepositoriesCache
import com.example.courseproject.domain.cache.room.RoomGithubUsersCache
import com.example.courseproject.domain.repo.retrofit.RetrofitGithubRepositoriesRepo
import com.example.courseproject.domain.repo.retrofit.RetrofitGithubUsersRepo
import com.example.courseproject.ui.MainActivity
import com.example.courseproject.ui.presenters.MainPresenter
import com.example.courseproject.ui.presenters.RepositoriesPresenter
import com.example.courseproject.ui.presenters.UsersPresenter

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        CiceroneModule::class,
        DatabaseModule::class,
        ApiModule::class,
        RepoModule::class
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(usersPresenter: UsersPresenter)
    fun inject(repositoriesPresenter: RepositoriesPresenter)
    fun inject(retrofitGithubUsersRepo: RetrofitGithubUsersRepo)
    fun inject(retrofitGithubRepositoriesRepo: RetrofitGithubRepositoriesRepo)
    fun inject(roomGithubUsersCache: RoomGithubUsersCache)
    fun inject(roomGithubRepositoriesCache: RoomGithubRepositoriesCache)
    fun inject(roomGithubPictureCache: RoomGithubPictureCache)
}
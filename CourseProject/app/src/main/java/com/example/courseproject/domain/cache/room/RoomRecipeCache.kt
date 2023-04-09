package com.example.courseproject.domain.cache.room

import com.example.courseproject.App
import com.example.courseproject.domain.api.IDataSource
import com.example.courseproject.domain.cache.IRecipeCache
import com.example.courseproject.entity.category.GithubRepository
import com.example.courseproject.entity.categories.GithubUser
import com.example.courseproject.entity.recipe.Meal
import com.example.courseproject.entity.recipe.Recipe
import com.example.courseproject.entity.room.Database
import com.example.courseproject.entity.room.RoomRecipe
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject


class RoomRecipeCache : IRecipeCache {
    @Inject
    lateinit var database: Database
    init{
        App.instance.appComponent.inject(this)
    }
    override fun newData(repository: GithubRepository, api: IDataSource): Single<List<Meal>> {
        return repository.idMeal?.let { url ->
            api.getRecipe(url)
                .flatMap { recipe ->
                    Single.fromCallable {
                        val meals = recipe.meals
                            val roomRepos = meals?.map {
                                RoomRecipe(
                                    it.idMeal ?: "",
                                    it?.dateModified ?: "",
                                    it?.strArea ?: "",
                                    it?.strCategory ?: "",
                                    it?.strCreativeCommonsConfirmed ?: "",
                                    it?.strDrinkAlternate ?: "",
                                    it?.strImageSource ?: "",
                                    it?.strIngredient1 ?: "",
                                    it?.strIngredient10 ?: "",
                                    it?.strIngredient11 ?: "",
                                    it?.strIngredient12 ?: "",
                                    it?.strIngredient13 ?: "",
                                    it?.strIngredient14 ?: "",
                                    it?.strIngredient15 ?: "",
                                    it?.strIngredient16 ?: "",
                                    it?.strIngredient17 ?: "",
                                    it?.strIngredient18 ?: "",
                                    it?.strIngredient19 ?: "",
                                    it?.strIngredient2 ?: "",
                                    it?.strIngredient20 ?: "",
                                    it?.strIngredient3 ?: "",
                                    it?.strIngredient4 ?: "",
                                    it?.strIngredient5 ?: "",
                                    it?.strIngredient6 ?: "",
                                    it?.strIngredient7 ?: "",
                                    it?.strIngredient8 ?: "",
                                    it?.strIngredient9 ?: "",
                                    it?.strInstructions ?: "",
                                    it?.strMeal ?: "",
                                    it?.strMealThumb ?: "",
                                    it?.strMeasure1 ?: "",
                                    it?.strMeasure10 ?: "",
                                    it?.strMeasure11 ?: "",
                                    it?.strMeasure12 ?: "",
                                    it?.strMeasure13 ?: "",
                                    it?.strMeasure14 ?: "",
                                    it?.strMeasure15 ?: "",
                                    it?.strMeasure16 ?: "",
                                    it?.strMeasure17 ?: "",
                                    it?.strMeasure18 ?: "",
                                    it?.strMeasure19 ?: "",
                                    it?.strMeasure2 ?: "",
                                    it?.strMeasure20 ?: "",
                                    it?.strMeasure3 ?: "",
                                    it?.strMeasure4 ?: "",
                                    it?.strMeasure5 ?: "",
                                    it?.strMeasure6 ?: "",
                                    it?.strMeasure7 ?: "",
                                    it?.strMeasure8 ?: "",
                                    it?.strMeasure9 ?: "",
                                    it?.strSource ?: "",
                                    it?.strTags ?: "",
                                    it?.strYoutube ?: ""
                                )
                            }
                            database.recipeDao.insert(roomRepos!!)
                        meals

                    }
                }
        }!!
//            ?: Single.error<List<Meal>(RuntimeException("Meals no repos url"))
//                .subscribeOn(Schedulers.io())
    }


    override fun fromDataBaseData(repository: GithubRepository): Single<List<Meal>> {
        return Single.fromCallable {


            database.recipeDao.findForRepository(repository.idMeal).map {
                Meal(
                    it?.idMeal ?: "",
                    it?.dateModified ?: "",
                    it?.strArea ?: "",
                    it?.strCategory?: "",
                    it?.strCreativeCommonsConfirmed?: "",
                    it?.strDrinkAlternate?: "",
                    it?.strImageSource?: "",
                    it?.strIngredient1?: "",
                    it?.strIngredient10?: "",
                    it?.strIngredient11?: "",
                    it?.strIngredient12?: "",
                    it?.strIngredient13?: "",
                    it?.strIngredient14?: "",
                    it?.strIngredient15?: "",
                    it?.strIngredient16?: "",
                    it?.strIngredient17?: "",
                    it?.strIngredient18?: "",
                    it?.strIngredient19?: "",
                    it?.strIngredient2?: "",
                    it?.strIngredient20?: "",
                    it?.strIngredient3?: "",
                    it?.strIngredient4?: "",
                    it?.strIngredient5?: "",
                    it?.strIngredient6?: "",
                    it?.strIngredient7?: "",
                    it?.strIngredient8?: "",
                    it?.strIngredient9?: "",
                    it?.strInstructions?: "",
                    it?.strMeal?: "",
                    it?.strMealThumb?: "",
                    it?.strMeasure1?: "",
                    it?.strMeasure10?: "",
                    it?.strMeasure11?: "",
                    it?.strMeasure12?: "",
                    it?.strMeasure13?: "",
                    it?.strMeasure14?: "",
                    it?.strMeasure15?: "",
                    it?.strMeasure16?: "",
                    it?.strMeasure17?: "",
                    it?.strMeasure18?: "",
                    it?.strMeasure19?: "",
                    it?.strMeasure2?: "",
                    it?.strMeasure20?: "",
                    it?.strMeasure3?: "",
                    it?.strMeasure4?: "",
                    it?.strMeasure5?: "",
                    it?.strMeasure6?: "",
                    it?.strMeasure7?: "",
                    it?.strMeasure8?: "",
                    it?.strMeasure9?: "",
                    it?.strSource?: "",
                    it?.strTags?: "",
                    it?.strYoutube?: ""
                )
            }
        }
    }
}
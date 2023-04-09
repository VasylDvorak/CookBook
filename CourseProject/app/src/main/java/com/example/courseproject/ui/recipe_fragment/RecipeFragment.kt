package com.example.courseproject.ui.recipe_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.courseproject.App
import com.example.courseproject.databinding.FragmentRecipeBinding
import com.example.courseproject.di.recipe.RecipeSubcomponent
import com.example.courseproject.di.repository.RepositorySubcomponent
import com.example.courseproject.domain.image.IImageLoader
import com.example.courseproject.entity.category.GithubRepository
import com.example.courseproject.entity.recipe.Meal
import com.example.courseproject.ui.interfaces.BackButtonListener
import com.example.courseproject.ui.interfaces.RecipeView
import com.example.courseproject.ui.presenters.RecipePresenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

const val CURRENT_RECIPE = "current_recipe"

class RecipeFragment : MvpAppCompatFragment(), RecipeView, BackButtonListener {

    private lateinit var currentRepository: GithubRepository
    @Inject
    lateinit var imageLoader: IImageLoader<ImageView>


    companion object {
        fun newInstance(bundle: Bundle): RecipeFragment {
            val fragment = RecipeFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    private var _vb: FragmentRecipeBinding? = null
    private val vb
        get() = _vb!!

    private var recipeSubcomponent: RecipeSubcomponent? = null
    private val presenter: RecipePresenter by moxyPresenter {

        recipeSubcomponent = App.instance.initRecipeSubcomponent()
        RecipePresenter().apply {
            recipeSubcomponent?.inject(this)
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        currentRepository = (arguments?.getParcelable(CURRENT_RECIPE) as GithubRepository?)!!
        _vb = FragmentRecipeBinding.inflate(inflater, container, false)

        return vb.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _vb = null
    }


    override fun init() {
                  currentRepository.let { presenter.loadRepositories(it) }
    }


    override fun showRecipe(currentRecipe: Meal) {
recipeSubcomponent?.inject(this)
        vb.apply {
            currentRecipe.strMealThumb?.let { imageLoader.loadInto(it, photoMeal) }
            nameMeal.text=currentRecipe.strMeal?:""
            areaMeal.text=currentRecipe.strArea?:""
            instruction.text="INSTRUCTION\n"+currentRecipe.strInstructions?:""
            ingredients.text=presenter.ingredients()
            playMovie.setOnLongClickListener {
                presenter.playMovie()
                true
            }
        }
    }

    override fun release() {
        recipeSubcomponent = null
        App.instance.releaseRecipeSubComponent()
    }

    override fun backPressed() = presenter.backPressed()

}

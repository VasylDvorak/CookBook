package com.example.cookbook.ui.recipe_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.cookbook.App
import com.example.cookbook.di.recipe.RecipeSubcomponent
import com.example.cookbook.domain.image.IImageLoader
import com.example.cookbook.entity.menu.Menu
import com.example.cookbook.entity.room.recipe.Meal
import com.example.cookbook.ui.main_activity.interfaces.BackButtonListener
import com.example.cookbook.databinding.FragmentRecipeBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

const val CURRENT_RECIPE = "current_recipe"

class RecipeFragment : MvpAppCompatFragment(), RecipeView, BackButtonListener {

    private lateinit var currentItemMenu: Menu
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
        currentItemMenu = (arguments?.getParcelable(CURRENT_RECIPE) as Menu?)!!
        _vb = FragmentRecipeBinding.inflate(inflater, container, false)

        return vb.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _vb = null
    }


    override fun init() {
                  currentItemMenu.let { presenter.loadMenu(it) }
    }


    override fun showRecipe(currentRecipe: Meal) {
recipeSubcomponent?.inject(this)
        vb.apply {
            currentRecipe.strMealThumb?.let { imageLoader.loadInto(it, photoMeal) }
            nameMeal.text=currentRecipe.strMeal?:""
            areaMeal.text=currentRecipe.strArea?:""
            instruction.text="INSTRUCTION:\n"+currentRecipe.strInstructions?:""
            ingredients.text=presenter.ingredients()
            playMovie.setOnClickListener {
                presenter.playMovie()
            }
        }
    }

    override fun release() {
        recipeSubcomponent = null
        App.instance.releaseRecipeSubComponent()
    }


    override fun backPressed() = presenter.backPressed()

}


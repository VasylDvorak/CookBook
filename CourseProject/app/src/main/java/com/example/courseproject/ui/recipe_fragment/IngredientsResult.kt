package com.example.courseproject.ui.recipe_fragment

import com.example.courseproject.entity.recipe.Meal

class IngredientsResult {
    fun ingredientsList(currentRecipe: Meal): String {
        var stringsIngredientsList: MutableList<Pair<String, String>> = mutableListOf()
        stringsIngredientsList.add(Pair(currentRecipe.strIngredient1 ?: "", currentRecipe.strMeasure1 ?: ""))
        stringsIngredientsList.add(Pair(currentRecipe.strIngredient2 ?: "", currentRecipe.strMeasure2 ?: ""))
        stringsIngredientsList.add(Pair(currentRecipe.strIngredient3 ?: "", currentRecipe.strMeasure3 ?: ""))
        stringsIngredientsList.add(Pair(currentRecipe.strIngredient4 ?: "", currentRecipe.strMeasure4 ?: ""))
        stringsIngredientsList.add(Pair(currentRecipe.strIngredient5 ?: "", currentRecipe.strMeasure5 ?: ""))
        stringsIngredientsList.add(Pair(currentRecipe.strIngredient6 ?: "", currentRecipe.strMeasure6 ?: ""))
        stringsIngredientsList.add(Pair(currentRecipe.strIngredient7 ?: "", currentRecipe.strMeasure7 ?: ""))
        stringsIngredientsList.add(Pair(currentRecipe.strIngredient8 ?: "", currentRecipe.strMeasure8 ?: ""))
        stringsIngredientsList.add(Pair(currentRecipe.strIngredient9 ?: "", currentRecipe.strMeasure9 ?: ""))
        stringsIngredientsList.add(Pair(currentRecipe.strIngredient10 ?: "", currentRecipe.strMeasure10 ?: ""))
        stringsIngredientsList.add(Pair(currentRecipe.strIngredient11 ?: "", currentRecipe.strMeasure11 ?: ""))
        stringsIngredientsList.add(Pair(currentRecipe.strIngredient12 ?: "", currentRecipe.strMeasure12 ?: ""))
        stringsIngredientsList.add(Pair(currentRecipe.strIngredient13 ?: "", currentRecipe.strMeasure13 ?: ""))
        stringsIngredientsList.add(Pair(currentRecipe.strIngredient14 ?: "", currentRecipe.strMeasure14 ?: ""))
        stringsIngredientsList.add(Pair(currentRecipe.strIngredient15 ?: "", currentRecipe.strMeasure15 ?: ""))
        stringsIngredientsList.add(Pair(currentRecipe.strIngredient16 ?: "", currentRecipe.strMeasure16 ?: ""))
        stringsIngredientsList.add(Pair(currentRecipe.strIngredient17 ?: "", currentRecipe.strMeasure17 ?: ""))
        stringsIngredientsList.add(Pair(currentRecipe.strIngredient18 ?: "", currentRecipe.strMeasure18 ?: ""))
        stringsIngredientsList.add(Pair(currentRecipe.strIngredient19 ?: "", currentRecipe.strMeasure19 ?: ""))
        stringsIngredientsList.add(Pair(currentRecipe.strIngredient20 ?: "", currentRecipe.strMeasure20 ?: ""))

        var outIngredients="INGREDIENTS\n"
        
        for(oneElement in stringsIngredientsList){
            if(oneElement.first != ""){
                outIngredients ="${outIngredients+oneElement.first}: ${oneElement.second}\n"
            } }

        return outIngredients
    }
}
package com.example.cookbook.data.room

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = RoomMenu::class,
        parentColumns = ["idMeal"],
        childColumns = ["idMeal"],
        onDelete = ForeignKey.NO_ACTION
    )]
)
data class RoomRecipe (
    @PrimaryKey  var idMeal: String,
    var dateModified: String?,
    var strArea: String?,
    var strCategory: String?,
    var strCreativeCommonsConfirmed: String?,
    var strDrinkAlternate: String?,
    var strImageSource: String?,
    var strIngredient1: String?,
    var strIngredient10: String?,
    var strIngredient11: String?,
    var strIngredient12: String?,
    var strIngredient13: String?,
    var strIngredient14: String?,
    var strIngredient15: String?,
    var strIngredient16: String?,
    var strIngredient17: String?,
    var strIngredient18: String?,
    var strIngredient19: String?,
    var strIngredient2: String?,
    var strIngredient20: String?,
    var strIngredient3: String?,
    var strIngredient4: String?,
    var strIngredient5: String?,
    var strIngredient6: String?,
    var strIngredient7: String?,
    var strIngredient8: String?,
    var strIngredient9: String?,
    var strInstructions: String?,
    var strMeal: String?,
    var strMealThumb: String?,
    var strMeasure1: String?,
    var strMeasure10: String?,
    var strMeasure11: String?,
    var strMeasure12: String?,
    var strMeasure13: String?,
    var strMeasure14: String?,
    var strMeasure15: String?,
    var strMeasure16: String?,
    var strMeasure17: String?,
    var strMeasure18: String?,
    var strMeasure19: String?,
    var strMeasure2: String?,
    var strMeasure20: String?,
    var strMeasure3: String?,
    var strMeasure4: String?,
    var strMeasure5: String?,
    var strMeasure6: String?,
    var strMeasure7: String?,
    var strMeasure8: String?,
    var strMeasure9: String?,
    var strSource: String?,
    var strTags: String?,
    var strYoutube: String?
)
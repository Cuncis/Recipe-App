package com.cuncis.recipeapp.data.model.recipe


import com.cuncis.recipeapp.data.model.recipe.Recipe
import com.google.gson.annotations.SerializedName


data class RecipeResponse(

    @field:SerializedName("recipes")
	val recipes: List<Recipe?>? = null,

    @field:SerializedName("count")
	val count: Int? = null
)
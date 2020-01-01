package com.cuncis.recipeapp.data.model.recipe_detail


import com.cuncis.recipeapp.data.model.recipe_detail.RecipeDetail
import com.google.gson.annotations.SerializedName


data class RecipeDetailResponse(

	@field:SerializedName("recipe")
	val recipe: RecipeDetail? = null
)
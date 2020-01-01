package com.cuncis.recipeapp.data.model.recipe_detail


import com.google.gson.annotations.SerializedName


data class RecipeDetail(

	@field:SerializedName("social_rank")
	val socialRank: Double? = null,

	@field:SerializedName("recipe_id")
	val recipeId: String? = null,

	@field:SerializedName("publisher_url")
	val publisherUrl: String? = null,

	@field:SerializedName("image_url")
	val imageUrl: String? = null,

	@field:SerializedName("__v")
	val V: Int? = null,

	@field:SerializedName("ingredients")
	val ingredients: List<String?>? = null,

	@field:SerializedName("publisher")
	val publisher: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("source_url")
	val sourceUrl: String? = null
)
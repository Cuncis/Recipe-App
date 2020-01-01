package com.cuncis.recipeapp.data.api

import com.cuncis.recipeapp.data.model.recipe_detail.RecipeDetailResponse
import com.cuncis.recipeapp.data.model.recipe.RecipeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TheRecipeApi {

    @GET("api/search")
    fun searchRecipe(@Query("q") query: String,
                     @Query("page") page: String)
        : Call<RecipeResponse>

    @GET("api/get")
    fun getRecipeDetail(@Query("rId") recipeId: String)
        : Call<RecipeDetailResponse>

}
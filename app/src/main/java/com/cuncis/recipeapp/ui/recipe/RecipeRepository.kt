package com.cuncis.recipeapp.ui.recipe

import androidx.lifecycle.MutableLiveData
import com.cuncis.recipeapp.data.api.ApiClient
import com.cuncis.recipeapp.data.model.recipe.RecipeResponse
import com.cuncis.recipeapp.util.Utils.Companion.showLog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class RecipeRepository {
    companion object {
        fun getInstance() = RecipeRepository()
    }

    private val recipeApi = ApiClient.getRecipeApi()

    fun searchRecipe(query: String, page: String): MutableLiveData<RecipeResponse> {
        val recipeList = MutableLiveData<RecipeResponse>()
        val call = recipeApi.searchRecipe(query, page)
        call.enqueue(object : Callback<RecipeResponse> {
            override fun onResponse(call: Call<RecipeResponse>, response: Response<RecipeResponse>) {
                if (response.isSuccessful) {
                    recipeList.value = response.body()
                } else {
                    try {
                        showLog(response.message())
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }

            override fun onFailure(call: Call<RecipeResponse>, t: Throwable) {
                showLog("" + t.message)
            }
        })

        return recipeList
    }
}
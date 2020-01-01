package com.cuncis.recipeapp.ui.recipe

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cuncis.recipeapp.data.model.recipe.RecipeResponse

class RecipeViewModel : ViewModel() {

    private val recipeRepository = RecipeRepository.getInstance()

    fun searchRecipe(query: String, page: String): MutableLiveData<RecipeResponse> {
        return recipeRepository.searchRecipe(query, page)
    }

}

package com.cuncis.recipeapp.ui.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.cuncis.recipeapp.data.model.category.Category

class CategoryViewModel : ViewModel() {

    private val categoryRepository = CategoryRepository.getInstance()

    fun getCategoryList(): LiveData<List<Category>> {
        return categoryRepository.getCategoryList()
    }

}

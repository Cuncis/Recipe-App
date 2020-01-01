package com.cuncis.recipeapp.ui.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cuncis.recipeapp.data.model.category.Category
import com.cuncis.recipeapp.util.Utils

class CategoryRepository {
    companion object {
        fun getInstance() = CategoryRepository()
    }

    private val list = MutableLiveData<List<Category>>()

    fun getCategoryList(): LiveData<List<Category>> {
        val categoryList = ArrayList<Category>()
        for (i in 0..7) {
            val category = Category(
                Utils.DEFAULT_SEARCH_CATEGORY[i],
                Utils.DEFAULT_SEARCH_CATEGORY_IMAGES[i]
            )
            categoryList.add(category)
        }
        list.value = categoryList

        return list
    }

}
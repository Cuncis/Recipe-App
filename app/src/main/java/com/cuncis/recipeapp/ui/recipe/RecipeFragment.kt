package com.cuncis.recipeapp.ui.recipe

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.cuncis.recipeapp.R
import com.cuncis.recipeapp.util.Constants.EXTRA_QUERY
import com.cuncis.recipeapp.util.Utils.Companion.showLog

class RecipeFragment : Fragment() {

    companion object {
        fun newInstance() = RecipeFragment()
    }

    private lateinit var viewModel: RecipeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recipe_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RecipeViewModel::class.java)
        // TODO: Use the ViewModel
        viewModel.searchRecipe(arguments?.getString(EXTRA_QUERY).toString(), "1").observe(activity!!, Observer {
            showLog("" + it)
        })
    }

}

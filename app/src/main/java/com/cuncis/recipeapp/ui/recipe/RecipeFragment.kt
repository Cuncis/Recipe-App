package com.cuncis.recipeapp.ui.recipe

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.cuncis.recipeapp.R
import com.cuncis.recipeapp.adapter.RecipeAdapter
import com.cuncis.recipeapp.util.Constants.EXTRA_QUERY
import com.cuncis.recipeapp.util.Utils
import com.cuncis.recipeapp.util.Utils.Companion.showLog
import kotlinx.android.synthetic.main.recipe_fragment.view.*
import com.cuncis.recipeapp.util.Utils.Companion.showLoading
import com.cuncis.recipeapp.util.Utils.Companion.hideLoading

class RecipeFragment : Fragment() {

    private lateinit var viewModel: RecipeViewModel
    private lateinit var adapter: RecipeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recipe_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = RecipeAdapter(activity!!)
        viewModel = ViewModelProviders.of(this).get(RecipeViewModel::class.java)
        view!!.progressBar.showLoading()
        initRecyclerView()


        viewModel.searchRecipe(arguments?.getString(EXTRA_QUERY).toString(), "1").observe(activity!!, Observer {
            view!!.progressBar.hideLoading()
            showLog("" + it)
            adapter.setRecipeList(it.recipes!!)
        })
    }

    private fun initRecyclerView() {
        view!!.rv_recipeList.layoutManager = LinearLayoutManager(activity)
        view!!.rv_recipeList.setHasFixedSize(true)
        view!!.rv_recipeList.adapter = adapter
    }

}


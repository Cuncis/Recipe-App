package com.cuncis.recipeapp.ui.category

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.cuncis.recipeapp.R
import com.cuncis.recipeapp.adapter.CategoryAdapter
import com.cuncis.recipeapp.data.model.category.Category
import com.cuncis.recipeapp.data.model.recipe.Recipe
import com.cuncis.recipeapp.util.Constants.EXTRA_QUERY
import com.cuncis.recipeapp.util.Utils
import com.cuncis.recipeapp.util.Utils.Companion.showLog
import com.cuncis.recipeapp.util.Utils.Companion.showToast
import kotlinx.android.synthetic.main.category_fragment.view.*


class CategoryFragment : Fragment(), CategoryAdapter.ItemClickListener {

    private lateinit var viewModel: CategoryViewModel
    private lateinit var adapter: CategoryAdapter
    private lateinit var navController: NavController
    private lateinit var categoryList: List<Category>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.category_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CategoryViewModel::class.java)
        categoryList = ArrayList()
        adapter = CategoryAdapter(activity!!)
        navController = Navigation.findNavController(view!!)

        initRecyclerView()

        viewModel.getCategoryList().observe(activity!!, Observer {
            showLog("" + it)
            categoryList = it
            adapter.setCategoryList(it)
        })

    }

    private fun initRecyclerView() {
        view!!.rv_category.layoutManager = LinearLayoutManager(activity)
        view!!.rv_category.setHasFixedSize(true)
        adapter.setItemClickListener(this)
        view!!.rv_category.adapter = adapter
    }

    override fun onItemClick(position: Int) {
        showToast(activity!!, "" + position)
        val bundle = bundleOf(EXTRA_QUERY to categoryList[position].categoryTitle)
//        navController.navigate(R.id.action_categoryFragment_to_recipeFragment)
        view!!.findNavController().navigate(R.id.action_categoryFragment_to_recipeFragment, bundle)
    }

}

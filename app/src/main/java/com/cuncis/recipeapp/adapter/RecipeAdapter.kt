package com.cuncis.recipeapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cuncis.recipeapp.R
import com.cuncis.recipeapp.data.model.recipe.Recipe
import kotlinx.android.synthetic.main.item_recipe_list.view.*
import kotlin.math.roundToInt

class RecipeAdapter(private val context: Context): RecyclerView.Adapter<RecipeAdapter.RecipeHolder>() {

    private var recipeList: List<Recipe> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recipe_list, parent, false)
        return RecipeHolder(view)
    }

    override fun getItemCount(): Int = recipeList.size

    override fun onBindViewHolder(holder: RecipeHolder, position: Int) {
        holder.tvTitle.text = recipeList[position].title
        holder.tvPublisher.text = recipeList[position].publisher
        holder.tvScore.text = recipeList[position].socialRank!!.roundToInt().toString()
        val requestOptions = RequestOptions().placeholder(R.drawable.img_placeholder)
        Glide.with(context)
            .setDefaultRequestOptions(requestOptions)
            .load(recipeList[position].imageUrl)
            .into(holder.imgPoster)
    }

    fun setRecipeList(recipeList: List<Recipe>) {
        this.recipeList = recipeList
        notifyDataSetChanged()
    }

    class RecipeHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.recipe_title
        var tvPublisher: TextView = itemView.recipe_publisher
        var tvScore: TextView = itemView.recipe_social_score
        var imgPoster: ImageView = itemView.recipe_image
    }
}
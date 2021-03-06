package com.cuncis.recipeapp.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cuncis.recipeapp.R
import com.cuncis.recipeapp.data.model.category.Category
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.item_category.view.*

class CategoryAdapter(private val context: Context): RecyclerView.Adapter<CategoryAdapter.CategoryHolder>() {

    private var categoryList: List<Category> = ArrayList()
    private lateinit var itemClickListener: ItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_category, parent, false)
        return CategoryHolder(view)
    }

    override fun getItemCount(): Int = categoryList.size

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.categoryTitle.text = categoryList[position].categoryTitle
        val requestOptions = RequestOptions().placeholder(R.drawable.img_placeholder)

        val path = Uri.parse("android.resource://com.cuncis.recipeapp/drawable/" + categoryList[position].categoryPoster)
        Glide.with(context)
            .setDefaultRequestOptions(requestOptions)
            .load(path)
            .into(holder.posterFood)
    }

    fun setCategoryList(categoryList: List<Category>) {
        this.categoryList = categoryList
        notifyDataSetChanged()
    }

    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    inner class CategoryHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var posterFood: CircleImageView = itemView.img_posterFood
        var categoryTitle: TextView = itemView.category_title

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            itemClickListener.onItemClick(adapterPosition)
        }
    }

    interface ItemClickListener {
        fun onItemClick(position: Int)
    }

}
package com.example.movie.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.R
import com.example.movie.core.extensions.loadFromUrl
import com.example.movie.data.entitiy.MixModel
import com.example.movie.core.util.Constants

class SearchAdapter(val mixModelList:ArrayList<MixModel>, private val selectListener: SelectListener): RecyclerView.Adapter<SearchAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val posterImageView: ImageView =itemView.findViewById(R.id.searchPosterimageView)
        val backdropImageView:ImageView=itemView.findViewById(R.id.searchBackDropImageView)
        val titleTextView: TextView =itemView.findViewById(R.id.searchTitleText)
        val overView:TextView=itemView.findViewById(R.id.searchOverviewText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.search_recycler_view,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return mixModelList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentModel=mixModelList[position]
        if (currentModel.media_type=="person"){
            holder.posterImageView.loadFromUrl(Constants.IMAGE_URL+currentModel.profile_path)
            holder.titleTextView.text=currentModel.name
            holder.overView.text=currentModel.known_for_department
        }else if (currentModel.media_type=="movie"){
            holder.posterImageView.loadFromUrl(Constants.IMAGE_URL+currentModel.poster_path)
            holder.backdropImageView.loadFromUrl(Constants.IMAGE_URL+currentModel.backdrop_path)
            holder.titleTextView.text=currentModel.title
            holder.overView.text=currentModel.overview
        }else{
            holder.posterImageView.loadFromUrl(Constants.IMAGE_URL+currentModel.poster_path)
            holder.backdropImageView.loadFromUrl(Constants.IMAGE_URL+currentModel.backdrop_path)
            holder.titleTextView.text=currentModel.name
            holder.overView.text=currentModel.overview
        }
        holder.titleTextView.setOnClickListener{
            selectListener.onItemClicked(currentModel)
        }
    }
}
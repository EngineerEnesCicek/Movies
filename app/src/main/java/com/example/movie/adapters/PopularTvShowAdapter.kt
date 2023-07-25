package com.example.movie.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.R
import com.example.movie.core.extensions.loadFromUrl
import com.example.movie.core.util.Constants
import com.example.movie.data.entitiy.TVShowModel

class PopularTvShowAdapter(val tvShowModelList:ArrayList<TVShowModel>, private val listener: SelectTvShowListener):RecyclerView.Adapter<PopularTvShowAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView: ImageView =itemView.findViewById(R.id.itemsImageView)
        val textView: TextView =itemView.findViewById(R.id.itemsTextView)
        val items: LinearLayout =itemView.findViewById(R.id.itemsRecyclerView)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.items,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return tvShowModelList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentTvShow=tvShowModelList[position]
        holder.textView.text=currentTvShow.name
        holder.imageView.loadFromUrl(Constants.IMAGE_URL+currentTvShow.poster_path)
        holder.items.setOnClickListener{
            listener.onTvShowClicked(currentTvShow)
        }
    }
}
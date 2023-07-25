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
import com.example.movie.data.entitiy.MixModel
import com.example.movie.core.util.Constants

class MixAdapter(val mixModelList:ArrayList<MixModel>, private val selectListener: SelectListener): RecyclerView.Adapter<MixAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView: ImageView =itemView.findViewById(R.id.itemsImageView)
        val textView: TextView=itemView.findViewById(R.id.itemsTextView)
        val items:LinearLayout=itemView.findViewById(R.id.itemsRecyclerView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.items,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return mixModelList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentModel=mixModelList[position]
        when (currentModel.media_type) {
            "person" -> {
                holder.imageView.loadFromUrl(Constants.IMAGE_URL+currentModel.profile_path)
                holder.textView.text=currentModel.name
            }
            "movie" -> {
                holder.imageView.loadFromUrl(Constants.IMAGE_URL+currentModel.poster_path)
                holder.textView.text=currentModel.title
            }
            else -> {
                holder.imageView.loadFromUrl(Constants.IMAGE_URL+currentModel.poster_path)
                holder.textView.text=currentModel.name
            }
        }
        holder.items.setOnClickListener{
            selectListener.onItemClicked(currentModel)
        }
    }
}
package com.example.movie.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.R
import com.example.movie.core.extensions.loadFromUrl
import com.example.movie.data.entitiy.Reviewer
import com.example.movie.core.util.Constants

class ReveiwerAdapter(val reviewerList:List<Reviewer>):RecyclerView.Adapter<ReveiwerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val imageView:ImageView=itemView.findViewById(R.id.reviwerImageView)
        val reviewerNameText:TextView=itemView.findViewById(R.id.reviewerText)
        val ratedText:TextView=itemView.findViewById(R.id.ratedText)
        val contentText:TextView=itemView.findViewById(R.id.contentText)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView=
            LayoutInflater.from(parent.context).inflate(R.layout.reveiwer_recycler_view,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return reviewerList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentReviewer=reviewerList[position]
        holder.reviewerNameText.text="A review by ${currentReviewer.author_details?.name}"
        holder.ratedText.text="Rated: ${currentReviewer.author_details?.rating}"
        holder.contentText.text=currentReviewer.content
        holder.imageView.loadFromUrl(Constants.IMAGE_URL+currentReviewer.author_details?.avatar_path) }
}
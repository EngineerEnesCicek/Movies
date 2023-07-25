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
import com.example.movie.data.entitiy.MovieModel
import com.example.movie.core.util.Constants

class PopularMoviesAdapter(val popularMovieList:ArrayList<MovieModel>, private val listener: SelectMovieListener):RecyclerView.Adapter<PopularMoviesAdapter.ViewHolder>() {
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
        return popularMovieList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentMovie=popularMovieList[position]
        holder.textView.text=currentMovie.title
        holder.imageView.loadFromUrl(Constants.IMAGE_URL+currentMovie.poster_path)
        holder.items.setOnClickListener{
            listener.onMovieClicked(currentMovie)
        }
    }
}
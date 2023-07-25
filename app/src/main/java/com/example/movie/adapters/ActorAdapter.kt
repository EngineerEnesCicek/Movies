package com.example.movie.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.R
import com.example.movie.data.entitiy.ActorModel
import com.example.movie.core.extensions.loadFromUrl
import com.example.movie.core.util.Constants

class ActorAdapter(val actorList:List<ActorModel>, val selectActorListener: SelectActorListener):RecyclerView.Adapter<ActorAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView: ImageView =itemView.findViewById(R.id.actorImageView)
        val textView:TextView=itemView.findViewById(R.id.actorsNameText)
        val character:TextView=itemView.findViewById(R.id.characterNameText)
        val items:LinearLayout=itemView.findViewById(R.id.actorsLinearLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.actors_recycler_view,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return actorList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentActor=actorList[position]
        holder.textView.text=currentActor.name
        holder.character.text=currentActor.character
        holder.imageView.loadFromUrl(Constants.IMAGE_URL+currentActor.profile_path)
        holder.items.setOnClickListener{
            selectActorListener.onActorClicked(currentActor)
        }
    }
}
package com.tingtound.recyclerviewanimate

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.marginLeft
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter (val items : List<Movie>, val context: Context,val itemDelegate:ItemClickDelegate) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.view_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position == 0){


           /* val params = holder.mainCard.layoutParams as LinearLayout.LayoutParams
            params.leftMargin = 150
            holder.itemView.layoutParams = params

            val layoutParams: ViewGroup.LayoutParams = holder.itemView.getLayoutParams()
            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
            layoutParams.height = 200
            holder.mainCard.left=200
            holder.itemView.setLayoutParams(layoutParams)

            */
        }
        holder?.tvName?.text = items.get(position).name
        holder?.tvName.setOnClickListener {
            itemDelegate.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }




}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val mainCard=view.findViewById<CardView>(R.id.mainCard)
    val tvName = view.findViewById<TextView>(R.id.txtName)
}
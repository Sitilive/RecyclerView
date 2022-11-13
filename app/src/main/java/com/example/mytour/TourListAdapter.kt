package com.example.mytour

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class TourListAdapter(private val tour: ArrayList<Tour>):RecyclerView.Adapter<TourListAdapter.TourViewHolder>(){
    class TourViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
        val ivPhoto: ImageView = itemView.findViewById(R.id.ivPhoto)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tour_row_item, parent, false)
        return TourViewHolder(view)
    }

    override fun onBindViewHolder(holder: TourViewHolder, position: Int) {
        val (Name,Description, Photo) = tour[position]
        holder.tvName.text = Name
        holder.tvDescription.text = Description
        holder.ivPhoto.setImageResource(Photo)
    }

    override fun getItemCount(): Int {
        return tour.size
    }
}
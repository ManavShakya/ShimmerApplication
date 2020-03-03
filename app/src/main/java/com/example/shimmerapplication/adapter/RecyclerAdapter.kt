package com.example.shimmerapplication.adapter

import android.content.Context
import android.telecom.Call
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sampleapp.model.Data
import com.example.shimmerapplication.R

class RecyclerAdapter(private val details: List<Data>, private val context: Context) :
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.name)
        val location: TextView = view.findViewById(R.id.location)
        val imageView: ImageView = view.findViewById(R.id.imageView)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_view,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return details.size
    }

    override fun onBindViewHolder(viewHolder: MyViewHolder, position: Int) {
        viewHolder.name.text = details[position].name
        viewHolder.location.text = details[position].email
        Glide.with(context).load(details[position].avatar).into(viewHolder.imageView)
        // Picasso.with(context).load(details[position].url).into(viewHolder.imageView)
    }
}
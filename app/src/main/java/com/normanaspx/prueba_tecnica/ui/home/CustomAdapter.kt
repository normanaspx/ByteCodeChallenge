package com.normanaspx.prueba_tecnica.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.normanaspx.prueba_tecnica.R
import com.normanaspx.prueba_tecnica.model.Dessert
import com.normanaspx.prueba_tecnica.ext.StringExt.toListString


/**
Created by Norman on 11/16/2022
 **/
class CustomAdapter(private var itemsList: List<Dessert>?, val ctx: Context?) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    class ViewHolder(ItemView: View, val ctx: Context) :RecyclerView.ViewHolder(ItemView){
        private val tvName: TextView = itemView.findViewById(R.id.txtName)
        private val tvType: TextView = itemView.findViewById(R.id.txtType)
        private val tvBatters: TextView = itemView.findViewById(R.id.txtBatters)
        private val tvTopping: TextView =   itemView.findViewById(R.id.txtTopping)

        fun bind(meal: Dessert) {
            tvName.text = meal.name
            tvType.text = "Tipo:" + meal.type
            tvBatters.text = "Masas: " + meal.batters.batter.map { it.type }.toString().toListString()
            tvTopping.text = "Toppings: " +  meal.topping.map { it.type }.toString().toListString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemView = LayoutInflater.from(parent.context)
             .inflate(R.layout.desert_holder, parent, false)
        return ViewHolder(itemView, ctx!!)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemsList?.get(position)
        if (item != null) {
            holder.bind(item)
        }
    }

    override fun getItemCount(): Int {
        return itemsList?.size ?: 0
    }
}
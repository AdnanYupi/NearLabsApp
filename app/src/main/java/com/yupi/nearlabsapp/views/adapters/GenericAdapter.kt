package com.yupi.nearlabsapp.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class GenericAdapter<T>(private var list: Array<T>) :
    RecyclerView.Adapter<GenericAdapter<T>.GenericHolder>() {

    abstract fun bind(holder: GenericHolder, item: T)
    var onItemClick: ((T, Int) -> Unit)? = null

    fun setDataSource(list: Array<T>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return GenericHolder(view)
    }

    override fun onBindViewHolder(holder: GenericHolder, position: Int) {
        bind(holder, list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class GenericHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.setOnClickListener {
                onItemClick?.invoke(list[adapterPosition], adapterPosition)
            }
        }
    }
}
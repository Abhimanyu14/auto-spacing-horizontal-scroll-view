package com.makeappssimple.abhimanyu.autospacinghorizontalscrollview.android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(val data: Array<String>) :
    RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {

    // Describes an item view and its place within the RecyclerView
    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    override fun getItemViewType(position: Int): Int {
        return position % 2
    }

    // Returns a new ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val layout = if (viewType == 1) {
            R.layout.sample_layout_1
        } else {
            R.layout.sample_layout_2
        }
        val view = LayoutInflater.from(parent.context)
            .inflate(layout, parent, false)
        return RecyclerViewHolder(view)
    }

    // Returns size of data list
    override fun getItemCount(): Int {
        return data.size
    }

    // Displays data at a certain position
    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
    }
}

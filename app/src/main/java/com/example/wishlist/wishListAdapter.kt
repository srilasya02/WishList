package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class wishListAdapter (private val items : List<WishList>) : RecyclerView.Adapter<wishListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nameTextView:TextView
        val priceTextView:TextView
        val storeTextView:TextView
        init {
            nameTextView=itemView.findViewById(R.id.nameView)
            priceTextView=itemView.findViewById(R.id.priceView)
            storeTextView=itemView.findViewById(R.id.storeView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.wishlist_layout, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=items.get(position)

        holder.nameTextView.text = item.name
        holder.priceTextView.text = item.price
        holder.storeTextView.text = item.about

    }

    override fun getItemCount(): Int {
        return items.size
    }
}
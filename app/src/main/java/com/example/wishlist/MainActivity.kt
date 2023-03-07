package com.example.wishlist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class MainActivity : AppCompatActivity() {
    lateinit var items:List<WishList>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var items: MutableList<WishList> = ArrayList()

        val itemsRv=findViewById<RecyclerView>(R.id.recyclerView)
        var submitBtn=findViewById<Button>(R.id.button2)

        var nameText=findViewById<EditText>(R.id.itemName)
        var priceText=findViewById<EditText>(R.id.itemPrice)
        var aboutText=findViewById<EditText>(R.id.aboutItem)


        // Create adapter passing in the list of emails
        val adapter = wishListAdapter(items)
        // Attach the adapter to the RecyclerView to populate items
        itemsRv.adapter = adapter
        // Set layout manager to position the items
        itemsRv.layoutManager = LinearLayoutManager(this)

        submitBtn.setOnClickListener {
                var name=nameText.text.toString()
                var price=priceText.text.toString()
                var about=aboutText.text.toString()

                var values=WishList(name,price,about)

                items.add(values)
                Toast.makeText(it.context,"added values",Toast.LENGTH_SHORT).show()
                adapter.notifyDataSetChanged()
                Toast.makeText(it.context,"adapter notified",Toast.LENGTH_SHORT).show()

        }
        nameText.getText().clear()
        priceText.getText().clear()
        aboutText.getText().clear()

    }
}
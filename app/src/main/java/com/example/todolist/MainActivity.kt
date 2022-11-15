package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseBooleanArray
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initializing the array lists and the adapter
        val itemlist = arrayListOf<String>()
        val myAdapter =ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_single_choice,
            itemlist)
        // Adding the items to the list when the add button is pressed
        addButton.setOnClickListener {
            itemlist.add(editText.text.toString())
            listOfItem.adapter =  myAdapter
            myAdapter.notifyDataSetChanged()
            // This is because every time when you add the item the
            // input space or the edit text space will be cleared
            editText.text.clear()
        }
        // Clearing all the items in the list when the clear button
        // is pressed
        clearButton.setOnClickListener {
            itemlist.clear()
            myAdapter.notifyDataSetChanged()
        }
        // Selecting and Deleting the items from the list when the
        // delete button is pressed
        deleteButton.setOnClickListener {
            val position: SparseBooleanArray = listOfItem.checkedItemPositions
            val count = listOfItem.count
            var item = count - 1
            while (item >= 0) {
                if (position.get(item))
                {
                    myAdapter.remove(itemlist.get(item))
                }
                item--
            }
            position.clear()
            myAdapter.notifyDataSetChanged()
        }
    }
}
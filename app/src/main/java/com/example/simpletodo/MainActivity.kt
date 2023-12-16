package com.example.simpletodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAdd: Button = findViewById(R.id.btnAdd)
        val lv: ListView = findViewById(R.id.lv)

        val adapter = ArrayAdapter<String> (
                this,
                android.R.layout.simple_list_item_1,
                mutableListOf()
        )
        lv.adapter = adapter

        btnAdd.setOnClickListener {

            val et = EditText(this)

            AlertDialog.Builder(this)
                .setTitle("Add Todo")
                .setMessage("Fight!")
                .setView(et)
                .setPositiveButton("Add") { _, _ ->
                    val myTodo = et.text.toString()
                    adapter.add(myTodo)
                }
                .setNegativeButton("Cancel", null)
                .show()
        }
        
        lv.setOnItemClickListener { _, _, i, _ ->
             AlertDialog.Builder(this)
                 .setTitle("Delete Todo?")
                 .setPositiveButton("Yes") { _, _ ->
                    adapter.remove(adapter.getItem(i))
                 }
                 .setNegativeButton("No", null)
                 .show()
        }
    }
}
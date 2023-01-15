package com.example.recylerviewpractice

import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager


data class Person(val name:String, val age: Int)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val contacts = createContacts()

        rvContacts.adapter = ContactsAdapter(this, contacts)
        rvContacts.layoutManager = LinearLayoutManager(this)
    }

    private fun createContacts(): List<Person>{
        val contacts = mutableListOf<Person>()

        for(i in 1..100){
                contacts.add(Person("Person $i",i) )
        }
        return contacts
    }
}
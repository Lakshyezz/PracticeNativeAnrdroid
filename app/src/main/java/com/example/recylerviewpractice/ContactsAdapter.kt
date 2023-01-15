package com.example.recylerviewpractice

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
private const val TAG = "Contacts Adapter"
class ContactsAdapter(val context: Context,val  contacts: List<Person>) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>()
{
    // creating a new view:  Which is EXPENSIVE as we are creating whole new view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i(TAG,"onCreateViewHolder")
      val view =  LayoutInflater.from(context).inflate(R.layout.item_person,parent,false)
        return ViewHolder(view)
    }

    // return how many items are present in dataset
    override fun getItemCount() = contacts.size         // basically means:     { return contact.size }

    // bind the data at the position into the view holder   // INEXPENSIVE
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i(TAG,"onBindViewHolder")
        val contact = contacts[position]
        holder.bind(contact)
    }
    inner  class  ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvName = itemView.findViewById<TextView>(R.id.tvName)       // referencing to ids of components present in item_person.xml
        val tvAge = itemView.findViewById<TextView>(R.id.tvAge)

        fun bind(contact: Person) {
            // bind the data in the contact into views
            tvName.text = contact.name
            tvAge.text = "Age: ${contact.age}"
        }
    }
}

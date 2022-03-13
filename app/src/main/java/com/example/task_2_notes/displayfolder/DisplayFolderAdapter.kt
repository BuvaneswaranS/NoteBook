package com.example.task_2_notes.displayfolder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.task_2_notes.R

class DisplayFolderAdapter(val folder_name: String): RecyclerView.Adapter<DisplayFolderAdapter.ViewHolder>() {

//
//    private var listTitles = arrayOf("Title 1","Title 2","Title 3","Title 4","Title 5","Title 6","Title 7","Title 8","Title 9","Title 10")
//
//    private var listDescription = arrayOf("Description 1","Description 2","Description 3","Description 4","Description 5","Description 6","Description 7","Description 8","Description 9","Description 10")

    private var listNotesData = listOf<NotesData>(NotesData("Elon Musk","Title Elon 1", "Description Elon 1"),NotesData("Elon Musk","Title Elon 2", "Description Elon 2"),NotesData("Elon Musk","Title Elon 3", "Description Elon 3"),NotesData("Jeff","Title Jeff 1", "Description Jeff 1"),NotesData("Jeff","Title 2", "Description 2"),NotesData("Jeff","Title 3", "Description 3"),NotesData("Jeff","Title 4", "Description 4"),NotesData("default","Title 1", "Description 1"),NotesData("default","Title 2", "Description 2"),NotesData("default","Title 3", "Description 3"),NotesData("default","Title 4", "Description 4"))

    init {

    }

    override fun getItemCount(): Int {
        return listNotesData.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisplayFolderAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_design,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: DisplayFolderAdapter.ViewHolder, position: Int) {
        if(folder_name == listNotesData[position].folder_name){
            holder.itemTitle.text = listNotesData[position].title
            holder.itemDescription.text = listNotesData[position].description
        }

    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemTitle: TextView
        var itemDescription: TextView

        init {
            itemTitle = itemView.findViewById(R.id.title_note_item)
            itemDescription = itemView.findViewById(R.id.title_description_item)
        }

    }


}
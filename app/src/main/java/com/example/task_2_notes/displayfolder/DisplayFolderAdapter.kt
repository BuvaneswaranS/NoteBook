package com.example.task_2_notes.displayfolder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.task_2_notes.R
import com.example.task_2_notes.notesdatabase.NotesData

class DisplayFolderAdapter(val folder_name: String, val deleteNoteInterface: deleteNoteInterface): RecyclerView.Adapter<DisplayFolderAdapter.ViewHolder>(){

//    private var notesList = listOf<NotesData>(NotesData("Elon Musk","Title Elon 1", "Description Elon 1"),NotesData("Elon Musk","Title Elon 2", "Description Elon 2"),NotesData("Elon Musk","Title Elon 3", "Description Elon 3"),NotesData("Jeff","Title Jeff 1", "Description Jeff 1"),NotesData("Jeff","Title 2", "Description 2"),NotesData("Jeff","Title 3", "Description 3"),NotesData("Jeff","Title 4", "Description 4"),NotesData("default","Title 1", "Description 1"),NotesData("default","Title 2", "Description 2"),NotesData("default","Title 3", "Description 3"),NotesData("default","Title 4", "Description 4"))

    var notesList = ArrayList<NotesData>()


    override fun getItemCount(): Int {
        return notesList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisplayFolderAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_design,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: DisplayFolderAdapter.ViewHolder, position: Int) {
            holder.itemTitle.text = notesList.get(position).title
            holder.itemDescription.text = notesList.get(position).description

        holder.delete_Note.setOnClickListener{
                deleteNoteInterface.deleteNoteData(notesList.get(position))
            }
            holder.itemView.setOnClickListener {view ->
                Navigation.findNavController(view).navigate(DisplayFolderFragmentDirections.actionDisplayFolderFragmentToUpdateNoteFragment(notesList.get(position).uniqueKey,notesList.get(position).folderName,notesList.get(position).title,notesList.get(position).description,notesList.get(position).createdTime))
            }

    }

    fun updateList(newList: List<NotesData>){
        notesList.clear()
        notesList.addAll(newList)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemTitle: TextView
        var itemDescription: TextView
        var delete_Note: ImageView

        init {
            itemTitle = itemView.findViewById(R.id.title_note_item)
            itemDescription = itemView.findViewById(R.id.title_description_item)
            delete_Note = itemView.findViewById(R.id.icon_delete)
        }

    }


//    interface updateNoteInterface {
//        fun update_Note_Data(note: NotesData)
//    }

}

interface deleteNoteInterface {
    fun deleteNoteData(notesData: NotesData)
}

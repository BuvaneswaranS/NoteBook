package com.example.task_2_notes.homefragment

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.task_2_notes.R
import com.example.task_2_notes.notesdatabase.FolderData

class HomePageAdaptar: RecyclerView.Adapter<HomePageAdaptar.ViewHolder>() {

    var folderList = ArrayList<FolderData>()

    override fun getItemCount(): Int {
        return folderList.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePageAdaptar.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: HomePageAdaptar.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        init {

        }

    }

}
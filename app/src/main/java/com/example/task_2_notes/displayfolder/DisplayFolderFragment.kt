package com.example.task_2_notes.displayfolder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task_2_notes.R
import com.example.task_2_notes.databinding.FragmentDisplayFolderBinding


class DisplayFolderFragment : Fragment() {

    private lateinit var binding: FragmentDisplayFolderBinding
    private lateinit var viewModal: DisplayFolderViewModal

    private var layoutManager: RecyclerView.LayoutManager? = null
    private  var adapter: RecyclerView.Adapter<DisplayFolderAdapter.ViewHolder>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_display_folder, container, false)

        binding.writeNoteBtn.setOnClickListener{view ->
            Navigation.findNavController(view).navigate(R.id.action_displayFolderFragment_to_displayCardFragment)
        }

        viewModal = ViewModelProvider(this).get(DisplayFolderViewModal::class.java)

//        binding.displayFolderViewModel = viewModal

        layoutManager = LinearLayoutManager(this.context)

        val folder_name: String = "Jeff"

        binding.recyclerView.layoutManager = layoutManager

        adapter = DisplayFolderAdapter(folder_name)

        binding.recyclerView.adapter = adapter


        return binding.root
    }

}
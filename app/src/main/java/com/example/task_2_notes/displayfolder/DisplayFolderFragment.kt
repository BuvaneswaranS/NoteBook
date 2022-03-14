package com.example.task_2_notes.displayfolder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task_2_notes.R
import com.example.task_2_notes.databinding.FragmentDisplayFolderBinding
import com.example.task_2_notes.notesdatabase.NoteRespository
import com.example.task_2_notes.notesdatabase.NotesDao
import com.example.task_2_notes.notesdatabase.NotesData
import com.example.task_2_notes.notesdatabase.NotesDatabase


class DisplayFolderFragment : Fragment(), deleteNoteInterface {

    private lateinit var binding: FragmentDisplayFolderBinding
    private lateinit var viewModal: DisplayFolderViewModal

    private var layoutManager: RecyclerView.LayoutManager? = null
    private  var adapter: RecyclerView.Adapter<DisplayFolderAdapter.ViewHolder>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_display_folder, container, false)



        val arguments = DisplayFolderFragmentArgs.fromBundle(requireArguments())

//        Setting the viewModel

        val application = requireNotNull(this.activity).application

        val notesDao: NotesDao = NotesDatabase.getDatabaseInstance(application).notesDao

        val respository = NoteRespository(notesDao)

        val viewModelFactory = DisplayFolderViewModelFactory(respository)

        viewModal = ViewModelProvider(this, viewModelFactory).get(DisplayFolderViewModal::class.java)


        viewModal.getDataBasedOnFolderName(arguments.folderName)

        binding.folderNameTextView.setText(arguments.folderName)

        binding.writeNoteBtn.setOnClickListener{view ->
            Navigation.findNavController(view).navigate(DisplayFolderFragmentDirections.actionDisplayFolderFragmentToDisplayCardFragment(arguments.folderName,"editType"))
        }

        layoutManager = LinearLayoutManager(this.context)

        val folder_name: String = "Jeff"

//        Setting the Recycler View
        binding.recyclerView.layoutManager = layoutManager
        adapter = DisplayFolderAdapter(folder_name,this)
        binding.recyclerView.adapter = adapter

        viewModal.notesList?.observe(viewLifecycleOwner, Observer { list ->
            list?.let {
                (adapter as DisplayFolderAdapter).updateList(it)
            }
        })

        return binding.root
    }

    override fun deleteNoteData(notesData: NotesData) {
        viewModal.deleteNote(notesData)
    }
}
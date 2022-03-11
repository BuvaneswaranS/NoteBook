package com.example.task_2_notes.displayNote

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.task_2_notes.R
import com.example.task_2_notes.databinding.FragmentDisplayCardBinding
import com.example.task_2_notes.notesdatabase.NotesDatabase


class DisplayCardFragment : Fragment() {

    private lateinit var binding: FragmentDisplayCardBinding
    private lateinit var viewModel: DisplayNoteViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_display_card, container, false)

        binding.setLifecycleOwner(this)

        val app = requireNotNull(this.activity).application

        val database = NotesDatabase.getDatabaseInstance(app).notesDao

        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(app)).get(DisplayNoteViewModel::class.java)

        binding.displayViewModel = viewModel

        viewModel.noteTitle = binding.titleText.text.toString()
        viewModel.noteDescription = binding.descriptionText.text.toString()


        binding.saveBtn.setOnClickListener { view ->
            viewModel.addNote()
            Navigation.findNavController(view).navigate(R.id.action_displayCardFragment_to_displayFolderFragment)
        }

        return binding.root
    }

}
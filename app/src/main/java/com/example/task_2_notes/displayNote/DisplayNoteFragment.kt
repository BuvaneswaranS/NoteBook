package com.example.task_2_notes.displayNote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.task_2_notes.R
import com.example.task_2_notes.databinding.FragmentDisplayCardBinding
import com.example.task_2_notes.notesdatabase.NoteRespository
import com.example.task_2_notes.notesdatabase.NotesDatabase


class DisplayNoteFragment : Fragment() {

    private lateinit var binding: FragmentDisplayCardBinding
    private lateinit var viewModel: DisplayNoteViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_display_card, container, false)

        val application = requireNotNull(this.context)

        var notesDatabase = NotesDatabase.getDatabaseInstance(application).notesDao

        val respository = NoteRespository(notesDatabase)

        val viewModelFactory = DisplayNoteViewModelFactory(respository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(DisplayNoteViewModel::class.java)

        binding.displayViewModel = viewModel


        binding.saveBtn.setOnClickListener { view ->
            Navigation.findNavController(view).navigate(R.id.action_displayCardFragment_to_displayFolderFragment)
        }

        return binding.root
    }

}
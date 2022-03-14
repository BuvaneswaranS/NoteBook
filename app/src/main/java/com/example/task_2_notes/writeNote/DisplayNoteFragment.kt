package com.example.task_2_notes.writeNote

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
import com.example.task_2_notes.notesdatabase.NotesDao
import com.example.task_2_notes.notesdatabase.NotesData
import com.example.task_2_notes.notesdatabase.NotesDatabase


class DisplayNoteFragment : Fragment() {

    private lateinit var binding: FragmentDisplayCardBinding
    private lateinit var viewModel: DisplayNoteViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_display_card, container, false)

        val args = DisplayNoteFragmentArgs.fromBundle(requireArguments())

        val application = requireNotNull(this.activity).application

        val notesDao: NotesDao = NotesDatabase.getDatabaseInstance(application).notesDao

        val respository = NoteRespository(notesDao)

        val viewModelFactory = DisplayNoteViewModelFactory(respository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(DisplayNoteViewModel::class.java)

        binding.displayViewModel = viewModel


        if(args.type == "writeType"){
            binding.saveBtn.setOnClickListener { view ->
                val note = NotesData(args.folderName,binding.titleText.text.toString(),binding.descriptionText.text.toString())
                viewModel.insertNote(note)
                Navigation.findNavController(view).navigate(DisplayNoteFragmentDirections.actionDisplayCardFragmentToHomeFragment())

            }
        }else if(args.type == "editType"){
            binding.saveBtn.setOnClickListener { view ->
                val note = NotesData(args.folderName,binding.titleText.text.toString(),binding.descriptionText.text.toString())
                viewModel.insertNote(note)
                Navigation.findNavController(view).navigate(DisplayNoteFragmentDirections.actionDisplayCardFragmentToDisplayFolderFragment(args.folderName))

            }
        }


        return binding.root
    }

}
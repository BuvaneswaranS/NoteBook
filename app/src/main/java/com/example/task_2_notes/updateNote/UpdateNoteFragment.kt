package com.example.task_2_notes.updateNote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.task_2_notes.R
import com.example.task_2_notes.databinding.FragmentUpdateNoteBinding
import com.example.task_2_notes.notesdatabase.NoteRespository
import com.example.task_2_notes.notesdatabase.NotesDao
import com.example.task_2_notes.notesdatabase.NotesData
import com.example.task_2_notes.notesdatabase.NotesDatabase
import com.example.task_2_notes.writeNote.DisplayNoteFragmentDirections


// TODO: Rename parameter arguments, choose names that match

class UpdateNoteFragment : Fragment() {

    private lateinit var binding: FragmentUpdateNoteBinding
    private lateinit var viewModel: UpdateNoteViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_update_note, container, false)

        var args = UpdateNoteFragmentArgs.fromBundle(requireArguments())

        binding.titleText.setText(args.title)
        binding.descriptionText.setText(args.description)

        val application = requireNotNull(this.activity).application

        val notesDao: NotesDao = NotesDatabase.getDatabaseInstance(application).notesDao

        val respository = NoteRespository(notesDao)

        val viewModelFactory = UpdateNoteViewModelFactory(respository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(UpdateNoteViewModel::class.java)


        binding.saveBtn.setOnClickListener { view ->
            val note = NotesData(args.folderName,binding.titleText.text.toString(),binding.descriptionText.text.toString(),args.createdTime,System.currentTimeMillis())
            note.uniqueKey = args.uniqueKey
            viewModel.update(note)
            Navigation.findNavController(view).navigate(UpdateNoteFragmentDirections.actionUpdateNoteFragmentToHomeFragment())
            onDestroy()
        }

        return binding.root
    }


}
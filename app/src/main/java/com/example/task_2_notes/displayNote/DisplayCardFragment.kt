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
import com.example.task_2_notes.notesdatabase.NotesData
import com.example.task_2_notes.notesdatabase.NotesDatabase


class DisplayCardFragment : Fragment() {

    private lateinit var binding: FragmentDisplayCardBinding
    private lateinit var viewModel: DisplayNoteViewModel
    private lateinit var data: NotesData


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_display_card, container, false)

        binding.setLifecycleOwner(this)

        val app = requireNotNull(this.activity).application


        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(app)).get(DisplayNoteViewModel::class.java)

        binding.displayViewModel = viewModel

        val data_title: String = binding.titleText.text.toString()
        val data_description: String = binding.descriptionText.text.toString()

        binding.saveBtn.setOnClickListener { view ->
            data.title = data_title
            data.description = data_description
            viewModel.addNote(data)
            Navigation.findNavController(view).navigate(R.id.action_displayCardFragment_to_displayFolderFragment)
        }

        return binding.root
    }

}
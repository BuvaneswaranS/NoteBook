package com.example.task_2_notes.createfolder

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.task_2_notes.R
import com.example.task_2_notes.databinding.FragmentCreateFolderBinding
import com.example.task_2_notes.databinding.PageHomeBinding


class CreateFolderFragment : Fragment() {

    private lateinit var binding: FragmentCreateFolderBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_folder,container, false)

        binding.createFolderButton.setOnClickListener {view ->

            var data = binding.getFolderNameInput.text.toString()
            Log.i("TestingApp","${data}")
            binding.invalidateAll()
            Navigation.findNavController(view).navigate(CreateFolderFragmentDirections.actionCreateFolderFragmentToDisplayFolderFragment(data))
            onDestroy()
        }

        return binding.root
    }



}
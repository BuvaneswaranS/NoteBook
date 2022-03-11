package com.example.task_2_notes.displaycard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.task_2_notes.R
import com.example.task_2_notes.databinding.FragmentDisplayCardBinding


class DisplayCardFragment : Fragment() {

    private lateinit var binding: FragmentDisplayCardBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_display_card, container, false)

        return binding.root
    }

}
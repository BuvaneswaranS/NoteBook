package com.example.task_2_notes.homefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.task_2_notes.HomePage
import com.example.task_2_notes.R
import com.example.task_2_notes.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModal: homeViewModal

    private val rotateOpenAnimation: Animation by lazy { AnimationUtils.loadAnimation(context, R.anim.rotate_open_animation) }
    private val rotateCloseAnimation: Animation by lazy { AnimationUtils.loadAnimation(context, R.anim.rotate_close_animation) }
    private val fromBottomAnimation: Animation by lazy { AnimationUtils.loadAnimation(context, R.anim.from_animation) }
    private val toBottomAnimation: Animation by lazy { AnimationUtils.loadAnimation(context, R.anim.to_animation) }

    private var clicked: Boolean = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

//        binding.card.setOnClickListener{view ->
//            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_displayCardFragment)
//        }

        binding.folder.setOnClickListener{view ->
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_displayFolderFragment)
        }

        viewModal = ViewModelProvider(this).get(homeViewModal::class.java)
//        viewModal = ViewModelProvider(this, viewModalFactory).get(HomeViewModal::class.java)

        binding.addBtn.setOnClickListener{
            startAnimation()
        }

        binding.addNoteBtn.setOnClickListener{view ->
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_displayCardFragment)
        }

        binding.addFolder.setOnClickListener{view ->
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_displayFolderFragment)
        }

        binding.folderTitle.text = viewModal.word
        return binding.root
    }

    private fun startAnimation(){
        setVisibility(clicked)
        setAnimation(clicked)
        clicked = !clicked
    }

    private fun setVisibility(clicked: Boolean){
        if(!clicked){
            binding.addNoteBtn.visibility = View.VISIBLE
            binding.addFolder.visibility = View.VISIBLE
        }else{
            binding.addNoteBtn.visibility = View.GONE
            binding.addFolder.visibility = View.GONE
        }
    }

    private fun setAnimation(clicked: Boolean){
        if (!clicked){
            binding.addNoteBtn.startAnimation(fromBottomAnimation)
            binding.addFolder.startAnimation(fromBottomAnimation)
            binding.addBtn.startAnimation(rotateOpenAnimation)
        }else{
            binding.addNoteBtn.startAnimation(toBottomAnimation)
            binding.addFolder.startAnimation(toBottomAnimation)
            binding.addBtn.startAnimation(rotateCloseAnimation)
        }
    }

}
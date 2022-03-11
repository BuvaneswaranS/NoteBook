package com.example.task_2_notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.task_2_notes.databinding.PageHomeBinding

class HomePage : AppCompatActivity() {

    private lateinit var binding: PageHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.page_home)



        val navController = this.findNavController(R.id.NavHost)
        NavigationUI.setupActionBarWithNavController(this,navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.NavHost)
        return navController.navigateUp()
    }
}
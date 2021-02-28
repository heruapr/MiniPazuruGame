package com.example.herustudy.puzzle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.herustudy.R
import kotlinx.android.synthetic.main.activity_puzzle.*

class PuzzleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_puzzle)
        // Get an instance of base adapter
        val adapter = GridAdapter(this@PuzzleActivity)

        // Set the grid view adapter
        grid_view.adapter = adapter


    }
}
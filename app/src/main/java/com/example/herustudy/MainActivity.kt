package com.example.herustudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.herustudy.puzzle.PuzzleActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnPuzzle.setOnClickListener {
            startActivity(Intent(this, PuzzleActivity::class.java))
        }

    }
}
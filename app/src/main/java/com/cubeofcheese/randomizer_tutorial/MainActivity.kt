package com.cubeofcheese.randomizer_tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton = findViewById<Button>(R.id.rollButton)
        val resultsTextView = findViewById<TextView>(R.id.resultsTextView)
        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        val maxTextView = findViewById<TextView>(R.id.maxTextView)

        seekBar!!.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekbar: SeekBar?, p1: Int, p2: Boolean) {
                maxTextView.text = seekbar?.progress.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
//                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
//                TODO("Not yet implemented")
            }
        })

        rollButton.setOnClickListener {
            val rand = Random().nextInt(seekBar.progress) + 1
            resultsTextView.text = rand.toString()

        }
    }


}
package com.cubeofcheese.dndiceandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import com.cubeofcheese.dndiceandroidapp.R
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val d4Button = findViewById<Button>(R.id.d4Button)
        val d6Button = findViewById<Button>(R.id.d6Button)
        val d8Button = findViewById<Button>(R.id.d8Button)
        val d10Button = findViewById<Button>(R.id.d10Button)
        val d20Button = findViewById<Button>(R.id.d20Button)
        val customRollButton = findViewById<Button>(R.id.rollButton)

        val resultsTextView = findViewById<TextView>(R.id.resultsTextView)
        val dieRolledView = findViewById<TextView>(R.id.dieRolledView)
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

        customRollButton.setOnClickListener {
            if (seekBar.progress == 0) {
                resultsTextView.text = "0"
            } else {
                val rand = Random().nextInt(seekBar.progress) + 1
                resultsTextView.text = rand.toString()
            }
            dieRolledView.text = "d" + seekBar.progress.toString()
        }

        d4Button.setOnClickListener {
            val rand = Random().nextInt(4) + 1
            dieRolledView.text = "d4"
            resultsTextView.text = rand.toString()
        }
        d6Button.setOnClickListener {
            val rand = Random().nextInt(6) + 1
            dieRolledView.text = "d6"
            resultsTextView.text = rand.toString()
        }
        d8Button.setOnClickListener {
            val rand = Random().nextInt(8) + 1
            dieRolledView.text = "d8"
            resultsTextView.text = rand.toString()
        }
        d10Button.setOnClickListener {
            val rand = Random().nextInt(10) + 1
            dieRolledView.text = """d10"""
            resultsTextView.text = rand.toString()
        }
        d20Button.setOnClickListener {
            val rand = Random().nextInt(20) + 1
            dieRolledView.text = """d20"""
            resultsTextView.text = rand.toString()
        }
    }


}
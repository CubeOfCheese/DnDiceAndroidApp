package com.cubeofcheese.dndiceandroidapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DiceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DiceFragment : Fragment() {
    
    lateinit var d4Button: Button 
    lateinit var d6Button: Button 
    lateinit var d8Button: Button 
    lateinit var d10Button: Button 
    lateinit var d20Button: Button 
    lateinit var resultsTextView: TextView 
    lateinit var dieRolledView: TextView 

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dice, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        d4Button = view.findViewById(R.id.d4Button)
        d6Button = view.findViewById(R.id.d6Button)
        d8Button = view.findViewById(R.id.d8Button)
        d10Button = view.findViewById(R.id.d10Button)
        d20Button = view.findViewById(R.id.d20Button)

        resultsTextView = view.findViewById(R.id.resultsTextView)
        dieRolledView = view.findViewById(R.id.dieRolledView)

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


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DiceFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DiceFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
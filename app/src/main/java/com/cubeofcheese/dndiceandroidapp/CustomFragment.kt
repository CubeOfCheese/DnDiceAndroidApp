package com.cubeofcheese.dndiceandroidapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import org.w3c.dom.Text
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CustomFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CustomFragment : Fragment() {
    lateinit var resultsTextView: TextView
    lateinit var dieRolledView: TextView
    lateinit var dieSizeInput: EditText
    lateinit var maxTextView: TextView
    lateinit var customRollButton: Button

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
        return inflater.inflate(R.layout.fragment_custom, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        resultsTextView = view.findViewById(R.id.resultsTextView)
        dieRolledView = view.findViewById(R.id.dieRolledView)
        dieSizeInput = view.findViewById(R.id.dieSizeInput)
        customRollButton = view.findViewById(R.id.rollButton)

        dieSizeInput.doOnTextChanged { text, start, before, count ->
            customRollButton.isEnabled = !text.isNullOrBlank() // disabled when text is blank
        }
        customRollButton.setOnClickListener {
            if (dieSizeInput.equals(0)) {
                resultsTextView.text = "0"
            } else {
                val rand = Random().nextInt(Integer.valueOf(dieSizeInput.text.toString())) + 1
                resultsTextView.text = rand.toString()
            }
            dieRolledView.text = "d" + dieSizeInput.text.toString()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CustomFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CustomFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
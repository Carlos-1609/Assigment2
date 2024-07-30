package com.example.assigment2

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.DialogFragment

class CustomDialogFragment : DialogFragment(R.layout.fragment_custom_dialog) {
    companion object {
        private const val ARG_TITLE = "title"

        // Factory method to create an instance of the dialog with a title
        fun newInstance(title: String): CustomDialogFragment {
            val fragment = CustomDialogFragment()
            val args = Bundle()
            args.putString(ARG_TITLE, title)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cancelbt: Button = view.findViewById(R.id.cancelBT)
        val submitbt: Button = view.findViewById(R.id.submitBT)
        val radioGroup = view.findViewById<RadioGroup>(R.id.ratingRadioGroup)
        val title = arguments?.getString(ARG_TITLE) ?: "Rating"

        // Set the title on the TextView inside the dialog
        val titleTextView: TextView = view.findViewById(R.id.ratingHeaderTextView) // Make sure this ID matches the one in your layout
        titleTextView.text = title

        cancelbt.setOnClickListener {
            dismiss()
        }

        submitbt.setOnClickListener {
            val selectedOption: Int = radioGroup.checkedRadioButtonId
            val radioButton = view.findViewById<RadioButton>(selectedOption)
            Toast.makeText(context, radioButton.text, Toast.LENGTH_SHORT).show()
            val m1: MainActivity = activity as MainActivity
            // m1.receiveFeedback(radioButton.text.toString())
            dismiss()
        }
    }
}

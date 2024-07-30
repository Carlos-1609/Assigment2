package com.example.assigment2

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.DialogFragment

class MainActivity : AppCompatActivity() {
    private var typeRating = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ratingTV: TextView = findViewById(R.id.rateMeTextView)
        val btnrate: Button = findViewById(R.id.btnrate)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        val btnFinish: Button = findViewById(R.id.btnFinish)
        val name = intent.getStringExtra("EXTRA_NAME")
        setSupportActionBar(toolbar)

        btnrate.setOnClickListener {
            val dialogVar : DialogFragment
            if (typeRating == "Avengers EndGame") {
                dialogVar = CustomDialogFragment()
                dialogVar.show(supportFragmentManager, "Custom Dialog")
            }else{
                dialogVar = CustomDialogFragment()
                dialogVar.show(supportFragmentManager, "Custom Dialog")
            }
        }
        btnFinish.setOnClickListener {
            val intent = Intent(this, UserInfoActivity::class.java)
            Toast.makeText(this, "Thank you for rating :) $name", Toast.LENGTH_LONG).show()
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.rating_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val ratingTV: TextView = findViewById(R.id.rateMeTextView)

        when (item.itemId) {
            R.id.item2 -> {
                typeRating = "Deadpool and Wolverine Rating"
                ratingTV.text = typeRating
            }
            R.id.item3 -> {
                typeRating = "Avengers EndGame Rating"
                ratingTV.text = typeRating
            }
            R.id.item4 -> {
                typeRating = "Avengers Infinity War Rating"
                ratingTV.text = typeRating
            }
            R.id.item5 -> {
                typeRating = "Avengers Secret Wars Rating"
                ratingTV.text = typeRating
            }
        }
        return true
    }

    fun receiveFeedback(feedback: String) {
        val ratingTV: TextView = findViewById(R.id.rateMeTextView)
        ratingTV.text = feedback
    }
}

package com.example.assigment2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class UserInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_info)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val spinnerGender: Spinner = findViewById(R.id.spinnerGender)
        val btnOkay : Button = findViewById(R.id.btnOkay)
        val editTextName : EditText = findViewById(R.id.editTextName)

        btnOkay.setOnClickListener {
            val name = editTextName.text.toString()
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("EXTRA_NAME", name)
            }
            startActivity(intent)
        }


        var flag: String = "Gender"
        val options = arrayOf("Male", "Female", "Other")
        spinnerGender.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, options)
        spinnerGender.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options[p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}
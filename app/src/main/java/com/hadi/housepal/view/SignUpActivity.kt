package com.hadi.housepal.view
import android.content.Intent
import androidx.lifecycle.ViewModelProvider

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.hadi.housepal.R
import com.hadi.housepal.SignUpViewModel
import com.hadi.housepal.SignUpViewModelFactory
import com.hadi.housepal.data.UserRepository

class SignUpActivity : AppCompatActivity() {
    private lateinit var viewModel: SignUpViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val factory = SignUpViewModelFactory(UserRepository())
        viewModel = ViewModelProvider(this, factory)[SignUpViewModel::class.java]

        val fullNameEditText = findViewById<EditText>(R.id.fullNameEditText)
        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val phoneEditText = findViewById<EditText>(R.id.phoneEditText)
        val nextButton = findViewById<Button>(R.id.nextButtonPage1)

        nextButton.setOnClickListener {
            viewModel.setPersonalInfo(
                fullNameEditText.text.toString(),
                emailEditText.text.toString(),
                phoneEditText.text.toString()
            )

            startActivity(Intent(this, SignUpPage2Activity::class.java))
        }
    }
}
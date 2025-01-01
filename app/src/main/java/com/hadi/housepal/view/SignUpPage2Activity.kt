package com.hadi.housepal.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.hadi.housepal.R
import com.hadi.housepal.SignUpViewModel
import com.hadi.housepal.SignUpViewModelFactory
import com.hadi.housepal.data.UserRepository

class SignUpPage2Activity : AppCompatActivity() {
    private lateinit var viewModel: SignUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_page2)

        // Initialize the ViewModel
        val factory = SignUpViewModelFactory(UserRepository())
        viewModel = ViewModelProvider(this, factory)[SignUpViewModel::class.java]

        val jobTitleEditText = findViewById<EditText>(R.id.jobTitleEditText)
        val companyEditText = findViewById<EditText>(R.id.companyEditText)
        val nextButton = findViewById<Button>(R.id.nextButtonPage2)

        nextButton.setOnClickListener {
            viewModel.setProfessionalInfo(
                        jobTitle = jobTitleEditText.text.toString() ,
                        company = companyEditText.text.toString()
            )


            val intent = Intent(this, SignUpPage3Activity::class.java)
            startActivity(intent)
        }
    }
}
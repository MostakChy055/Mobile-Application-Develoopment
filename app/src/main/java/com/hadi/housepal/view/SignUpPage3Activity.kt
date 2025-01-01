package com.hadi.housepal.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.hadi.housepal.R
import com.hadi.housepal.SignUpViewModel
import com.hadi.housepal.SignUpViewModelFactory
import com.hadi.housepal.data.UserRepository

class SignUpPage3Activity : AppCompatActivity() {
    private lateinit var viewModel: SignUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_page3)

        // Initialize the ViewModel
        val factory = SignUpViewModelFactory(UserRepository())
        viewModel = ViewModelProvider(this, factory)[SignUpViewModel::class.java]

        val smokerRadioGroup = findViewById<RadioGroup>(R.id.smokerRadioGroup)
        val finishButton = findViewById<Button>(R.id.finishButton)

        finishButton.setOnClickListener {
            viewModel.setRoommatePreferences(
                smokerPreference = when (smokerRadioGroup.checkedRadioButtonId) {
                    R.id.smokerYesRadio -> "Yes"
                    R.id.smokerNoRadio -> "No"
                    else -> "Not Specified"
                }


            )
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("navigateTo", "homeFragment") // Optional
            startActivity(intent)
            finish()

//            // Combine data for submission
//            val userData = """
//                Name: ${viewModel.fullName}
//                Email: ${viewModel.email}
//                Phone: ${viewModel.phone}
//                Job Title: ${viewModel.jobTitle}
//                Company: ${viewModel.company}
//                Smoker Preference: ${viewModel.smokerPreference}
//            """.trimIndent()

//            println(userData) // Replace with your submission logic
        }
    }
}
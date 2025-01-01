package com.hadi.housepal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hadi.housepal.data.UserRepository

class SignUpViewModel(private val repository: UserRepository) : ViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> get() = _user

    fun setPersonalInfo(name: String, email: String, phone: String) {
        _user.value = _user.value?.copy(name = name, email = email, phone = phone) ?:
                User(name, email, phone, "", "", "")
    }

    fun setProfessionalInfo(jobTitle: String, company: String) {
        _user.value = _user.value?.copy(jobTitle = jobTitle, company = company)
    }

    fun setRoommatePreferences(smokerPreference: String) {
        _user.value = _user.value?.copy(smokerPreference = smokerPreference)
    }

    fun saveUserData() {
        _user.value?.let { repository.saveUserData(it) }
    }
}

data class User(
    val name: String,
    val email: String,
    val phone: String,
    val jobTitle: String,
    val company: String,
    val smokerPreference: String
)
class SignUpViewModelFactory(private val userRepository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SignUpViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SignUpViewModel(userRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
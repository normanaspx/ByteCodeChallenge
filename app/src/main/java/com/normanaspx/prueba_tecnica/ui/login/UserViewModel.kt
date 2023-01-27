package com.normanaspx.prueba_tecnica.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.normanaspx.prueba_tecnica.model.Dessert
import com.normanaspx.prueba_tecnica.model.User
import com.normanaspx.prueba_tecnica.repository.DessertRepository
import com.normanaspx.prueba_tecnica.repository.UserRepository
import com.normanaspx.prueba_tecnica.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    fun addUser(user: User) {
        userRepository.addUser(user)
    }

    fun getLoginDetails(user: User): LiveData<List<User>> {
        return userRepository.getLoginDetails(user)
    }

}
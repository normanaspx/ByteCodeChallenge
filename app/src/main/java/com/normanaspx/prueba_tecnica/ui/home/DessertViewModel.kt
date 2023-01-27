package com.normanaspx.prueba_tecnica.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.normanaspx.prueba_tecnica.model.Dessert
import com.normanaspx.prueba_tecnica.repository.DessertRepository
import com.normanaspx.prueba_tecnica.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DessertViewModel  @Inject constructor(private val dessertRepository: DessertRepository) : ViewModel() {

    private var _movieResponse = MutableLiveData<Response<List<Dessert>>>()
    val movieResponse: LiveData<Response<List<Dessert>>> = _movieResponse

    init {
        fetchAllMovies()
    }

    private fun fetchAllMovies() {
        viewModelScope.launch {
            dessertRepository.getDessertsFromNetwork().collect {
                _movieResponse.postValue(it)
            }
        }
    }

}
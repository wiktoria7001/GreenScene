package com.dsw.pam.greenscene.ui.restaurant

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dsw.pam.greenscene.model.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RestaurantViewModel(private val repository: RestaurantRepository) : ViewModel() {

    private val _restaurants = MutableStateFlow<List<Restaurant>>(emptyList())
    val restaurants: StateFlow<List<Restaurant>> = _restaurants

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    fun fetchRestaurants() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            try {
                _restaurants.value = repository.getRestaurants()
            } catch (e: Exception) {
                _errorMessage.value = "Failed to load restaurants: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}

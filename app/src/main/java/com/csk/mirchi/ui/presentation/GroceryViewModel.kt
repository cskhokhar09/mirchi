package com.csk.mirchi.ui.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.csk.mirchi.data.Grocery
import com.csk.mirchi.network.ApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class GroceryViewModel : ViewModel() {
    private val apiService = ApiService.getApiService()
    private var _groceryList: MutableStateFlow<List<Grocery>>? = null

    fun getGroceryList() = viewModelScope.launch {
        _groceryList?.value = apiService.getGroceryData()
    }

}
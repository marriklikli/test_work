package com.example.testwork


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class MainViewModel(private val repository: Repository) : ViewModel() {
    var price = MutableLiveData<String>()

    private val _data = MutableStateFlow<List<FoodList>>(emptyList())
    val data = _data.asStateFlow()
    fun onGetData ( ) {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                repository.getActivityInfo()
            }.fold(
                onSuccess = {_data.value = it},
                onFailure = { Log.d("Food", it.message ?: "")}
            )
        }
    }
}
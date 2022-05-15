package com.example.mycalc

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _result = MutableLiveData("")
    val result: LiveData<String> = _result

    fun setResult(result: String) {
        _result.value = result
    }
}
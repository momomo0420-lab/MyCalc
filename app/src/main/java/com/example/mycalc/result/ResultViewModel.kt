package com.example.mycalc.result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResultViewModel : ViewModel() {
    private val _result = MutableLiveData("")
    val result: LiveData<String> = _result

    fun setResult(result: String) {
        _result.value = result
    }
}
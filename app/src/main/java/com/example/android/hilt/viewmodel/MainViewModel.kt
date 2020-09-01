package com.example.android.hilt.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle

class MainViewModel : BaseViewModel {


    val _text = MutableLiveData("Initial Value")
    val text: LiveData<String> = _text

    @ViewModelInject
    constructor(@Assisted savedStateHandle: SavedStateHandle) : super(savedStateHandle) {

    }

    var clickCount = 1
    fun onBottomTextClick() {
        _text.value = "click - "+clickCount++
    }
}
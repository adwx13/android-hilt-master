package com.example.android.hilt.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel {

    lateinit var savedStateHandle: SavedStateHandle
    constructor(savedStateHandle: SavedStateHandle) {
        this.savedStateHandle = savedStateHandle
    }
}
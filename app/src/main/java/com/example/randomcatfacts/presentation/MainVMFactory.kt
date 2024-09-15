package com.example.randomcatfacts.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class MainVMFactory @Inject constructor(private val mainViewModel: MainVM) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainVM::class.java)) {
            return mainViewModel as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
package com.ritikcoder.stateinjetpackcomposeapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StateTextViewModel: ViewModel() {
    private val _name = MutableLiveData<String>()
    val name : LiveData<String> = _name

    fun onNameUpdate(newName : String){
        _name.value = newName
    }

    private val _surName = MutableLiveData<String>()
    val surName : LiveData<String> = _surName

    fun onSurNameUpdate(newName : String){
        _surName.value = newName
    }
}
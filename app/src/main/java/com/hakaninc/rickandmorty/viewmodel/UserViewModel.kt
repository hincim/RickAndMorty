package com.hakaninc.rickandmorty.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.hakaninc.rickandmorty.entity.Results
import com.hakaninc.rickandmorty.entity.ResultsLazyColumn

class UserViewModel : ViewModel(){

    private val _user = mutableStateOf(ResultsLazyColumn())
    val user : State<ResultsLazyColumn> = _user

    fun setUser(character : ResultsLazyColumn){
        _user.value = character
    }

}
package com.hakaninc.rickandmorty.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hakaninc.rickandmorty.entity.Results
import com.hakaninc.rickandmorty.entity.ResultsLazyColumn
import com.hakaninc.rickandmorty.repo.PersonDaoRetrofit

class HomePageViewModel : ViewModel(){


    private var pRepo = PersonDaoRetrofit()
    var personList = MutableLiveData<ArrayList<Results>>()
    var characterList = MutableLiveData<ArrayList<ResultsLazyColumn>>()
    var characterState = MutableLiveData<String>()
    var personState = MutableLiveData<String>()

    init {
        getAllPersons()
        getAllCharacter()
        personList = pRepo.connectingViewModelPerson()
        characterList = pRepo.connectingViewModelCharacter()
        personState = pRepo.connectingViewModelPersonState()
        characterState = pRepo.connectingViewModelCharacterState()
    }

    fun getAllPersons(){
        pRepo.getAllPersonsRepo()
    }

    fun getAllCharacter(){
        pRepo.getAllCharacter()
    }
}
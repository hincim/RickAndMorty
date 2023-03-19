package com.hakaninc.rickandmorty.viewmodel

import androidx.lifecycle.MutableLiveData
import com.hakaninc.rickandmorty.entity.Results
import com.hakaninc.rickandmorty.entity.ResultsLazyColumn
import com.hakaninc.rickandmorty.repo.PersonDaoRetrofit

class HomePageViewModel {


    private var pRepo = PersonDaoRetrofit()
    var personList = MutableLiveData<ArrayList<Results>>()
    var characterList = MutableLiveData<ArrayList<ResultsLazyColumn>>()

    init {
        getAllPersons()
        getAllCharacter()
        personList = pRepo.connectingViewModelPerson()
        characterList = pRepo.connectingViewModelCharacter()
    }

    fun getAllPersons(){
        pRepo.getAllPersonsRepo()
    }

    fun getAllCharacter(){
        pRepo.getAllCharacter()
    }
}
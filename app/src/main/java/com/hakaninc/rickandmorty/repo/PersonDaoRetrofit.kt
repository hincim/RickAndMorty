package com.hakaninc.rickandmorty.repo

import androidx.compose.runtime.Composable
import androidx.lifecycle.MutableLiveData
import com.hakaninc.rickandmorty.entity.*
import com.hakaninc.rickandmorty.retrofit.APIUtils
import com.hakaninc.rickandmorty.retrofit.PersonsDaoRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonDaoRetrofit {

    private var personsDaoRetrofit: PersonsDaoRetrofit
    private var personsListRepo = MutableLiveData<ArrayList<Results>>()
    private var characterListRepo = MutableLiveData<ArrayList<ResultsLazyColumn>>()
    private var statePerson = MutableLiveData<String>()
    private var stateCharacter = MutableLiveData<String>()

    init {
        personsDaoRetrofit = APIUtils.getPersonDao()
        personsListRepo = MutableLiveData()
        characterListRepo = MutableLiveData()
        statePerson = MutableLiveData()
        stateCharacter = MutableLiveData()
    }

    fun connectingViewModelPerson(): MutableLiveData<ArrayList<Results>>{
        return personsListRepo
    }

    fun connectingViewModelCharacter(): MutableLiveData<ArrayList<ResultsLazyColumn>>{
        return characterListRepo
    }
    fun connectingViewModelPersonState(): MutableLiveData<String>{
        return statePerson
    }
    fun connectingViewModelCharacterState(): MutableLiveData<String>{
        return stateCharacter
    }

    fun getAllPersonsRepo() {

        personsDaoRetrofit.getAllPerson().enqueue(object : Callback<Persons>{

            override fun onResponse(
                call: Call<Persons>?,
                response: Response<Persons>?
            ) {
                personsListRepo.value = response?.body()?.results

            }

            override fun onFailure(call: Call<Persons>?, t: Throwable?) {
                statePerson.value = t?.localizedMessage
            }
        })
    }

    fun getAllCharacter(){

        personsDaoRetrofit.getAllCharacter().enqueue(object : Callback<Character>{
            override fun onResponse(
                call: Call<Character>?,
                response: Response<Character>?
            ) {
                characterListRepo.value = response?.body()?.results

            }

            override fun onFailure(call: Call<Character>?, t: Throwable?) {
                stateCharacter.value = t?.message
            }

        })
    }
}
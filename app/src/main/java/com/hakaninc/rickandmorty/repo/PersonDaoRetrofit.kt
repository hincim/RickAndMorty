package com.hakaninc.rickandmorty.repo

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
    var state = MutableLiveData<Boolean>()

    init {
        personsDaoRetrofit = APIUtils.getPersonDao()
        personsListRepo = MutableLiveData()
        characterListRepo = MutableLiveData()
        state = MutableLiveData()
    }

    fun connectingViewModelPerson(): MutableLiveData<ArrayList<Results>>{
        return personsListRepo
    }

    fun connectingViewModelCharacter(): MutableLiveData<ArrayList<ResultsLazyColumn>>{
        return characterListRepo
    }

    fun getAllPersonsRepo() {

        state.value = false
        personsDaoRetrofit.getAllPerson().enqueue(object : Callback<Persons>{

            override fun onResponse(
                call: Call<Persons>?,
                response: Response<Persons>?
            ) {
                personsListRepo.value = response?.body()?.results
                state.value = true
            }

            override fun onFailure(call: Call<Persons>?, t: Throwable?) {

            }

        })
    }

    fun getAllCharacter(){

        state.value = false

        personsDaoRetrofit.getAllCharacter().enqueue(object : Callback<Character>{
            override fun onResponse(
                call: Call<Character>?,
                response: Response<Character>?
            ) {
                characterListRepo.value = response?.body()?.results
                state.value = true


            }

            override fun onFailure(call: Call<Character>?, t: Throwable?) {

            }

        })
    }
}
package com.hakaninc.rickandmorty.repo

import androidx.lifecycle.MutableLiveData
import com.hakaninc.rickandmorty.entity.ExampleJson2KtKotlin
import com.hakaninc.rickandmorty.entity.ExampleJson2KtKotlinCharacter
import com.hakaninc.rickandmorty.entity.Results
import com.hakaninc.rickandmorty.entity.ResultsLazyColumn
import com.hakaninc.rickandmorty.retrofit.APIUtils
import com.hakaninc.rickandmorty.retrofit.PersonsDaoRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonDaoRetrofit {

    private var personsDaoRetrofit: PersonsDaoRetrofit
    private var personsListRepo = MutableLiveData<ArrayList<Results>>()
    private var characterListRepo = MutableLiveData<ArrayList<ResultsLazyColumn>>()


    init {
        personsDaoRetrofit = APIUtils.getPersonDao()
        personsListRepo = MutableLiveData()
        characterListRepo = MutableLiveData()
    }

    fun connectingViewModelPerson(): MutableLiveData<ArrayList<Results>>{
        return personsListRepo
    }

    fun connectingViewModelCharacter(): MutableLiveData<ArrayList<ResultsLazyColumn>>{
        return characterListRepo
    }

    fun getAllPersonsRepo() {

        personsDaoRetrofit.getAllPerson().enqueue(object : Callback<ExampleJson2KtKotlin>{
            override fun onResponse(
                call: Call<ExampleJson2KtKotlin>?,
                response: Response<ExampleJson2KtKotlin>?
            ) {
                personsListRepo.value = response?.body()?.results

            }

            override fun onFailure(call: Call<ExampleJson2KtKotlin>?, t: Throwable?) {
                TODO("Not yet implemented")
            }

        })
    }

    fun getAllCharacter(){

        personsDaoRetrofit.getAllCharacter().enqueue(object : Callback<ExampleJson2KtKotlinCharacter>{
            override fun onResponse(
                call: Call<ExampleJson2KtKotlinCharacter>?,
                response: Response<ExampleJson2KtKotlinCharacter>?
            ) {
                characterListRepo.value = response?.body()?.results
            }

            override fun onFailure(call: Call<ExampleJson2KtKotlinCharacter>?, t: Throwable?) {
                TODO("Not yet implemented")
            }

        })
    }
}
package com.hakaninc.rickandmorty.retrofit

import com.hakaninc.rickandmorty.entity.ExampleJson2KtKotlin
import com.hakaninc.rickandmorty.entity.ExampleJson2KtKotlinCharacter
import retrofit2.Call
import retrofit2.http.GET

interface PersonsDaoRetrofit {

    @GET("location")
    fun getAllPerson() : retrofit2.Call<ExampleJson2KtKotlin>

    @GET("character")
    fun getAllCharacter() : Call<ExampleJson2KtKotlinCharacter>
}
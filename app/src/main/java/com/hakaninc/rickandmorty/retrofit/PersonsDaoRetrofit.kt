package com.hakaninc.rickandmorty.retrofit

import com.hakaninc.rickandmorty.entity.Persons
import com.hakaninc.rickandmorty.entity.Character
import retrofit2.Call
import retrofit2.http.GET

interface PersonsDaoRetrofit {

    @GET("location")
    fun getAllPerson() : retrofit2.Call<Persons>

    @GET("character")
    fun getAllCharacter() : Call<Character>
}
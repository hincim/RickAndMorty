package com.hakaninc.rickandmorty.entity

import com.google.gson.annotations.SerializedName

data class ExampleJson2KtKotlinCharacter(

    @SerializedName("info"    ) var info    : Info?              = Info(),
    @SerializedName("results" ) var results : ArrayList<ResultsLazyColumn> = arrayListOf()
)
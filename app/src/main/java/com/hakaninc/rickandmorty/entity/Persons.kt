package com.hakaninc.rickandmorty.entity

import com.google.gson.annotations.SerializedName

data class Persons(

    @SerializedName("info"    ) var info    : Info?              = Info(),
    @SerializedName("results" ) var results : ArrayList<Results> = arrayListOf()
)

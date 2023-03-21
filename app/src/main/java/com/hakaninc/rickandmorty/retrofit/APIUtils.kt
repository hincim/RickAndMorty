package com.hakaninc.rickandmorty.retrofit

class APIUtils {

    companion object{

        private const val BASE_URL = "https://rickandmortyapi.com/api/"

        fun getPersonDao() : PersonsDaoRetrofit{

            return RetrofitClient.getClient(BASE_URL).create(PersonsDaoRetrofit::class.java)
        }

    }
}
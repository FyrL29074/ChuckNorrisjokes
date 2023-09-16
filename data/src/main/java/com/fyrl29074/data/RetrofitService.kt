package com.fyrl29074.data

import com.fyrl29074.data.model.JokeDto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://api.chucknorris.io/"

object RetrofitService {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val searchImageApi: ChuckNorrisJokesApi = retrofit.create(ChuckNorrisJokesApi::class.java)
}

interface ChuckNorrisJokesApi {
    @GET("jokes/random")
    suspend fun getJoke(): JokeDto
}
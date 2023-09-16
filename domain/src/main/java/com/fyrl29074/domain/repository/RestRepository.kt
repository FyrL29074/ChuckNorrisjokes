package com.fyrl29074.domain.repository

import com.fyrl29074.domain.model.Joke

interface RestRepository {

    suspend fun getJokesList(): List<Joke>
}
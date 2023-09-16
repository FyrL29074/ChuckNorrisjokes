package com.fyrl29074.data.repository

import com.fyrl29074.data.RetrofitService
import com.fyrl29074.data.mapper.JokeMapper
import com.fyrl29074.domain.model.Joke
import com.fyrl29074.domain.repository.RestRepository

object RestRepositoryImpl : RestRepository {

    override suspend fun getJokesList(): List<Joke> {
        val jokesListDto = List(JOKES_LIST_SIZE) {
            RetrofitService.searchImageApi.getJoke()
        }

        val jokesList = jokesListDto.map { dto ->
            JokeMapper.map(dto)
        }

        return jokesList
    }

    private const val JOKES_LIST_SIZE = 10
}
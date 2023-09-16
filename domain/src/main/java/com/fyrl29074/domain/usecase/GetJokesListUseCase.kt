package com.fyrl29074.domain.usecase

import com.fyrl29074.domain.model.Joke
import com.fyrl29074.domain.repository.RestRepository


class GetJokesListUseCase(private val restRepository: RestRepository) {

    suspend fun execute(): List<Joke> {
        return restRepository.getJokesList()
    }
}
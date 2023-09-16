package com.fyrl29074.chuck_norris_jokes.presentation.features.jokes

import androidx.lifecycle.ViewModel
import com.fyrl29074.chuck_norris_jokes.presentation.formatter.JokeFormatter
import com.fyrl29074.chuck_norris_jokes.presentation.model.JokeVO
import com.fyrl29074.domain.usecase.GetJokesListUseCase
import kotlinx.coroutines.delay

class JokesViewModel(
    private val getJokesListUseCase: GetJokesListUseCase
) : ViewModel() {

    suspend fun getJokes(): List<JokeVO> {
        return getJokesListUseCase.execute()
            .map { joke ->
                JokeFormatter.format(joke)
            }
    }
}
package com.fyrl29074.chuck_norris_jokes.presentation.features.jokes

import androidx.lifecycle.ViewModel
import com.fyrl29074.chuck_norris_jokes.presentation.State
import com.fyrl29074.chuck_norris_jokes.presentation.formatter.JokeFormatter
import com.fyrl29074.domain.usecase.GetJokesListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.net.UnknownHostException

class JokesViewModel(
    private val getJokesListUseCase: GetJokesListUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<State>(State.Success(emptyList()))
    val state = _state.asStateFlow()

    suspend fun getJokes() {
        _state.value = State.Loading
        try {
            val jokesList = getJokesListUseCase.execute()
                .map { joke ->
                    JokeFormatter.format(joke)
                }
            _state.value = State.Success(jokesList)
        } catch (e: UnknownHostException) {
            _state.value = State.Error
        }
    }
}
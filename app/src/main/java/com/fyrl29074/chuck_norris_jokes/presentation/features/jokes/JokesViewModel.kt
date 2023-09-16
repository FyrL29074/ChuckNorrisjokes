package com.fyrl29074.chuck_norris_jokes.presentation.features.jokes

import androidx.lifecycle.ViewModel
import com.fyrl29074.chuck_norris_jokes.presentation.State
import com.fyrl29074.chuck_norris_jokes.presentation.formatter.JokeFormatter
import com.fyrl29074.chuck_norris_jokes.presentation.model.JokeVO
import com.fyrl29074.domain.usecase.GetJokesListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.net.UnknownHostException

class JokesViewModel(
    private val getJokesListUseCase: GetJokesListUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<State>(State.Success)
    val state = _state.asStateFlow()


    suspend fun getJokes(): List<JokeVO> {
        _state.value = State.Loading

        val jokesList = try {
            val jokesList = getJokesListUseCase.execute()
                .map { joke ->
                    JokeFormatter.format(joke)
                }
            _state.value = State.Success
            jokesList
        } catch (e: UnknownHostException) {
            _state.value = State.Error
            emptyList<JokeVO>()
        }

        return jokesList
    }
}
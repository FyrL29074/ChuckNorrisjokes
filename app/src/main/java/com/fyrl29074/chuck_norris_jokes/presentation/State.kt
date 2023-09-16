package com.fyrl29074.chuck_norris_jokes.presentation

import com.fyrl29074.chuck_norris_jokes.presentation.model.JokeVO

sealed class State {
    data class Success(val jokesList: List<JokeVO>) : State()
    data object Loading: State()
    data object Error: State()
}

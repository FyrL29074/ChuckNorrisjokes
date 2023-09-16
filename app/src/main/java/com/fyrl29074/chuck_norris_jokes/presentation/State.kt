package com.fyrl29074.chuck_norris_jokes.presentation

sealed class State {
    data object Success: State()
    data object Loading: State()
    data object Error: State()
}

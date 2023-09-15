package com.fyrl29074.chuck_norris_jokes.features.jokes

import androidx.lifecycle.ViewModel
import com.fyrl29074.chuck_norris_jokes.model.JokeVO
import kotlinx.coroutines.delay

// TODO: add useCase from another module

class JokesViewModel : ViewModel() {


    suspend fun getJokes(): List<JokeVO> {
        return createFakeJokes()
    }

    private suspend fun createFakeJokes(): List<JokeVO> {
        delay(5000)
        val fakeDataList = List<JokeVO>(20) {
            JokeVO("It is joke $it")
        }
        return fakeDataList
    }
}
package com.fyrl29074.chuck_norris_jokes.presentation.formatter

import com.fyrl29074.chuck_norris_jokes.presentation.model.JokeVO
import com.fyrl29074.domain.model.Joke

object JokeFormatter {

    fun format(joke: Joke): JokeVO {
        return JokeVO(
            joke.text
        )
    }
}
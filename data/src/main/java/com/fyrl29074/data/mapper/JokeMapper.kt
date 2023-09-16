package com.fyrl29074.data.mapper

import com.fyrl29074.data.model.JokeDto
import com.fyrl29074.domain.model.Joke

object JokeMapper {

    fun map(dto: JokeDto): Joke {
        return Joke(
            text = dto.value
        )
    }
}
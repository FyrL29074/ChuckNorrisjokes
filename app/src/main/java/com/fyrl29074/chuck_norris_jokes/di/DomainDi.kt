package com.fyrl29074.chuck_norris_jokes.di

import com.fyrl29074.domain.usecase.GetJokesListUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetJokesListUseCase> {
        GetJokesListUseCase(restRepository = get())
    }
}
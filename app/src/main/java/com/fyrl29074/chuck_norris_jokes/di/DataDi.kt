package com.fyrl29074.chuck_norris_jokes.di

import com.fyrl29074.data.repository.RestRepositoryImpl
import com.fyrl29074.domain.repository.RestRepository
import org.koin.dsl.module

val dataModule = module {

    single<RestRepository> {
        RestRepositoryImpl
    }
}
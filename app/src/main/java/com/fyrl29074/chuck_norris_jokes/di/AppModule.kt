package com.fyrl29074.chuck_norris_jokes.di

import com.fyrl29074.chuck_norris_jokes.presentation.features.jokes.JokesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<JokesViewModel> {
        JokesViewModel(getJokesListUseCase = get())
    }
}
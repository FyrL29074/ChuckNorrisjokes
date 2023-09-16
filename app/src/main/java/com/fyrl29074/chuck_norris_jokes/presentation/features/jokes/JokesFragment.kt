package com.fyrl29074.chuck_norris_jokes.presentation.features.jokes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.fyrl29074.chuck_norris_jokes.databinding.FragmentJokesBinding
import com.fyrl29074.chuck_norris_jokes.presentation.base.BaseFragment
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class JokesFragment : BaseFragment<FragmentJokesBinding>() {

    override val inflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentJokesBinding =
        FragmentJokesBinding::inflate

    private val jokesAdapter = JokesAdapter { joke -> navigateToTaskScreen(joke) }

    // TODO: remake with Koin
    private val viewModel: JokesViewModel by viewModel<JokesViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.jokes?.adapter = jokesAdapter

        lifecycleScope.launch {
            jokesAdapter.setData(viewModel.getJokes())
        }
    }

    private fun navigateToTaskScreen(joke: String) {
        val action = JokesFragmentDirections.navigateJokesToJoke(joke)
        findNavController().navigate(action)
    }
}
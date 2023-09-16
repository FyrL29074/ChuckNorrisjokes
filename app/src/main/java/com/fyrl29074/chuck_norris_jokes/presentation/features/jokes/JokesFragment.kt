package com.fyrl29074.chuck_norris_jokes.presentation.features.jokes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.fyrl29074.chuck_norris_jokes.databinding.FragmentJokesBinding
import com.fyrl29074.chuck_norris_jokes.presentation.State
import com.fyrl29074.chuck_norris_jokes.presentation.base.BaseFragment
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class JokesFragment : BaseFragment<FragmentJokesBinding>() {

    override val inflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentJokesBinding =
        FragmentJokesBinding::inflate

    private val jokesAdapter = JokesAdapter { joke -> navigateToTaskScreen(joke) }

    private val viewModel: JokesViewModel by viewModel<JokesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            viewModel.getJokes()
        }
    }

    override fun initUI() {
        super.initUI()

        binding?.jokes?.adapter = jokesAdapter
    }

    override fun initCoroutines() {
        super.initCoroutines()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.state
                    .collect { state ->
                        binding?.let { binding ->
                            when (state) {
                                is State.Success -> {
                                    binding.progressBar.isVisible = false
                                    jokesAdapter.setData(state.jokesList)
                                }

                                State.Loading -> {
                                    binding.progressBar.isVisible = true
                                }

                                State.Error -> {
                                    Toast.makeText(
                                        requireContext(),
                                        "Something went wrong...",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    binding.progressBar.isVisible = false
                                }
                            }
                        }
                    }
            }
        }
    }

    private fun navigateToTaskScreen(joke: String) {
        val action = JokesFragmentDirections.navigateJokesToJoke(joke)
        findNavController().navigate(action)
    }
}
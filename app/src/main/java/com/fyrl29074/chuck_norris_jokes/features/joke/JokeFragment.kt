package com.fyrl29074.chuck_norris_jokes.features.joke

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.fyrl29074.chuck_norris_jokes.base.BaseFragment
import com.fyrl29074.chuck_norris_jokes.databinding.FragmentJokeBinding

class JokeFragment : BaseFragment<FragmentJokeBinding>() {

    override val inflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentJokeBinding =
        FragmentJokeBinding::inflate

    private val args: JokeFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val joke = args.joke

        binding?.let { binding ->
            binding.joke.text = joke
        }
    }
}
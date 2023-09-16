package com.fyrl29074.chuck_norris_jokes.presentation.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<B : ViewBinding> : Fragment() {

    abstract val inflater: (LayoutInflater, ViewGroup?, Boolean) -> B

    private var _binding: B? = null
    protected val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflater(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
        initCoroutines()
    }

    protected open fun initUI() {
        Log.d("initUI", "initUI -> ${binding.toString()}")
    }

    protected open fun initCoroutines() {
        Log.d("initCoroutines", "initCoroutines -> ${binding.toString()}")
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
package com.example.android_3_2.ui.fragments

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.android_3_2.R
import com.example.android_3_2.data.viewModels.BleachViewModel
import com.example.android_3_2.databinding.FragmentFirstBinding
import com.example.android_3_2.ui.adapters.BleachAdapter

class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding: FragmentFirstBinding get() = _binding!!
    private val bleachAdapter = BleachAdapter()
    private val viewModel by activityViewModels<BleachViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        toGoSecondFragment()

    }

    private fun initialize() = with(binding) {
        viewModel.bleachLiveData.observe(viewLifecycleOwner) { uiState ->
            rvFirst.adapter = bleachAdapter
            uiState.success?.let {
                bleachAdapter.setBleach(it.toMutableList())
            }
        }
    }

    private fun toGoSecondFragment() = with(binding) {
        btnFirst.setOnClickListener {
            progressbar.isVisible = true
            Handler().postDelayed(
                {
                    progressbar.isVisible = false
                    findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
                },
                3000
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
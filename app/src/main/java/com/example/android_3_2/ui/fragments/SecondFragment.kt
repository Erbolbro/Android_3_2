package com.example.android_3_2.ui.fragments

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.android_3_2.R
import com.example.android_3_2.data.viewModels.BleachViewModel
import com.example.android_3_2.databinding.FragmentSecondBinding
import com.example.android_3_2.ui.model.BleachData

class SecondFragment : Fragment() {
    private var _binding: FragmentSecondBinding? = null
    private val binding: FragmentSecondBinding get() = _binding!!
    private val viewModel by activityViewModels<BleachViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goBack()

    }

    private fun goBack() = with(binding) {
        binding.btnSec.setOnClickListener {
            progressbar2.isVisible = true
            Handler().postDelayed({
                progressbar2.isVisible = false
                viewModel.addBleach(BleachData(
                    image = R.drawable.ichigo,
                    edinName.text.toString().trim()
                ))

                findNavController().navigateUp()
            }, 2000)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
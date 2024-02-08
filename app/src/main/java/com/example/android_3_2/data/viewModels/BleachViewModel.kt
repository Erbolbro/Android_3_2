package com.example.android_3_2.data.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_3_2.data.repositories.BleachRepository
import com.example.android_3_2.ui.model.BleachData
import com.example.android_3_2.utils.UiState

class BleachViewModel : ViewModel() {
    private val _bleachLiveData = MutableLiveData<UiState<List<BleachData>>>()
    val bleachLiveData: LiveData<UiState<List<BleachData>>> = _bleachLiveData
    private val bleachRepository = BleachRepository()

    init {
        getHeroes()
    }

      fun getHeroes() {

          _bleachLiveData.value = UiState(isLoading = false, success =  bleachRepository.getBleach())
      }

    fun addBleach(bleach:BleachData) {
        bleachRepository.addBleach(bleach)
    }

    override fun onCleared() {
        super.onCleared()
    }
}
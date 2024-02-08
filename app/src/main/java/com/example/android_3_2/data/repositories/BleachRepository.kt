package com.example.android_3_2.data.repositories

import com.example.android_3_2.R
import com.example.android_3_2.ui.model.BleachData

class BleachRepository {
    private val heroes = mutableListOf<BleachData>(
        BleachData(R.drawable.ichigo, "ичиго"),
        BleachData(R.drawable.ahphe, "Яхве"),
    )

    fun addBleach(bleach: BleachData) {
        heroes.add(bleach)
    }

    fun getBleach() = heroes
}
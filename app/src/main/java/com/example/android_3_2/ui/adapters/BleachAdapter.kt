package com.example.android_3_2.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_3_2.databinding.ItemBleachBinding
import com.example.android_3_2.ui.model.BleachData

class BleachAdapter : RecyclerView.Adapter<BleachAdapter.BleachViewHolder>() {
    private var bleachList = mutableListOf<BleachData>()

    fun setBleach(bleachList: MutableList<BleachData>) {
        this.bleachList = bleachList
        notifyDataSetChanged()
    }

    inner class BleachViewHolder(private val binding: ItemBleachBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(bleachData: BleachData) {
            binding.ivItem.setImageResource(bleachData.image)
            binding.textItem.text = bleachData.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BleachViewHolder {
        val binding = ItemBleachBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BleachViewHolder(binding)
    }

    override fun getItemCount() = bleachList.size

    override fun onBindViewHolder(holder: BleachViewHolder, position: Int) {
        holder.onBind(bleachList[position])
    }
}
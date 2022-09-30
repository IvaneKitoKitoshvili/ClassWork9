package com.example.classwork9.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.classwork9.databinding.SingleNumLayoutBinding
import com.example.classwork9.models.Passcode

class PasscodeAdapter : ListAdapter<Passcode, PasscodeAdapter.ConstructorsViewHolder>(
    TeamsDiffCallBack()
) {

    private lateinit var itemClickListener: (Passcode, Int) -> Unit

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ConstructorsViewHolder {
        val binding =
            SingleNumLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConstructorsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ConstructorsViewHolder, position: Int) {
        holder.bindData()
    }


    inner class ConstructorsViewHolder(private val binding: SingleNumLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private var model: Passcode? = null
        fun bindData() {
            model = getItem(adapterPosition)
            binding.apply {
                tvNum.text = model?.num
            }

            binding.tvNum.setOnClickListener {
                itemClickListener.invoke(model!!, adapterPosition)
            }

        }

    }

    fun setOnItemClickListener(clickListener: (Passcode, Int) -> Unit) {
        itemClickListener = clickListener
    }
}



class TeamsDiffCallBack : DiffUtil.ItemCallback<Passcode>() {
    override fun areItemsTheSame(
        oldItem: Passcode,
        newItem: Passcode
    ): Boolean {
        return oldItem.num == newItem.num
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: Passcode,
        newItem: Passcode
    ): Boolean {
        return oldItem == newItem
    }
}
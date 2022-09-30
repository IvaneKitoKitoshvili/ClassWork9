package com.example.classwork9.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.classwork9.R
import com.example.classwork9.databinding.SingleDotLayoutBinding
import com.example.classwork9.models.Dots

class DotsAdapter : ListAdapter<Dots, DotsAdapter.DotsViewHolder>(
    DotsCallBack()
) {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): DotsViewHolder {
        val binding =
            SingleDotLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DotsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DotsViewHolder, position: Int) {
        holder.bindData()
    }


    inner class DotsViewHolder(private val binding: SingleDotLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private var model: Dots? = null
        fun bindData() {
            model = getItem(adapterPosition)
            binding.apply {
                if (model!!.isChecked) {
                    tvDot.setImageResource(R.drawable.bluedots_active)
                } else {
                    tvDot.setImageResource(R.drawable.bluedots)
                }
            }
        }
    }


    class DotsCallBack : DiffUtil.ItemCallback<Dots>() {
        override fun areItemsTheSame(
            oldItem: Dots,
            newItem: Dots
        ): Boolean {
            return oldItem == newItem
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(
            oldItem: Dots,
            newItem: Dots
        ): Boolean {
            return oldItem == newItem
        }
    }
}
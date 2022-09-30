package com.example.classwork9.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.classwork9.BaseFragment
import com.example.classwork9.adapter.DotsAdapter
import com.example.classwork9.adapter.PasscodeAdapter
import com.example.classwork9.databinding.ActivityMainBinding.inflate
import com.example.classwork9.databinding.FragmentPasscodeBinding

class PasscodeFragment : BaseFragment<FragmentPasscodeBinding>(FragmentPasscodeBinding::inflate) {

    private val dotsAdapter: DotsAdapter by lazy { DotsAdapter() }
    private val passcodeAdapter: PasscodeAdapter by lazy { PasscodeAdapter() }

    private val itemsList = mutableListOf<Password>()
    private val inputList = mutableListOf<String>()
    private val dots = mutableListOf<Dots>()
    private val ourPass = "5203"


    override fun viewCreated() {

        setupRecycler()
        setupDotsRecycler()
        populateDots()
        populateList()

    }

    override fun listeners() {
        inputNumber()
    }

    private fun inputNumber() {
        myAdapter.apply {
            setOnItemClickListener { num, _ ->

                val filteredNum = num.toString().filter { it.isDigit() }
                inputList.add(filteredNum)

                for (index in dots.indices){
                    Log.d("misho","${index.toString()} indexi")
                    if(!dots[index].isChecked){
                        dots[index] = Dots(true)
                        dotsAdapter.submitList(dots.toList())
                        break
                    }
                }

                Log.d("misho", inputList.toString()) // amas su wers

                if (inputList.size == 4) {
                    val listAsString =
                        "${inputList[0]}${inputList[1]}${inputList[2]}${inputList[3]}"
                    Log.d("misho", "$listAsString aq unda shewydes")
                    if (listAsString == ourPass) {
                        Toast.makeText(requireContext(), "parolebi emtxveva!", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
    }


    private fun setupRecycler() {
        binding.rvMyrv.apply {
            adapter = myAdapter
            layoutManager =
                GridLayoutManager(
                    requireContext(), 3, GridLayoutManager.VERTICAL, false
                )
        }
        myAdapter.submitList(itemsList)
    }

    private fun setupDotsRecycler() {
        binding.rvDots.apply {
            adapter = dotsAdapter
            layoutManager =
                LinearLayoutManager(
                    requireContext(), LinearLayoutManager.HORIZONTAL, false
                )
        }
        dotsAdapter.submitList(dots)
    }


    private fun populateDots() {
        dots.add(
            Dots(
                false
            )
        )
        dots.add(
            Dots(
                false
            )
        )
        dots.add(
            Dots(
                false
            )
        )
        dots.add(
            Dots(
                false
            )
        )

    }

    private fun populateList() {
        itemsList.add(
            Password(
                "1",
            )
        )
        itemsList.add(
            Password(
                "2",
            )
        )
        itemsList.add(
            Password(
                "3",
            )
        )
        itemsList.add(
            Password(
                "4",
            )
        )
        itemsList.add(
            Password(
                "5",
            )
        )
        itemsList.add(
            Password(
                "6",
            )
        )
        itemsList.add(
            Password(
                "7",
            )
        )
        itemsList.add(
            Password(
                "8",
            )
        )
        itemsList.add(
            Password(
                "9",
            )
        )
        itemsList.add(
            Password(
                "0",
            )
        )
    }
}
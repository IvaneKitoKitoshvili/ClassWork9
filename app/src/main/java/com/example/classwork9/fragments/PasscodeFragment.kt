package com.example.classwork9.fragments

import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.classwork9.BaseFragment
import com.example.classwork9.adapter.DotsAdapter
import com.example.classwork9.adapter.PasscodeAdapter
import com.example.classwork9.databinding.FragmentPasscodeBinding
import com.example.classwork9.models.Dots
import com.example.classwork9.models.Passcode

class PasscodeFragment : BaseFragment<FragmentPasscodeBinding>(FragmentPasscodeBinding::inflate) {

    private val dotsAdapter: DotsAdapter by lazy { DotsAdapter() }
    private val passcodeAdapter: PasscodeAdapter by lazy { PasscodeAdapter() }

    private val itemsList = mutableListOf<Passcode>()
    private val inputList = mutableListOf<String>()
    private val dots = mutableListOf<Dots>()
    private val myPasscode = "0934"


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
        passcodeAdapter.apply {
            setOnItemClickListener { num, _ ->

                val filteredNum = num.toString().filter { it.isDigit() }
                inputList.add(filteredNum)

                for (index in dots.indices){
                    if(!dots[index].isChecked){
                        dots[index] = Dots(true)
                        dotsAdapter.submitList(dots.toList())
                        break
                    }
                }

                if (inputList.size == 4) {
                    val listAsString =
                        "${inputList[0]}${inputList[1]}${inputList[2]}${inputList[3]}"
                    if (listAsString == myPasscode) {
                        Toast.makeText(requireContext(), "parolebi emtxveva!", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
    }


    private fun setupRecycler() {
        binding.rvMyrv.apply {
            adapter = passcodeAdapter
            layoutManager =
                GridLayoutManager(
                    requireContext(), 3, GridLayoutManager.VERTICAL, false
                )
        }
        passcodeAdapter.submitList(itemsList)
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
            Passcode(
                "1",
            )
        )
        itemsList.add(
            Passcode(
                "2",
            )
        )
        itemsList.add(
            Passcode(
                "3",
            )
        )
        itemsList.add(
            Passcode(
                "4",
            )
        )
        itemsList.add(
            Passcode(
                "5",
            )
        )
        itemsList.add(
            Passcode(
                "6",
            )
        )
        itemsList.add(
            Passcode(
                "7",
            )
        )
        itemsList.add(
            Passcode(
                "8",
            )
        )
        itemsList.add(
            Passcode(
                "9",
            )
        )
        itemsList.add(
            Passcode(
                "0",
            )
        )
    }
}
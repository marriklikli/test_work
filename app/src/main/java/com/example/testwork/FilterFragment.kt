package com.example.testwork

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.testwork.databinding.FragmentFilterBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class FilterFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentFilterBinding
    private lateinit var viewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()
        viewModel = ViewModelProvider(activity).get(MainViewModel::class.java)
        binding.saveBotton.setOnClickListener{
            save()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentFilterBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun save() {
        viewModel.price.value = binding.price.text.toString()
        binding.price.setText("")
        dismiss()
    }
}
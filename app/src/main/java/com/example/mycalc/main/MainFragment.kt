package com.example.mycalc.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mycalc.databinding.FragmentMainBinding
import com.google.android.material.snackbar.Snackbar

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val model: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.apply {
            handler = this@MainFragment
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun onClick(view: View) {
        var temp = binding.num1Edit.text.toString()
        if(temp == "") {
            Snackbar.make(view, "数値1に入力がありません", Snackbar.LENGTH_SHORT).show()
            return
        }
        val num1 = temp.toInt()

        temp = binding.num2Edit.text.toString()
        if(temp == "") {
            Snackbar.make(view, "数値2に入力がありません", Snackbar.LENGTH_SHORT).show()
            return
        }
        val num2 = temp.toInt()

        val operator = binding.operatorList.selectedItem as String

        val action = MainFragmentDirections.actionMainFragmentToResultFragment(
            num1, num2, operator
        )
        findNavController().navigate(action)
    }
}
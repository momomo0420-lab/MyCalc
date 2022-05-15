package com.example.mycalc.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.mycalc.databinding.FragmentResultBinding
import com.google.android.material.snackbar.Snackbar

class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    private val model: ResultViewModel by viewModels()

    private val args: ResultFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            model = this@ResultFragment.model
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val num1 = args.num1
        val num2 = args.num2

        val result = when(args.operator) {
            "+" -> {
                num1 + num2
            }
            "-" -> {
                num1 - num2
            }
            "*" -> {
                num1 * num2
            }
            "/" -> {
                if(num2 == 0) {
                    Snackbar.make(view, "０除算はできません", Snackbar.LENGTH_SHORT).show()
                    0
                } else {
                    num1 / num2
                }
            }
            else -> {
                0
            }
        }
        model.setResult(result.toString())
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
package com.example.mycalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mycalc.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            handler = this@MainActivity
        }
        setContentView(binding.root)
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

        val result = when(binding.operatorList.selectedItem as String) {
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

        binding.resultText.text = result.toString()
    }
}
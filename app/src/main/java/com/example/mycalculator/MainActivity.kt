package com.example.mycalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mycalculator.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.buttonAC.setOnClickListener {
            binding.textViewResult.text = ""
            binding.textViewInput.text = ""
        }
        binding.buttonDelete.setOnClickListener {
            val removedLast = binding.textViewResult.text.toString().dropLast(1)
            binding.textViewResult.text = removedLast
        }
        binding.button0.setOnClickListener {
            binding.textViewResult.text = binding.textViewResult.text.toString() + "0"
        }
        binding.button1.setOnClickListener {
            binding.textViewResult.text = binding.textViewResult.text.toString() + "1"
        }
        binding.button2.setOnClickListener {
            binding.textViewResult.text = binding.textViewResult.text.toString() + "2"
        }
        binding.button3.setOnClickListener {
            binding.textViewResult.text = binding.textViewResult.text.toString() + "3"
        }
        binding.button4.setOnClickListener {
            binding.textViewResult.text = binding.textViewResult.text.toString() + "4"
        }
        binding.button5.setOnClickListener {
            binding.textViewResult.text = binding.textViewResult.text.toString() + "5"
        }
        binding.button6.setOnClickListener {
            binding.textViewResult.text = binding.textViewResult.text.toString() + "6"
        }
        binding.button7.setOnClickListener {
            binding.textViewResult.text = binding.textViewResult.text.toString() + "7"
        }
        binding.button8.setOnClickListener {
            binding.textViewResult.text = binding.textViewResult.text.toString() + "8"
        }
        binding.button9.setOnClickListener {
            binding.textViewResult.text = binding.textViewResult.text.toString() + "9"
        }
        binding.buttonCham.setOnClickListener {
            binding.textViewResult.text = binding.textViewResult.text.toString() + "."
        }
        binding.buttonChia.setOnClickListener {
            binding.textViewInput.text =
                binding.textViewAmduong.text.toString() + binding.textViewResult.text.toString() + "÷"
            binding.textViewResult.text = ""
            if (binding.textViewAmduong.text == "-") {
                binding.textViewAmduong.text = ""
            }
        }
        binding.buttonNhan.setOnClickListener {
            binding.textViewInput.text =
                binding.textViewAmduong.text.toString() + binding.textViewResult.text.toString() + "×"
            binding.textViewResult.text = ""
            if (binding.textViewAmduong.text == "-") {
                binding.textViewAmduong.text = ""
            }
        }
        binding.buttonTru.setOnClickListener {
            binding.textViewInput.text =
                binding.textViewAmduong.text.toString() + binding.textViewResult.text.toString() + "-"
            binding.textViewResult.text = ""
            if (binding.textViewAmduong.text == "-") {
                binding.textViewAmduong.text = ""
            }
        }
        binding.buttonCong.setOnClickListener {
            binding.textViewInput.text =
                binding.textViewAmduong.text.toString() + binding.textViewResult.text.toString() + "+"
            binding.textViewResult.text = ""
            if (binding.textViewAmduong.text == "-") {
                binding.textViewAmduong.text = ""
            }
        }
        binding.buttonBang.setOnClickListener {
            if (binding.textViewAmduong.text == "-") {
                binding.textViewAmduong.text = ""
            }
            binding.textViewInput.text = binding.textViewInput.text.toString() +
                    binding.textViewAmduong.text.toString() + binding.textViewResult.text.toString()
            val expressionString = binding.textViewInput.text.toString()
            try {
                val expression = Expression(expressionString)
                val result = expression.calculate()
                val formattedResult = if (result % 1 == 0.0) {
                    result.toInt().toString()
                } else {
                    result.toString()
                }
                binding.textViewResult.text = formattedResult
            } catch (e: Exception) {
                binding.textViewResult.text = "Error"
            }
        }
        binding.buttonAmduong.setOnClickListener {
            if (binding.textViewAmduong.text == "") {
                binding.textViewAmduong.text = "-"
            } else {
                binding.textViewAmduong.text = ""
            }
        }
    }

}
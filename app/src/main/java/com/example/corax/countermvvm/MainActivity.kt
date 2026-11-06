package com.example.corax.countermvvm

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var counterText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        counterText = findViewById(R.id.text_counter)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        observeViewModel()
        initView()
    }

    private fun observeViewModel() {
        viewModel.counter.observe(this) { count ->
            counterText.text = count.toString()
        }
    }

    private fun initView() {
        findViewById<Button>(R.id.btn_increment).setOnClickListener {
            viewModel.onIncrementClicked()
        }
    }
}
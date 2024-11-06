package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var tvMeal: TextView
    private lateinit var btnSelect: Button

    private val startForResult: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val intent = result.data
                intent?.extras?.let { bundle ->
                    val drink = bundle.getString("drink")
                    val sugar = bundle.getString("sugar")
                    val ice = bundle.getString("ice")
                    tvMeal.text = "飲料: $drink\n\n甜度: $sugar\n\n冰塊: $ice"
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvMeal = findViewById(R.id.tv_meal)
        btnSelect = findViewById(R.id.btn_choice)

        btnSelect.setOnClickListener {
            startForResult.launch(Intent(this, MainActivity2::class.java))
        }
    }
}

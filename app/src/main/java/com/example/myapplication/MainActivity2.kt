package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    private lateinit var setDrink: EditText
    private lateinit var rg1: RadioGroup
    private lateinit var rg2: RadioGroup
    private lateinit var btnSend: Button

    private var sugar = "無糖"
    private var iceOpt = "去冰"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        rg1 = findViewById(R.id.radioGroup)
        rg1.setOnCheckedChangeListener { _, i ->
            sugar = when (i) {
                R.id.radiobutton1 -> "無糖"
                R.id.radiobutton2 -> "少糖"
                R.id.radiobutton3 -> "半糖"
                R.id.radiobutton4 -> "全糖"
                else -> sugar
            }
        }

        rg2 = findViewById(R.id.radioGroup2)
        rg2.setOnCheckedChangeListener { _, i ->
            iceOpt = when (i) {
                R.id.radiobutton5 -> "去冰"
                R.id.radiobutton6 -> "微冰"
                R.id.radiobutton7 -> "少冰"
                R.id.radiobutton8 -> "正常冰"
                else -> iceOpt
            }
        }

        btnSend = findViewById(R.id.btn_send)
        btnSend.setOnClickListener {
            setDrink = findViewById(R.id.ed_drink)
            val drink = setDrink.text.toString()
            val intent = Intent().apply {
                putExtras(Bundle().apply {
                    putString("drink", drink)
                    putString("sugar", sugar)
                    putString("ice", iceOpt)
                })
            }
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}

package com.example.intentservice_k

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ///
        val start = findViewById<Button>(R.id.start)
        val stop = findViewById<Button>(R.id.stop)
        val service = findViewById<TextView>(R.id.service)

        start.setOnClickListener { view: View? ->
            val intent = Intent(this, ServiceIntent::class.java)
            startService(intent)
            service.text = "Running"
        }
        stop.setOnClickListener { view: View? ->
            ServiceIntent.stopService()
            service.text = "Stop"
        }

    }
}
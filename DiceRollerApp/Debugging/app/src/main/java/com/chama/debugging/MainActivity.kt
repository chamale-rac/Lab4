package com.chama.debugging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "this is where the app crashed before")
        val helloTextView: TextView = findViewById(R.id.hello_world)
        Log.d(TAG, "this should be logged if the bug is fixed")
        helloTextView.text = "Hello, debugging!"
        division()
    }
    fun division() {
        val numerator = 60
        var denominator = 4
        repeat(5) {
            Log.v(TAG, "${numerator / denominator}")
            denominator--
        }
    }

}
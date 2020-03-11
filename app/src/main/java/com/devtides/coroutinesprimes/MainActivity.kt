package com.devtides.coroutinesprimes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    var currentPrime = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
//        while (true){
        for (i in 2..100) {
            generateNextPrime()
            result.text = currentPrime.toString()
        }
    }

    private fun generateNextPrime() {
        var number = currentPrime
        loop@ while(true) {
            number++
            if (number % 2 == 0)
                continue
            val sqrt = sqrt(number.toDouble()).toInt()
            for (i in 3..sqrt step 2) {
                if (number % i ==0)
                    continue@loop
            }
            currentPrime = number
            return
        }
    }
}

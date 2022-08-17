package com.chama.dicerollerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**
 * Allows the user roll the dice and get the number in the screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
        rollDice()
    }

    /**
     * This use the Dice class and asign the returned value to the textView
     */
    private fun rollDice() {
        // Create a dice of 6 faces
        val dice = Dice(6)
        val diceRoll = dice.roll()

        val diceImage: ImageView = findViewById(R.id.imageView)

        // Choose dice image
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Assign new image
        diceImage.setImageResource(drawableResource)

        // Content description
        diceImage.contentDescription = diceRoll.toString()
    }
}
/**
* This simulate the Dice, and the function of roll it
*/
class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}
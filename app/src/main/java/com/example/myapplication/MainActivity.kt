package com.example.myapplication

import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.rollButton)
        val countUpButton: Button = findViewById(R.id.countUpButton)
        val resetButton: Button = findViewById(R.id.resetButton)
        val textResult: TextView = findViewById(R.id.result_text)
        val diceImage: ImageView = findViewById(R.id.dice_image)
        val diceImage1: ImageView = findViewById(R.id.dice_image1)
        var randomInt1:Int
        rollButton.setOnClickListener {
            rollDice()
            var randomInt = (1..6).random()
            textResult.text = randomInt.toString()
            val drawableResource = Image(randomInt)
            diceImage.setImageResource(drawableResource)
            randomInt1 = getRandomDiceImage(randomInt)
            val drawableResource1 = Image(randomInt1)
            diceImage1.setImageResource(drawableResource1)
        }
        countUpButton.setOnClickListener {
            if (textResult.text.toString().contentEquals("Hello World!")) {
                textResult.text = "1"
                diceImage.setImageResource(R.drawable.dice_1)

            } else {
                var temp = textResult.text.toString().toInt()
                if (temp < 6) {
                    temp += 1
                    textResult.text = temp.toString()
                    diceImage.setImageResource(Image(temp))
                    randomInt1 = getRandomDiceImage(temp)
                    if(randomInt1<6){
                        randomInt1+=1
                        diceImage1.setImageResource(Image(randomInt1))
                    }
                }
            }
        }
        resetButton.setOnClickListener {
            textResult.text = "0"
            diceImage1.setImageResource(R.drawable.empty_dice)
            diceImage.setImageResource(R.drawable.empty_dice)

        }

    }

    private fun rollDice() {

        Toast.makeText(
            this, "button clicked",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun Image(randomInt: Int): Int {
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
        return drawableResource
    }

    private fun getRandomDiceImage(randomInt: Int): Int {
        var randomInt1 = (1..6).random()
        while(true){
            if(randomInt1!=randomInt){
                return randomInt1
            }
            randomInt1 = (1..6).random()
        }
    }
}

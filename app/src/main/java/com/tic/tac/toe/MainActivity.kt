package com.tic.tac.toe

import android.animation.ObjectAnimator
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.graphics.Color
import android.media.MediaPlayer
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private var click: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val p1: TextView = findViewById(R.id.P1)
        val p2: TextView = findViewById(R.id.P2)
        val p3: TextView = findViewById(R.id.P3)
        val p4: TextView = findViewById(R.id.P4)
        val p5: TextView = findViewById(R.id.P5)
        val p6: TextView = findViewById(R.id.P6)
        val p7: TextView = findViewById(R.id.P7)
        val p8: TextView = findViewById(R.id.P8)
        val p9: TextView = findViewById(R.id.P9)
        val blue = Color.BLUE
        val green = Color.GREEN
        val yellow = Color.YELLOW
        val white = Color.WHITE
        click = MediaPlayer.create(this, R.raw.click)
        val winGame = MediaPlayer.create(this, R.raw.game_win)
        val button = listOf(p1, p2, p3, p4, p5, p6, p7, p8, p9)
        val result: TextView = findViewById(R.id.resultStatus)
        val resultLayout: LinearLayout = findViewById(R.id.winnerLayout)
        val bottomView: View = findViewById(R.id.bottom_View)
        val resetGame: Button = findViewById(R.id.reset_game)
        val playAgain: Button = findViewById(R.id.play_game)
        var changeTurn = "X"
        val upperText: TextView = findViewById(R.id.app_upper_TXT)
        val textAnimation = ObjectAnimator.ofFloat(upperText, "translationX", 500f, 0f)
        textAnimation.duration = 1500
        textAnimation.start()

        fun setVisibility() {
            winGame.seekTo(50)
            winGame.start()
            resultLayout.visibility = View.VISIBLE
            playAgain.visibility = View.VISIBLE
            bottomView.visibility = View.VISIBLE
            resetGame.visibility = View.INVISIBLE
            changeTurn = "X"
            for (i in button){
                i.isClickable = false
            }
        }

        fun checkWinners() {
            click?.seekTo(50)
            if (p1.text == "0" && p2.text == "0" && p3.text == "0" || p1.text == "X" && p2.text == "X" && p3.text == "X"){
                setVisibility()
                for (i in button) {
                    p1.setBackgroundColor(yellow)
                    p2.setBackgroundColor(yellow)
                    p3.setBackgroundColor(yellow)
                }
            }
            if (p4.text == "0" && p5.text == "0" && p6.text == "0" || p4.text == "X" && p5.text == "X" && p6.text == "X"){
                setVisibility()
                for (i in button) {
                    p4.setBackgroundColor(yellow)
                    p5.setBackgroundColor(yellow)
                    p6.setBackgroundColor(yellow)
                }
            }
            if (p7.text == "0" && p8.text == "0" && p9.text == "0" || p7.text == "X" && p8.text == "X" && p9.text == "X"){
                setVisibility()
                for (i in button) {
                    p7.setBackgroundColor(yellow)
                    p8.setBackgroundColor(yellow)
                    p9.setBackgroundColor(yellow)
                }
            }
            if (p1.text == "0" && p4.text == "0" && p7.text == "0" || p1.text == "X" && p4.text == "X" && p7.text == "X"){
                setVisibility()
                for (i in button) {
                    p1.setBackgroundColor(yellow)
                    p4.setBackgroundColor(yellow)
                    p7.setBackgroundColor(yellow)
                }
            }
            if (p2.text == "0" && p5.text == "0" && p8.text == "0" || p2.text == "X" && p5.text == "X" && p8.text == "X"){
                setVisibility()
                for (i in button) {
                    p2.setBackgroundColor(yellow)
                    p5.setBackgroundColor(yellow)
                    p8.setBackgroundColor(yellow)
                }
            }
            if (p3.text == "0" && p6.text == "0" && p9.text == "0" || p3.text == "X" && p6.text == "X" && p9.text == "X"){
                setVisibility()
                for (i in button) {
                    p3.setBackgroundColor(yellow)
                    p6.setBackgroundColor(yellow)
                    p9.setBackgroundColor(yellow)
                }
            }
            if (p1.text == "0" && p5.text == "0" && p9.text == "0" || p1.text == "X" && p5.text == "X" && p9.text == "X"){
                setVisibility()
                for (i in button) {
                    p1.setBackgroundColor(yellow)
                    p5.setBackgroundColor(yellow)
                    p9.setBackgroundColor(yellow)
                }
            }
            if (p3.text == "0" && p5.text == "0" && p7.text == "0" || p3.text == "X" && p5.text == "X" && p7.text == "X"){
                setVisibility()
                for (i in button) {
                    p3.setBackgroundColor(yellow)
                    p5.setBackgroundColor(yellow)
                    p7.setBackgroundColor(yellow)
                }
            }
        }

        fun common(): String {
            checkWinners()
            click?.seekTo(50)
            click?.start()
            val winnerText = "Congratulations, Winner Is $changeTurn"
            result.text = winnerText
            changeTurn = when (changeTurn){
                "X" -> "0"
                else -> "X"
            }
            return changeTurn
        }

        playAgain.setOnClickListener{
            click?.seekTo(50)
            click?.start()
            resultLayout.visibility = View.INVISIBLE
            bottomView.visibility = View.INVISIBLE
            playAgain.visibility = View.INVISIBLE
            resetGame.visibility = View.VISIBLE
            changeTurn = "X"
            for (i in button) {
                i.text = ""
                i.isClickable = true
                i.setBackgroundColor(white)
            }
        }

        resetGame.setOnClickListener {
            click?.seekTo(50)
            click?.start()
            resultLayout.visibility = View.INVISIBLE
            bottomView.visibility = View.INVISIBLE
            changeTurn = "X"
            for (i in button) {
                i.text = ""
                i.isClickable = true
                i.setBackgroundColor(white)
            }
        }
        p1.setOnClickListener {
            p1.text = changeTurn
            if (p1.text == "X") p1.setTextColor(blue) else p1.setTextColor(green)
            p1.isClickable = false
            common()
        }
        p2.setOnClickListener {
            p2.text = changeTurn
            if (p2.text == "X") p2.setTextColor(blue) else p2.setTextColor(green)
            p2.isClickable = false
            common()
        }
        p3.setOnClickListener {
            p3.text = changeTurn
            if (p3.text == "X") p3.setTextColor(blue) else p3.setTextColor(green)
            p3.isClickable = false
            common()
        }
        p4.setOnClickListener {
            p4.text = changeTurn
            if (p4.text == "X") p4.setTextColor(blue) else p4.setTextColor(green)
            p4.isClickable = false
            common()
        }
        p5.setOnClickListener {
            p5.text = changeTurn
            if (p5.text == "X") p5.setTextColor(blue) else p5.setTextColor(green)
            p5.isClickable = false
            common()
        }
        p6.setOnClickListener {
            p6.text = changeTurn
            if (p6.text == "X") p6.setTextColor(blue) else p6.setTextColor(green)
            p6.isClickable = false
            common()
        }
        p7.setOnClickListener {
            p7.text = changeTurn
            if (p7.text == "X") p7.setTextColor(blue) else p7.setTextColor(green)
            p7.isClickable = false
            common()
        }
        p8.setOnClickListener {
            p8.text = changeTurn
            if (p8.text == "X") p8.setTextColor(blue) else p8.setTextColor(green)
            p8.isClickable = false
            common()
        }
        p9.setOnClickListener {
            p9.text = changeTurn
            if (p9.text == "X") p9.setTextColor(blue) else p9.setTextColor(green)
            p9.isClickable = false
            common()
        }
    }
    private val exit = 0
    @Suppress("DEPRECATION")
    @Deprecated("DEPRECATION")

    override fun onBackPressed() {
        click?.seekTo(50)
        click?.start()
        when(exit){
            0 -> exitDialog()
            else -> super.onBackPressed()
        }
    }

    private fun exitDialog() {
        val exitDetails = AlertDialog.Builder(this)
        exitDetails.setTitle("Exit")
        exitDetails.setMessage("Do You Want To Exit?")
        exitDetails.setIcon(R.drawable.exit)

        exitDetails.setPositiveButton("Yes"){_: DialogInterface, _: Int ->
            click?.seekTo(50)
            click?.start()
            finish()
        }
        exitDetails.setNegativeButton("No"){dialog: DialogInterface,_: Int ->
            click?.seekTo(50)
            click?.start()
            dialog.dismiss()
        }
        val showDialog = exitDetails.create()
        showDialog.show()
    }
}
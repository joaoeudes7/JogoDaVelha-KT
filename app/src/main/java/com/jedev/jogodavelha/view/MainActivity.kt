package com.jedev.jogodavelha.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.jedev.jogodavelha.R
import com.jedev.jogodavelha.controllers.JogoDaVelhaController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val controller = JogoDaVelhaController(this)
    private var dialogAlertDialog: AlertDialog.Builder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dialogAlertDialog = AlertDialog.Builder(this)

        controller.model.setOnWinnerPlayerListener = {
            Log.i("INFO", "GANHAOU!!")
            dialogAlertDialog!!.setTitle("Booooaaaaa!")
                    .setMessage("O Jogador ${it} ganhou o jogo!")
                    .setPositiveButton("Reiniciar") { dialog, which ->
                        controller.restartGame()
                        image_1.setImageDrawable(null)
                        image_2.setImageDrawable(null)
                        image_3.setImageDrawable(null)
                        image_4.setImageDrawable(null)
                        image_5.setImageDrawable(null)
                        image_6.setImageDrawable(null)
                        image_7.setImageDrawable(null)
                        image_8.setImageDrawable(null)
                        image_9.setImageDrawable(null)

                    }
                    .show()
        }

        controller.model.setOnDrawListener = {
            Log.i("INFO", "EMPATE!")
            dialogAlertDialog!!.setTitle("OH NÃO!")
                    .setMessage("O Jogador saiu em empate!")
                    .show()
        }

        cardView_1.setOnClickListener {
            controller.newPlay(1, image_1)
        }
        cardView_2.setOnClickListener {
            controller.newPlay(2, image_2)
        }
        cardView_3.setOnClickListener {
            controller.newPlay(3, image_3)
        }
        cardView_4.setOnClickListener {
            controller.newPlay(4, image_4)
        }
        cardView_5.setOnClickListener {
            controller.newPlay(5, image_5)
        }
        cardView_6.setOnClickListener {
            controller.newPlay(6, image_6)
        }
        cardView_7.setOnClickListener {
            controller.newPlay(7, image_7)
        }
        cardView_8.setOnClickListener {
            controller.newPlay(8, image_8)
        }
        cardView_9.setOnClickListener {
            controller.newPlay(9, image_9)
        }
    }
}

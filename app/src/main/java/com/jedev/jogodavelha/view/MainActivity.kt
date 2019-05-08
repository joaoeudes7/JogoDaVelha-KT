package com.jedev.jogodavelha.view

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.jedev.jogodavelha.R
import com.jedev.jogodavelha.controllers.JogoDaVelhaController
import com.jedev.jogodavelha.models.JogoDaVelha
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val model = JogoDaVelha()
    private val controller = JogoDaVelhaController(this, model)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        controller.setClickRestart(btn_restart)

        controller.setClickListenerPosition(cardView_1, 1, image_1)
        controller.setClickListenerPosition(cardView_2, 2, image_2)
        controller.setClickListenerPosition(cardView_3, 3, image_3)
        controller.setClickListenerPosition(cardView_4, 4, image_4)
        controller.setClickListenerPosition(cardView_5, 5, image_5)
        controller.setClickListenerPosition(cardView_6, 6, image_6)
        controller.setClickListenerPosition(cardView_7, 7, image_7)
        controller.setClickListenerPosition(cardView_8, 8, image_8)
        controller.setClickListenerPosition(cardView_9, 9, image_9)

        val dialogAlertDialog = AlertDialog.Builder(this)

        model.setOnWinnerPlayerListener = {
            dialogAlertDialog.setTitle("Booooaaaaa!")
                    .setMessage("O Jogador ${it} ganhou o jogo!")
                    .setPositiveButton("Reiniciar") { dialog, which ->
                        controller.restartGame()
                        controller.resetImageView(image_1)
                        controller.resetImageView(image_2)
                        controller.resetImageView(image_3)
                        controller.resetImageView(image_4)
                        controller.resetImageView(image_5)
                        controller.resetImageView(image_6)
                        controller.resetImageView(image_7)
                        controller.resetImageView(image_8)
                        controller.resetImageView(image_9)

                    }
                    .show()
        }

        model.setOnDrawListener = {
            dialogAlertDialog.setTitle("OH NÃO!")
                    .setMessage("O Jogador saiu em empate!")
                    .show()
        }
    }
}

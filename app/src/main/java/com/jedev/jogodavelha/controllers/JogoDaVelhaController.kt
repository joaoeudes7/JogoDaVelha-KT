package com.jedev.jogodavelha.controllers

import android.content.Context
import android.widget.ImageView
import com.jedev.jogodavelha.R
import com.jedev.jogodavelha.enums.PLAYER
import com.jedev.jogodavelha.models.JogoDaVelha

class JogoDaVelhaController() {

    var model = JogoDaVelha()
    lateinit var ctx: Context

    val imgsMap = hashMapOf(
            PLAYER.X to R.drawable.ic_close,
            PLAYER.O to R.drawable.ic_icons8_round_filled
    )

    constructor(context: Context) : this() {
        ctx = context
    }

    fun restartGame() {
        model.restart()
    }

    fun newPlay(position: Int, imageView: ImageView) {
        if (position !in model.allPlayeds && model.winner == null) {
            model.play(position)
            imageView.setImageDrawable(ctx.resources.getDrawable(
                    imgsMap[model.currentPlayer]!!,
                    ctx.theme)
            )
            model.togglePlayer()
        }
    }
}
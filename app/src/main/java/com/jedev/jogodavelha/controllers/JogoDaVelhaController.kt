package com.jedev.jogodavelha.controllers

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.jedev.jogodavelha.R
import com.jedev.jogodavelha.enums.PLAYER
import com.jedev.jogodavelha.models.JogoDaVelha

class JogoDaVelhaController() {

    private lateinit var ctx: Context
    private lateinit var model: JogoDaVelha
    private val listImages = arrayListOf<ImageView>()

    val imgsMap = hashMapOf(
            PLAYER.X to R.drawable.ic_close,
            PLAYER.O to R.drawable.ic_icons8_round_filled
    )

    constructor(context: Context, model: JogoDaVelha) : this() {
        this.ctx = context
        this.model = model
    }

    fun restartGame() {
        model.restart()

        // Clear images of cells
        this.listImages.forEach {
            resetImageView(it)
        }
    }

    private fun newPlay(position: Int, imageView: ImageView) {
        if (position !in model.allPlayeds && model.winner == null) {
            model.play(position)
            imageView.setImageDrawable(ctx.resources.getDrawable(
                    imgsMap[model.currentPlayer]!!,
                    ctx.theme)
            )
            model.togglePlayer()
        }
    }

    fun setClickRestart(btn: Button) {
        btn.setOnClickListener {
            this.restartGame()
        }
    }

    fun setClickListenerPosition(element: View, position: Int, imageView: ImageView) {
        element.setOnClickListener {
            this.newPlay(position, imageView)
            this.listImages.add(imageView)
        }
    }

    fun resetImageView(imageView: ImageView) {
        imageView.setImageDrawable(null)
    }
}
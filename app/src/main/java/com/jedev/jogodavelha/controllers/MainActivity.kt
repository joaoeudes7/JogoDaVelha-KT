package com.jedev.jogodavelha.controllers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jedev.jogodavelha.R
import com.jedev.jogodavelha.models.JogoDaVelha

class MainActivity : AppCompatActivity() {

    val model: JogoDaVelha = JogoDaVelha()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

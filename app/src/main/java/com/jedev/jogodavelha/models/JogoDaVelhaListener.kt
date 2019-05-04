package com.jedev.jogodavelha.models

import com.jedev.jogodavelha.enums.PLAYER

interface JogoDaVelhaListener {
    var setOnWinnerPlayerListener: ((PLAYER) -> Unit)?
    var setOnPlayListener: ((Int) -> Unit)?
    var setOnFinishListener: (() -> Unit)?
    var setOnDrawListener: (() -> Unit)?
}
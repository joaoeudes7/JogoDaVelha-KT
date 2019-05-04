package com.jedev.jogodavelha.models

import com.jedev.jogodavelha.enums.GAMERESULT
import com.jedev.jogodavelha.enums.GAMESTATE
import com.jedev.jogodavelha.enums.PLAYER
import kotlin.properties.Delegates.observable

class JogoDaVelha : JogoDaVelhaListener {
    var winner by observable<PLAYER?>(null, { property, oldValue, newValue ->
        if (newValue != null) {
            setOnWinnerPlayerListener?.invoke(newValue)
        }
    })
    var state: GAMESTATE? = null
    var result: GAMERESULT? = null

    var currentPlayer = PLAYER.X
    var currentPosition by observable<Int?>(null, { property, oldValue, newValue ->
        setOnPlayListener?.invoke(newValue!!)
    })

    val methodsWinners = listOf(
            listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9),
            listOf(1, 4, 7), listOf(2, 5, 8), listOf(3, 6, 9),
            listOf(1, 5, 9), listOf(3, 5, 7)
    )

    var players: HashMap<PLAYER, MutableList<Int>> = hashMapOf(
            PLAYER.X to mutableListOf(),
            PLAYER.O to mutableListOf()
    )

    val allPlayeds: List<Int>
        get() = players[PLAYER.X]!! + players[PLAYER.O]!!

    val totalPlayeds: Int
        get() = allPlayeds.size

    init {
        restart()
    }

    fun restart() {
        winner = null
        state = GAMESTATE.IN_PROGRESS
        players[PLAYER.X]!!.clear()
        players[PLAYER.O]!!.clear()
    }

    fun play(position: Int) {
        currentPosition = position
        players[currentPlayer]!!.add(position)

        if (isWinner(players[currentPlayer]!!)) {
            result = GAMERESULT.USER_WINNER
            state = GAMESTATE.FINISHED
            winner = currentPlayer
        } else if (totalPlayeds == 9) {
            result = GAMERESULT.DRAW
            state = GAMESTATE.FINISHED
        }
    }

    fun togglePlayer() {
        currentPlayer = if (currentPlayer == PLAYER.X) {
            PLAYER.O
        } else {
            PLAYER.X
        }
    }

    fun getPlayedWinner(playerWinner: List<Int>): List<Int> {
        val playeds = listOf<Int>()

        methodsWinners.forEach {
            if (playerWinner.containsAll(it)) {
                playeds.plus(it)
            }
        }

        return playeds
    }

    fun isWinner(playerList: List<Int>): Boolean {
        methodsWinners.forEach {
            if (playerList.containsAll(it)) {
                return true
            }
        }

        return false
    }

    override var setOnWinnerPlayerListener: ((PLAYER) -> Unit)? = null
    override var setOnPlayListener: ((Int) -> Unit)? = null
    override var setOnFinishListener: (() -> Unit)? = null
    override var setOnDrawListener: (() -> Unit)? = null

}

package com.jedev.jogodavelha.models

class JogoDaVelha {

    var currentPlayer = PLAYER.X
    var winner: PLAYER? = null
    var state: GameState? = null

    val methodsWinners = listOf(
            listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9),
            listOf(1, 4, 7), listOf(2, 5, 8), listOf(3, 6, 9),
            listOf(1, 2, 3), listOf(3, 5, 7)

    )
    var players = hashMapOf<PLAYER, List<Int>>(
            PLAYER.X to listOf(),
            PLAYER.O to listOf()
    )

    init {
        restart()
    }

    fun getAllPlays(): Set<Int> {
        return players[PLAYER.X]!!.union(players[PLAYER.O]!!)
    }

    fun play(position: Int) {
        players[currentPlayer]!!.plus(position)

        if (hasVictory()) {
            winner = currentPlayer
        }

        togglePlayer()
    }

    fun restart() {
        winner = null
        state = GameState.IN_PROGRESS
        players[PLAYER.X] = listOf()
        players[PLAYER.O] = listOf()
    }

    fun hasVictory(): Boolean {
        return isWinner(players[currentPlayer]!!)
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
            if (playerList.containsAll(it)) return true
        }

        return false
    }

    enum class PLAYER {
        X, O
    }

    enum class GameState {
        IN_PROGRESS, FINISHED
    }
}

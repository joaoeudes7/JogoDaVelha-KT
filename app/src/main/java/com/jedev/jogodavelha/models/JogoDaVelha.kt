package com.jedev.jogodavelha.models

enum class PLAYER {
    X,
    O
}

class JogoDaVelha {

    var currentPlayer = PLAYER.X
    lateinit var winner: PLAYER

    private val methodsWinners = listOf(
            listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9),
            listOf(1, 4, 7), listOf(2, 5, 8), listOf(3, 6, 9),
            listOf(1, 2, 3), listOf(3, 5, 7)

    )
    private val players = hashMapOf<PLAYER, List<Int>>(
            PLAYER.X to listOf(),
            PLAYER.O to listOf()
    )

    fun play(position: Int) {
        players[currentPlayer]!!.plus(position)

        if (hasVictory()) {
            winner = currentPlayer
        }

        togglePlayer()
    }

    private fun hasVictory(): Boolean {
        return isWinner(players[currentPlayer]!!)
    }

    private fun togglePlayer() {
        currentPlayer = if (currentPlayer == PLAYER.X) {
            PLAYER.O
        } else {
            PLAYER.X
        }
    }

    private fun getPlayedWinner(playerWinner: List<Int>): List<Int> {
        val playeds = listOf<Int>()

        methodsWinners.forEach {
            if (playerWinner.containsAll(it)) {
                playeds.plus(it)
            }
        }

        return playeds
    }

    private fun isWinner(playerList: List<Int>): Boolean {
        methodsWinners.forEach {
            if (playerList.containsAll(it)) return true
        }

        return false
    }
}

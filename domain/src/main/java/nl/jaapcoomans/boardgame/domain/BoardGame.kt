package nl.jaapcoomans.boardgame.domain

import java.util.*

class BoardGame(val id: UUID, val title: String, val author: String, val publisher: String, val minPlayers: Int, val maxPlayers: Int,
                val gameMechanics: List<GameMechanic>, val boardGameGeekId: Int?) {
}

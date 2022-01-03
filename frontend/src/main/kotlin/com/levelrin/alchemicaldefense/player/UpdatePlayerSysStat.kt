/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/alchemical-defense/blob/master/LICENSE
 */

package com.levelrin.alchemicaldefense.player

import com.levelrin.alchemicaldefense.player.position.PlayerPosition
import kotlinx.browser.document
import org.w3c.dom.HTMLElement

/**
 * A decorator to update the system status of the player.
 */
class UpdatePlayerSysStat(private val origin: Player): Player {

    /**
     * We need to update the system status of the player when the player moves.
     * To avoid duplicated event registration, we use this flag.
     */
    private var eventAdded: Boolean = false

    override fun position(): PlayerPosition {
        return this.origin.position()
    }

    override fun render() {
        this.origin.render()
        if (!this.eventAdded) {
            this.origin.position().addEvent {_, _, x, y ->
                this.update(x, y)
            }
            this.eventAdded = true
        }
        val position: PlayerPosition = this.origin.position()
        this.update(position.x(), position.y())
    }

    /**
     * Update the system status of the player.
     */
    private fun update(x: Int, y: Int) {
        (checkNotNull(document.getElementById("player-position-x")) {
            "There is no label element with the id 'player-position-x'"
        } as HTMLElement).innerText = x.toString()
        (checkNotNull(document.getElementById("player-position-y")) {
            "There is no label element with the id 'player-position-y'"
        } as HTMLElement).innerText = y.toString()
    }

}

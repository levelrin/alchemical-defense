/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/alchemical-defense/blob/master/LICENSE
 */

package com.levelrin.alchemicaldefense.player

import com.levelrin.alchemicaldefense.player.position.PlayerPosition
import kotlinx.browser.document
import org.w3c.dom.events.KeyboardEvent

/**
 * A decorator to move the player by keyboard.
 */
class MovePlayerByKeyboard(private val origin: Player): Player {

    /**
     * To avoid duplicated key event registration, we use this flag.
     */
    private var eventAdded: Boolean = false

    override fun position(): PlayerPosition {
        return this.origin.position()
    }

    override fun render() {
        if (!this.eventAdded) {
            document.addEventListener("keydown", {
                val scale = SCALE
                it as KeyboardEvent
                val position: PlayerPosition = this.origin.position()
                when (it.key) {
                    "ArrowUp" -> position.moveTo(position.x(), position.y() - scale)
                    "ArrowDown" -> position.moveTo(position.x(), position.y() + scale)
                    "ArrowLeft" -> position.moveTo(position.x() - scale, position.y())
                    "ArrowRight" -> position.moveTo(position.x() + scale, position.y())
                }
            })
            this.eventAdded = true
        }
        this.origin.render()
    }

    companion object {

        /**
         * The amount of pixels to move.
         */
        private const val SCALE = 10

    }

}

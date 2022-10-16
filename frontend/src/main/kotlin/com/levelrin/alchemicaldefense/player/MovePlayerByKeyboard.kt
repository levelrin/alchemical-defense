/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/alchemical-defense/blob/master/LICENSE
 */

package com.levelrin.alchemicaldefense.player

import com.levelrin.alchemicaldefense.keyboard.Key
import com.levelrin.alchemicaldefense.keyboard.Keyboard
import com.levelrin.alchemicaldefense.player.position.PlayerPosition

/**
 * A decorator to move the player by keyboard.
 */
class MovePlayerByKeyboard(private val keyboard: Keyboard, private val origin: Player): Player {

    /**
     * To avoid duplicated key event registration, we use this flag.
     */
    private var eventAdded: Boolean = false

    override fun position(): PlayerPosition {
        return this.origin.position()
    }

    override fun render() {
        if (!this.eventAdded) {
            this.keyboard.addKeyPressedEvent(Key.W) {
                val position: PlayerPosition = this.origin.position()
                position.moveTo(position.x(), position.y() - SCALE)
            }
            this.keyboard.addKeyPressedEvent(Key.S) {
                val position: PlayerPosition = this.origin.position()
                position.moveTo(position.x(), position.y() + SCALE)
            }
            this.keyboard.addKeyPressedEvent(Key.A) {
                val position: PlayerPosition = this.origin.position()
                position.moveTo(position.x() - SCALE, position.y())
            }
            this.keyboard.addKeyPressedEvent(Key.D) {
                val position: PlayerPosition = this.origin.position()
                position.moveTo(position.x() + SCALE, position.y())
            }
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

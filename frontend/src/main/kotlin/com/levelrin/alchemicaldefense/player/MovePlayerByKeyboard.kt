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
class MovePlayerByKeyboard(private val player: Player, private val origin: Keyboard): Keyboard {

    override fun addKeyPressedEvent(key: Key, event: () -> Unit) {
        this.origin.addKeyPressedEvent(key, event)
    }

    override fun listen() {
        this.origin.addKeyPressedEvent(Key.W) {
            val position: PlayerPosition = this.player.position()
            position.moveTo(position.x(), position.y() - SCALE)
            this.player.render()
        }
        this.origin.addKeyPressedEvent(Key.S) {
            val position: PlayerPosition = this.player.position()
            position.moveTo(position.x(), position.y() + SCALE)
            this.player.render()
        }
        this.origin.addKeyPressedEvent(Key.A) {
            val position: PlayerPosition = this.player.position()
            position.moveTo(position.x() - SCALE, position.y())
            this.player.render()
        }
        this.origin.addKeyPressedEvent(Key.D) {
            val position: PlayerPosition = this.player.position()
            position.moveTo(position.x() + SCALE, position.y())
            this.player.render()
        }
        this.origin.listen()
    }

    companion object {

        /**
         * The amount of pixels to move.
         */
        private const val SCALE = 10

    }

}

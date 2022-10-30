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
import kotlinx.browser.window

/**
 * A decorator to move the player by keyboard.
 */
class MovePlayerByKeyboard(private val player: Player, private val origin: Keyboard): Keyboard {

    override fun addKeyPressedEvent(key: Key, event: () -> Unit) {
        this.origin.addKeyPressedEvent(key, event)
    }

    override fun addKeyReleasedEvent(key: Key, event: () -> Unit) {
        this.origin.addKeyReleasedEvent(key, event)
    }

    override fun listen() {
        val pressedKeys: MutableSet<Key> = mutableSetOf()
        this.origin.addKeyPressedEvent(Key.W) {
            pressedKeys.add(Key.W)
        }
        this.origin.addKeyReleasedEvent(Key.W) {
            pressedKeys.remove(Key.W)
        }
        this.origin.addKeyPressedEvent(Key.S) {
            pressedKeys.add(Key.S)
        }
        this.origin.addKeyReleasedEvent(Key.S) {
            pressedKeys.remove(Key.S)
        }
        this.origin.addKeyPressedEvent(Key.A) {
            pressedKeys.add(Key.A)
        }
        this.origin.addKeyReleasedEvent(Key.A) {
            pressedKeys.remove(Key.A)
        }
        this.origin.addKeyPressedEvent(Key.D) {
            pressedKeys.add(Key.D)
        }
        this.origin.addKeyReleasedEvent(Key.D) {
            pressedKeys.remove(Key.D)
        }
        window.setInterval(
            {
                var shouldMove = false
                val position: PlayerPosition = this.player.position()
                if (pressedKeys.contains(Key.W)) {
                    position.moveTo(position.x(), position.y() - SCALE)
                    shouldMove = true
                }
                if (pressedKeys.contains(Key.S)) {
                    position.moveTo(position.x(), position.y() + SCALE)
                    shouldMove = true
                }
                if (pressedKeys.contains(Key.A)) {
                    position.moveTo(position.x() - SCALE, position.y())
                    shouldMove = true
                }
                if (pressedKeys.contains(Key.D)) {
                    position.moveTo(position.x() + SCALE, position.y())
                    shouldMove = true
                }
                if (shouldMove) {
                    this.player.render()
                }
            },
            INTERVAL
        )
        this.origin.listen()
    }

    companion object {

        /**
         * The amount of pixels to move.
         */
        private const val SCALE = 5

        /**
         * How frequently it moves.
         * The unit is millisecond.
         */
        private const val INTERVAL = 10

    }

}

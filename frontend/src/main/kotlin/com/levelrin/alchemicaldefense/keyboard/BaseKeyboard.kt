/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/alchemical-defense/blob/master/LICENSE
 */

package com.levelrin.alchemicaldefense.keyboard

import kotlinx.browser.document
import org.w3c.dom.events.KeyboardEvent

/**
 * Base implementation of [Keyboard].
 */
class BaseKeyboard: Keyboard {

    /**
     * Map of key-pressed events.
     * The key-value pair is the same as [Keyboard.addKeyPressedEvent].
     */
    private val keyPressedEvent: MutableMap<String, () -> Unit> = mutableMapOf()

    override fun addKeyPressedEvent(key: String, event: () -> Unit) {
        this.keyPressedEvent[key] = event
    }

    override fun listen() {
        document.addEventListener("keydown", { keyEvent ->
            keyEvent as KeyboardEvent
            this.keyPressedEvent.forEach {
                if (keyEvent.key == it.key) {
                    it.value()
                }
            }
        })
    }

}

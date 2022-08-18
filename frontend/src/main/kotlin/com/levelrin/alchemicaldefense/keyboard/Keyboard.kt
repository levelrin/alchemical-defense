/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/alchemical-defense/blob/master/LICENSE
 */

package com.levelrin.alchemicaldefense.keyboard

import org.w3c.dom.events.KeyboardEvent

/**
 * It's responsible for handling keyboard events.
 */
interface Keyboard {

    /**
     * Add an event to be executed when the key is pressed.
     * @param key The value of [KeyboardEvent.key] for the event.
     * @param event It will be executed when the key is pressed.
     */
    fun addKeyPressedEvent(key: String, event: () -> Unit)

    /**
     * Start to listen to the keyboard input.
     */
    fun listen()

}

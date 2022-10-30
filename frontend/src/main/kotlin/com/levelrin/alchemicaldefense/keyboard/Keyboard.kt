/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/alchemical-defense/blob/master/LICENSE
 */

package com.levelrin.alchemicaldefense.keyboard

/**
 * It's responsible for handling keyboard events.
 */
interface Keyboard {

    /**
     * Add an event to be executed when the key is pressed.
     * @param key The key corresponding to the event.
     * @param event It will be executed when the key is pressed.
     */
    fun addKeyPressedEvent(key: Key, event: () -> Unit)

    /**
     * Add an event to be executed when the key is released.
     * @param key The key corresponding to the event.
     * @param event It will be executed when the key is released.
     */
    fun addKeyReleasedEvent(key: Key, event: () -> Unit)

    /**
     * Start to listen to the keyboard input.
     */
    fun listen()

}

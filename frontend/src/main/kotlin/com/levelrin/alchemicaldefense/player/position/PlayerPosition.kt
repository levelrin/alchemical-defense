/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/alchemical-defense/blob/master/LICENSE
 */

package com.levelrin.alchemicaldefense.player.position

/**
 * The position of the player.
 * Note, this is not the position of the HTML element.
 */
interface PlayerPosition {

    /**
     * Position X of the player.
     */
    @Suppress("FunctionMinLength")
    fun x(): Int

    /**
     * Position Y of the player.
     */
    @Suppress("FunctionMinLength")
    fun y(): Int

    /**
     * Move the player to the given position.
     * @param x X position.
     * @param y Y position.
     */
    fun moveTo(x: Int, y: Int)

    /**
     * Add a function to be called when the player moves.
     * @param event Function to be called.
     *              The first parameter is the old x position.
     *              The second parameter is the old y position.
     *              The third parameter is the new x position.
     *              The fourth parameter is the new y position.
     */
    fun addEvent(event: (Int, Int, Int, Int) -> Unit)

}

/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/alchemical-defense/blob/master/LICENSE
 */

package com.levelrin.alchemicaldefense.inventory

/**
 * It's inventory of the player.
 */
interface Inventory {

    /**
     * Renders the inventory on the screen.
     */
    fun render()

    /**
     * Check if the inventory is displayed or not.
     */
    fun isDisplayed(): Boolean

    /**
     * Hide the inventory from the screen.
     */
    fun hide()

}

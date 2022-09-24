/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/alchemical-defense/blob/master/LICENSE
 */

package com.levelrin.alchemicaldefense.inventory

import com.levelrin.alchemicaldefense.keyboard.Keyboard

/**
 * A decorator to open or close the inventory by keyboard.
 */
class InventoryByKeyboard(private val keyboard: Keyboard, private val origin: Inventory): Inventory {

    /**
     * To avoid duplicated key event registration, we use this flag.
     */
    private var eventAdded: Boolean = false

    override fun render() {
        if (!this.eventAdded) {
            this.keyboard.addKeyPressedEvent("e") {
                if (this.origin.isDisplayed()) {
                    this.origin.hide()
                } else {
                    this.origin.render()
                }
            }
            this.eventAdded = true
        }
    }

    override fun isDisplayed(): Boolean {
        return this.origin.isDisplayed()
    }

    override fun hide() {
        this.origin.hide()
    }

}

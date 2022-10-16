/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/alchemical-defense/blob/master/LICENSE
 */

package com.levelrin.alchemicaldefense.inventory

import com.levelrin.alchemicaldefense.keyboard.Key
import com.levelrin.alchemicaldefense.keyboard.Keyboard

/**
 * A decorator to open or close the inventory by keyboard.
 */
class InventoryByKeyboard(private val inventory: Inventory, private val origin: Keyboard): Keyboard {

    override fun addKeyPressedEvent(key: Key, event: () -> Unit) {
        this.origin.addKeyPressedEvent(key, event)
    }

    override fun listen() {
        this.origin.addKeyPressedEvent(Key.E) {
            if (this.inventory.isDisplayed()) {
                this.inventory.hide()
            } else {
                this.inventory.render()
            }
        }
        this.origin.listen()
    }

}

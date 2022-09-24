/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/alchemical-defense/blob/master/LICENSE
 */

package com.levelrin.alchemicaldefense

import com.levelrin.alchemicaldefense.blocks.BaseBlocks
import com.levelrin.alchemicaldefense.blocks.Blocks
import com.levelrin.alchemicaldefense.blocks.block.Grass
import com.levelrin.alchemicaldefense.inventory.BaseInventory
import com.levelrin.alchemicaldefense.inventory.Inventory
import com.levelrin.alchemicaldefense.inventory.InventoryByKeyboard
import com.levelrin.alchemicaldefense.keyboard.BaseKeyboard
import com.levelrin.alchemicaldefense.keyboard.Keyboard
import com.levelrin.alchemicaldefense.player.BasePlayer
import com.levelrin.alchemicaldefense.player.MovePlayerByKeyboard
import com.levelrin.alchemicaldefense.player.Player
import com.levelrin.alchemicaldefense.player.UpdatePlayerSysStat
import com.levelrin.alchemicaldefense.player.position.BasePlayerPosition
import kotlinx.browser.window

/**
 * Main function.
 */
fun main() {
    window.onload = {
        val keyboard: Keyboard = BaseKeyboard()
        val baseInventory: Inventory = BaseInventory()
        val keyboardInventory: Inventory = InventoryByKeyboard(
            keyboard,
            baseInventory
        )
        val player: Player = MovePlayerByKeyboard(
            keyboard,
            UpdatePlayerSysStat(
                BasePlayer(
                    BasePlayerPosition(INIT_X, INIT_Y)
                )
            )
        )
        val blocks: Blocks = BaseBlocks(
            player
        )
        blocks.add(Grass(0, 0))
        window.addEventListener("resize", {
            player.render()
            blocks.render()
            if (baseInventory.isDisplayed()) {
                baseInventory.hide()
                baseInventory.render()
            }
        })
        keyboardInventory.render()
        player.render()
        blocks.render()
        keyboard.listen()
    }
}

/**
 * Initial position of the player for testing.
 */
const val INIT_X = 100

/**
 * Initial position of the player for testing.
 */
const val INIT_Y = 100

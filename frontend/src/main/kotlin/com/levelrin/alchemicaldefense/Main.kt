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
        val player: Player = MovePlayerByKeyboard(
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
        })
        player.render()
        blocks.render()
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

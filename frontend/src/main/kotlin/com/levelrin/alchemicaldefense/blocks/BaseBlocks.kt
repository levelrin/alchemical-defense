/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/alchemical-defense/blob/master/LICENSE
 */

package com.levelrin.alchemicaldefense.blocks

import com.levelrin.alchemicaldefense.blocks.block.Block
import com.levelrin.alchemicaldefense.blocks.block.CacheBlockUi
import com.levelrin.alchemicaldefense.player.Player
import com.levelrin.alchemicaldefense.player.position.PlayerPosition
import kotlinx.browser.document
import org.w3c.dom.Element
import org.w3c.dom.HTMLElement

/**
 * A base implementation of [BaseBlocks].
 */
class BaseBlocks(private val player: Player): Blocks {

    /**
     * We will store blocks in this list.
     */
    private val blocks: MutableList<Block> = mutableListOf()

    /**
     * We need to render the blocks again when the player position is updated.
     * So we will register an event to render the blocks again.
     * To avoid the duplicated event registration, we will use this flag.
     */
    private var eventAdded: Boolean = false

    override fun add(block: Block) {
        blocks.add(CacheBlockUi(block))
    }

    override fun render() {
        if (!this.eventAdded) {
            this.player.position().addEvent {_, _, _, _ ->
                this.updatePositions()
            }
            this.eventAdded = true
        }
        updatePositions()
    }

    /**
     * Update the positions of all blocks on the screen.
     */
    private fun updatePositions() {
        val body: HTMLElement = checkNotNull(document.body) { "There is no body tag." }
        val playerDiv: Element = checkNotNull(document.getElementById("player")) {
            "There is no div element with the id 'player'"
        }
        val playerPosition: PlayerPosition = this.player.position()
        this.blocks.forEach {
            val diffX: Int = it.x() - playerPosition.x()
            val diffY: Int = it.y() - playerPosition.y()
            val blockDiv: HTMLElement = it.ui()
            blockDiv.style.top = (playerDiv.getBoundingClientRect().top + diffY).toString() + "px"
            blockDiv.style.left = (playerDiv.getBoundingClientRect().left + diffX).toString() + "px"
            if (!body.contains(blockDiv)) {
                body.append(blockDiv)
            }
        }
    }

}

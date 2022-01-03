/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/alchemical-defense/blob/master/LICENSE
 */

package com.levelrin.alchemicaldefense.player

import com.levelrin.alchemicaldefense.player.position.PlayerPosition
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.HTMLElement

/**
 * A base implementation of [Player].
 */
class BasePlayer(private val position: PlayerPosition): Player {

    override fun position(): PlayerPosition {
        return this.position
    }

    override fun render() {
        val player: HTMLElement = checkNotNull(
            document.getElementById("player")
        ) {"There is no div with id 'player'"} as HTMLElement
        player.style.top = ((window.innerHeight - player.clientHeight) / 2).toString() + "px"
        player.style.left = ((window.innerWidth - player.clientWidth) / 2).toString() + "px"
    }

}

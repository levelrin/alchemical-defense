/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/alchemical-defense/blob/master/LICENSE
 */

package com.levelrin.alchemicaldefense.player

import com.levelrin.alchemicaldefense.player.position.PlayerPosition

/**
 * The player.
 */
interface Player {

    /**
     * Return the position of the player.
     * Note, this position is not the position of the HTML element.
     */
    fun position(): PlayerPosition

    /**
     * Display the player on the screen.
     */
    fun render()

}

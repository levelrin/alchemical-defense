/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/alchemical-defense/blob/master/LICENSE
 */

package com.levelrin.alchemicaldefense.blocks

import com.levelrin.alchemicaldefense.blocks.block.Block

/**
 * Collection of [Block]s.
 */
interface Blocks {

    /**
     * Add a block.
     */
    fun add(block: Block)

    /**
     * Render blocks on the screen.
     */
    fun render()

}

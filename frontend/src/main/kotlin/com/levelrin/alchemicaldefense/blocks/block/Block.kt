/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/alchemical-defense/blob/master/LICENSE
 */

package com.levelrin.alchemicaldefense.blocks.block

import org.w3c.dom.HTMLElement

/**
 * A block.
 */
interface Block {

    /**
     * X position of the block.
     */
    @Suppress("FunctionMinLength")
    fun x(): Int

    /**
     * Y position of the block.
     */
    @Suppress("FunctionMinLength")
    fun y(): Int

    /**
     * The HTML element of the block.
     */
    @Suppress("FunctionMinLength")
    fun ui(): HTMLElement

}

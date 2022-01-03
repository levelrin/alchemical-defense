/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/alchemical-defense/blob/master/LICENSE
 */

package com.levelrin.alchemicaldefense.blocks.block

import org.w3c.dom.HTMLElement

/**
 * We should not create a new HTML element every time we need to render a block.
 * So we should cache the HTML element.
 */
class CacheBlockUi(private val origin: Block): Block {

    /**
     * We will store the HTML element in this variable.
     */
    private val cache: MutableList<HTMLElement> = mutableListOf()

    @Suppress("FunctionMinLength")
    override fun x(): Int {
        return origin.x()
    }

    @Suppress("FunctionMinLength")
    override fun y(): Int {
        return origin.y()
    }

    @Suppress("FunctionMinLength")
    override fun ui(): HTMLElement {
        if (this.cache.isEmpty()) {
            this.cache.add(origin.ui())
        }
        return this.cache.first()
    }

}

/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/alchemical-defense/blob/master/LICENSE
 */

package com.levelrin.alchemicaldefense.blocks.block

import kotlinx.browser.document
import org.w3c.dom.HTMLElement

/**
 * A grass block.
 */
class Grass(private var x: Int, private var y: Int): Block {

    @Suppress("FunctionMinLength")
    override fun x(): Int {
        return this.x
    }

    @Suppress("FunctionMinLength")
    override fun y(): Int {
        return this.y
    }

    @Suppress("FunctionMinLength")
    override fun ui(): HTMLElement {
        return (document.createElement("div") as HTMLElement)
            .apply {
                this.style.position = "absolute"
                this.style.width = "100px"
                this.style.height = "100px"
                this.style.backgroundColor = "green"
            }
    }

}

/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/alchemical-defense/blob/master/LICENSE
 */

package com.levelrin.alchemicaldefense.player.position

/**
 * A base implementation of [PlayerPosition].
 */
class BasePlayerPosition(private var x: Int, private var y: Int): PlayerPosition {

    /**
     * We will store the events in this list.
     * We will execute all the events in this list when the player position is updated.
     */
    private val events: MutableList<(Int, Int, Int, Int) -> Unit> = ArrayList()

    @Suppress("FunctionMinLength")
    override fun x(): Int {
        return this.x
    }

    @Suppress("FunctionMinLength")
    override fun y(): Int {
        return this.y
    }

    override fun moveTo(x: Int, y: Int) {
        val oldX = this.x
        val oldY = this.y
        this.x = x
        this.y = y
        this.events.forEach {
            it(oldX, oldY, x, y)
        }
    }

    override fun addEvent(event: (Int, Int, Int, Int) -> Unit) {
        this.events.add(event)
    }

}

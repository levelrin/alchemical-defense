/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/alchemical-defense/blob/master/LICENSE
 */

package com.levelrin.alchemicaldefense.keyboard

/**
 * Keyboard keys.
 */
enum class Key(private val string: String) {

    W("w"), A("a"), S("s"), D("d"),
    E("e");

    override fun toString(): String {
        return this.string;
    }

}

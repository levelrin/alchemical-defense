/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/alchemical-defense/blob/master/LICENSE
 */

package com.levelrin.alchemicaldefense.inventory

import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.dom.clear
import kotlinx.html.dom.append
import kotlinx.html.js.table
import kotlinx.html.js.td
import kotlinx.html.js.tr
import org.w3c.dom.HTMLElement

/**
 * Base implementation of [Inventory].
 */
@Suppress("MagicNumber")
class BaseInventory: Inventory {

    override fun render() {
        val inventory: HTMLElement = this.rootDiv()
        inventory.append {
            table {
                tr{
                    td {
                        + "Inventory"
                    }
                    td {
                        + "Craft"
                    }
                }
                tr {
                   td {
                       // player inventory
                       table {
                           for (y in 1..3) {
                                tr {
                                    for (x in 1 .. 3) {
                                        td {
                                            + "($x, $y)"
                                        }
                                    }
                                }
                           }
                           tr {
                               for (i in 1 .. 3) {
                                   td {
                                       + "Hotbar $i"
                                   }
                               }
                           }
                       }
                   }
                   td {
                       // craft
                       table {
                           for (y in 1..4) {
                               tr {
                                   for (x in 1 .. 3) {
                                       td {
                                           + "($x, $y)"
                                       }
                                   }
                               }
                           }
                       }
                   }
                }
            }
        }
        inventory.style.top = ((window.innerHeight - inventory.clientHeight) / 2).toString() + "px"
        inventory.style.left = ((window.innerWidth - inventory.clientWidth) / 2).toString() + "px"
        inventory.style.borderStyle = "solid"
    }

    override fun isDisplayed(): Boolean {
        val inventory: HTMLElement = this.rootDiv()
        return inventory.children.length > 0
    }

    override fun hide() {
        val inventory: HTMLElement = this.rootDiv()
        inventory.clear()
        inventory.style.borderStyle = "none"
    }

    /**
     * Returns the root div of inventory.
     */
    private fun rootDiv(): HTMLElement {
        return checkNotNull(
            document.getElementById("inventory")
        ) { "There is no div with id 'inventory'" } as HTMLElement
    }

}

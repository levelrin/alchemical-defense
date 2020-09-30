/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/AlchemicalDefence/blob/master/LICENSE
 */

package com.levelrin.alchemicaldefence;

import spark.Spark;

/**
 * Entrypoint of the software.
 * It has the main method.
 */
@SuppressWarnings({"HideUtilityClassConstructor", "PMD.UseUtilityClass"})
public final class Main {

    /**
     * Main method.
     * @param args Command line arguments.
     */
    public static void main(final String... args) {
        Spark.staticFileLocation("/public");
        Spark.get("/yoi", (request, response) -> "Yoi Yoi");
    }

}

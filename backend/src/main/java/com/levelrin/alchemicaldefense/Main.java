/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/alchemical-defense/blob/master/LICENSE
 */

package com.levelrin.alchemicaldefense;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Spark;

/**
 * Entrypoint of the software.
 * It has the main method.
 */
@SuppressWarnings({"HideUtilityClassConstructor", "PMD.UseUtilityClass"})
public final class Main {

    /**
     * For logging.
     */
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    /**
     * Main method.
     * @param args Command line arguments.
     */
    public static void main(final String... args) {
        Spark.staticFileLocation("/public");
        Spark.get("/yoi", (request, response) -> "Yoi Yoi");
        LOG.info("Server is ready!");
    }

}

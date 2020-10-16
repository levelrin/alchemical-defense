/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/AlchemicalDefense/blob/master/LICENSE
 */

package com.levelrin.alchemicaldefense;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

/**
 * Tests.
 */
final class YoiTest {

    @Test
    public void sampleTest() {
        MatcherAssert.assertThat(
            new Yoi().actual(),
            CoreMatchers.equalTo(false)
        );
    }

}

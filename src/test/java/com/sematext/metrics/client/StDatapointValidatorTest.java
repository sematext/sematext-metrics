/**
 * Copyright 2013 Sematext Group, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sematext.metrics.client;

import org.junit.Test;

import static com.sematext.metrics.client.StDatapointValidator.validate;
import static junit.framework.Assert.fail;

public class StDatapointValidatorTest {

  public static String repeat(String str, int count) {
    String repeated = "";
    for (int i = 0; i < count; i++) {
      repeated += str;
    }
    return repeated;
  }

  public static void assertValid(StDatapoint metric) {
    try {
      validate(metric);
    } catch (IllegalArgumentException e) {
      fail(metric + " should be valid.");
    }
  }

  public static void assertInvalid(StDatapoint metric) {
    try {
      validate(metric);
      fail(metric + " should be invalid.");
    } catch (IllegalArgumentException e) { }
  }

  @Test
  public void testValidate() {
    //using vars to avoid confusion with IllegalArgumentException from StDatapoint builder.
    StDatapoint metric = StDatapoint.name(repeat("c", 255))
        .filter1(repeat("b", 255))
        .filter2(repeat("c", 255))
        .value(1d).useSumAggregation().build();
    assertValid(metric);

     metric = StDatapoint.name(repeat("c", 255))
        .filter1(null)
        .filter2(null)
        .value(1d).useSumAggregation().build();
    assertValid(metric);

    metric = StDatapoint.name(repeat("c", 256))
        .value(1d).useSumAggregation().build();
    assertInvalid(metric);

    metric = StDatapoint.name("custom")
        .filter1(repeat("a", 256))
        .value(1d).useSumAggregation().build();
    assertInvalid(metric);

    metric = StDatapoint.name("custom")
        .filter2(repeat("a", 256))
        .value(1d).useSumAggregation().build();
    assertInvalid(metric);
  }
}

/**
 * Copyright 2013 Sematext International
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
package com.sematext.spm.client;

final class SpmDatapointValidator {
  private SpmDatapointValidator() { }

  private static final int MAX_STRING_LENGTH = 255;

  static void checkBounds(String fieldName, String value) {
    if (value != null && value.length() > MAX_STRING_LENGTH) {
      throw new IllegalArgumentException(fieldName + " value can't be longer than 255 characters.");
    }
  }

  static void validate(SpmDatapoint datapoint) {
    checkBounds("Metric name", datapoint.getName());
    checkBounds("Metric filter1", datapoint.getFilter1());
    checkBounds("Metric filter2", datapoint.getFilter2());
  }
}

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

import java.util.logging.Level;
import java.util.logging.Logger;

final class SpmLogger {
  private static final Logger LOG = Logger.getLogger("spm-lib-java");

  static {
    LOG.setLevel(Level.OFF);
  }

  static void setEnabled(boolean enabled) {
    LOG.setLevel(enabled ? Level.WARNING : Level.OFF);
  }

  static Logger getLogger() {
    return LOG;
  }
}

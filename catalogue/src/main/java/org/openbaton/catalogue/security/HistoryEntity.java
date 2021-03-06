/*
 * Copyright (c) 2016 Open Baton (http://www.openbaton.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.openbaton.catalogue.security;

import javax.persistence.Entity;
import org.openbaton.catalogue.util.BaseEntity;

/** Created by lto on 17/10/16. */
@Entity
public class HistoryEntity extends BaseEntity {
  private String username;
  private String method;
  private String path;
  private String result;
  private long timestamp;

  @Override
  public String toString() {
    return "HistoryEntity{"
        + "username='"
        + username
        + '\''
        + ", method='"
        + method
        + '\''
        + ", path='"
        + path
        + '\''
        + ", result='"
        + result
        + '\''
        + ", timestamp="
        + timestamp
        + "} "
        + super.toString();
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public String getMethod() {
    return method;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getPath() {
    return path;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public String getResult() {
    return result;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }

  public long getTimestamp() {
    return timestamp;
  }
}

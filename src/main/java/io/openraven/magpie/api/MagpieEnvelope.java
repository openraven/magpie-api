/*
 * Copyright 2021 Open Raven Inc
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

package io.openraven.magpie.api;

import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;
import java.util.List;

public class MagpieEnvelope {

  public static MagpieEnvelope of(MagpieEnvelope current, String pluginId, ObjectNode contents) {
    List<String> newPath = new ArrayList<>(current.pluginPath);
    newPath.add(pluginId);
    return new MagpieEnvelope(current.getSession(), newPath, contents);
  }

  private Session session;
  private List<String> pluginPath;
  private ObjectNode contents;
  private String contentClass;


  public MagpieEnvelope() {
  }

  public MagpieEnvelope(Session session, List<String> pluginPath, ObjectNode contents) {
    this.session = session;
    this.pluginPath = pluginPath;
    this.contents = contents;
    this.contentClass = contents.getClass().getName();
  }

  public Session getSession() {
    return session;
  }

  public void setSession(Session session) {
    this.session = session;
  }

  public List<String> getPluginPath() {
    return pluginPath;
  }

  public void setPluginPath(List<String> pluginPath) {
    this.pluginPath = pluginPath;
  }

  public ObjectNode getContents() {
    return contents;
  }

  public void setContents(ObjectNode contents) {
    this.contents = contents;
  }

  public String getContentClass() {
    return contentClass;
  }

  public void setContentClass(String contentClass) {
    this.contentClass = contentClass;
  }
}

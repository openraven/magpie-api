package io.openraven.nightglow.api;

import java.util.ArrayList;
import java.util.List;

public class NGEnvelope {

  public static NGEnvelope of(NGEnvelope current, String pluginId, Object contents) {
    List<String> newPath = new ArrayList<>(current.pluginPath);
    newPath.add(pluginId);
    return new NGEnvelope(current.getSession(), newPath, contents);
  }

  private final Session session;
  private final List<String> pluginPath;
  private final Object contents;
  private final String contentClass;

  public NGEnvelope(Session session, List<String> pluginPath, Object contents) {
    this.session = session;
    this.pluginPath = pluginPath;
    this.contents = contents;
    this.contentClass = contents.getClass().getName();
  }

  public List<String> getPluginPath() {
    return pluginPath;
  }

  public Object getContents() {
    return contents;
  }

  public String getContentClass() {
    return contentClass;
  }

  public Session getSession() {
    return session;
  }
}

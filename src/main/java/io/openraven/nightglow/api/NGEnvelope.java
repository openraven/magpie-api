package io.openraven.nightglow.api;

import java.util.ArrayList;
import java.util.List;

public class NGEnvelope {

  public static NGEnvelope of(NGEnvelope current, String pluginId, Object obj) {
    List<String> newPath = new ArrayList<>(current.pluginPath);
    newPath.add(pluginId);
    return new NGEnvelope(current.getSession(), newPath, obj);
  }

  private final Session session;
  private final List<String> pluginPath;
  private final Object contents;
  private final String className;

  public NGEnvelope(Session session, List<String> pluginPath, Object contents) {
    this.session = session;
    this.pluginPath = pluginPath;
    this.contents = contents;
    this.className = contents.getClass().getName();
  }

  public List<String> getPluginPath() {
    return pluginPath;
  }

  public Object getContents() {
    return contents;
  }

  public String getClassName() {
    return className;
  }

  public Session getSession() {
    return session;
  }
}

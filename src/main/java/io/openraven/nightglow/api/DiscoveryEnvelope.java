package io.openraven.nightglow.api;

import java.util.ArrayList;
import java.util.List;

public class DiscoveryEnvelope {

  public static DiscoveryEnvelope of(DiscoveryEnvelope current, String pluginId, Object obj) {
    List<String> newPath = new ArrayList<>(current.pluginPath);
    newPath.add(pluginId);
    return new DiscoveryEnvelope(current.getSession(), newPath, obj);
  }

  private final Session session;
  private final List<String> pluginPath;
  private final Object obj;
  private final String className;

  public DiscoveryEnvelope(Session session, List<String> pluginPath, Object obj) {
    this.session = session;
    this.pluginPath = pluginPath;
    this.obj = obj;
    this.className = obj.getClass().getName();
  }

  public List<String> getPluginPath() {
    return pluginPath;
  }

  public Object getObj() {
    return obj;
  }

  public String getClassName() {
    return className;
  }

  public Session getSession() {
    return session;
  }
}

package io.openraven.nightglow.api;

import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;
import java.util.List;

public class NGEnvelope {

  public static NGEnvelope of(NGEnvelope current, String pluginId, ObjectNode contents) {
    List<String> newPath = new ArrayList<>(current.pluginPath);
    newPath.add(pluginId);
    return new NGEnvelope(current.getSession(), newPath, contents);
  }

  private Session session;
  private List<String> pluginPath;
  private ObjectNode contents;
  private String contentClass;


  public NGEnvelope() {
  }

  public NGEnvelope(Session session, List<String> pluginPath, ObjectNode contents) {
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

package io.openraven.nightglow.api;

public interface EnumerationPlugin<T> extends NightglowPlugin<T>{
  void discover(Session session, Emitter emitter);
}

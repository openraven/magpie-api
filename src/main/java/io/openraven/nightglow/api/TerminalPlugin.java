package io.openraven.nightglow.api;

public interface TerminalPlugin<T> extends NightglowPlugin<T>{
  void accept(NGEnvelope env);
}

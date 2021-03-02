package io.openraven.nightglow.api;

public interface IntermediatePlugin<T> extends NightglowPlugin<T> {
  void accept(NGEnvelope env, Emitter emitter);
}

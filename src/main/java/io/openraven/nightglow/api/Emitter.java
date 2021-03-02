package io.openraven.nightglow.api;

@FunctionalInterface
public interface Emitter {
  void emit(NGEnvelope env);
}

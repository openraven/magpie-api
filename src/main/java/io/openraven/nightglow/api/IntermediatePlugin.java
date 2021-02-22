package io.openraven.nightglow.api;

import java.util.Set;
import java.util.regex.Pattern;

public interface IntermediatePlugin<T> extends NightglowPlugin<T> {
  void accept(DiscoveryEnvelope env, Emitter emitter);
}

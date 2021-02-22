package io.openraven.nightglow.api;

import java.util.Set;
import java.util.regex.Pattern;

public interface TerminalPlugin<T> extends NightglowPlugin<T>{
  void accept(DiscoveryEnvelope env);
}

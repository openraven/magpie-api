package io.openraven.nightglow.api;

import org.slf4j.Logger;

public interface NightglowPlugin<T> {
  String id();
  void init(T config, Logger logger);
  Class<T> configType();
}

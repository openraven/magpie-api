package io.openraven.nightglow.api;

import java.util.UUID;

public class Session {
  private final String id = UUID.randomUUID().toString();
  private final long createdAt = System.currentTimeMillis();

  public String getId() {
    return id;
  }

  public long getCreatedAt() {
    return createdAt;
  }
}

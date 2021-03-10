package io.openraven.nightglow.api;

import java.time.Instant;
import java.util.UUID;

public class Session {
  private  String id = UUID.randomUUID().toString();
  private  Instant createdAt = Instant.now();

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }


  @Override
  public String toString() {
    return "Session{" +
        "id='" + id + '\'' +
        ", createdAt=" + createdAt +
        '}';
  }
}

package io.openraven.nightglow.api;

public class EmitFailedException extends Exception {

  public EmitFailedException(String message) {
    super(message);
  }

  public EmitFailedException(String message, Throwable cause) {
    super(message, cause);
  }

  public EmitFailedException(Throwable cause) {
    super(cause);
  }

  public EmitFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public EmitFailedException() {
  }
}

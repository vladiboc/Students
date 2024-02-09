package org.example.students.exception;

public class IllegalFieldsException extends Exception {
  public IllegalFieldsException() {
  }

  public IllegalFieldsException(String message) {
    super(message);
  }

  public IllegalFieldsException(String message, Throwable cause) {
    super(message, cause);
  }

  public IllegalFieldsException(Throwable cause) {
    super(cause);
  }

  public IllegalFieldsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}

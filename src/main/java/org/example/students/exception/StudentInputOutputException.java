package org.example.students.exception;

public class StudentInputOutputException extends StudentsAppException {
  public StudentInputOutputException() {
  }

  public StudentInputOutputException(String message) {
    super(message);
  }

  public StudentInputOutputException(String message, Throwable cause) {
    super(message, cause);
  }

  public StudentInputOutputException(Throwable cause) {
    super(cause);
  }

  public StudentInputOutputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}

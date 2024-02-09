package org.example.students.exception;

public class StudentsAppException extends Exception {
  public StudentsAppException() {
  }

  public StudentsAppException(String message) {
    super(message);
  }

  public StudentsAppException(String message, Throwable cause) {
    super(message, cause);
  }

  public StudentsAppException(Throwable cause) {
    super(cause);
  }

  public StudentsAppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

}
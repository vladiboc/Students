package org.example.students.util;

import org.example.students.exception.IllegalFieldsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckersTest {

  @Test
  void shouldThrowException() {
    assertThrowsExactly(IllegalFieldsException.class,
        () -> Checkers.checkInputFields("иван", "Иванов", 22));
    assertThrowsExactly(IllegalFieldsException.class,
        () -> Checkers.checkInputFields("ИВан", "Иванов", 22));
    assertThrowsExactly(IllegalFieldsException.class,
        () -> Checkers.checkInputFields("Иван", "Иvанов", 22));
    assertThrowsExactly(IllegalFieldsException.class,
        () -> Checkers.checkInputFields("Иван", "Иванов", 1022));
    assertThrowsExactly(IllegalFieldsException.class,
        () -> Checkers.checkInputFields("Иван", "Иванов", 10));
  }

}
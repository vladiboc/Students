package org.example.students.util;

import org.example.students.exception.IllegalFieldsException;

public class Checkers {
  private static final String NAME_REGEX = "^[А-ЯЁ][а-яё]+((-[А-ЯЁ])?[а-яё]+)?$";
  private static final int MIN_AGE = 11;
  private static final int MAX_AGE = 99;

  public static void checkInputFields(String firstName, String lastName, int age) throws IllegalFieldsException {
    if (!firstName.matches(NAME_REGEX)) {
      throw new IllegalFieldsException(ErrorMsg.ILLEGAL_NAME);
    }
    if (!lastName.matches(NAME_REGEX)) {
      throw new IllegalFieldsException(ErrorMsg.ILLEGAL_SURNAME);
    }
    if (age < MIN_AGE || age > MAX_AGE) {
      throw new IllegalFieldsException(ErrorMsg.ILLEGAL_AGE);
    }
  }

  private Checkers() {}

  public static String[] checkInputString(String studentString, String fieldSeparator) throws IllegalFieldsException {
    final String[] inputFields = studentString.split(fieldSeparator);
    if (inputFields.length != 3) {
      throw new IllegalFieldsException(ErrorMsg.THREE_FIELDS_NEEDED);
    }
    return inputFields;
  }
}
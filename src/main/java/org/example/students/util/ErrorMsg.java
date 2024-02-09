package org.example.students.util;

public class ErrorMsg {
  public static final String ILLEGAL_NAME = "Имя " + ErrorMsg.RULE;
  public static final String ILLEGAL_SURNAME = "Фамилия " + ErrorMsg.RULE;
  private static final String RULE = "только русскими буквами без пробелов и первая заглавная!";
  public static final String ILLEGAL_AGE = "Принимаем студентов не моложе 11 и не старше 99 лет!";
  public static final String NO_SUCH_STUDENT = "Не существует студента с номером: %d!";
  public static final String THREE_FIELDS_NEEDED = "В строке контакта должно быть ровно 3 подстроки, разделённых ','!";
  public static final String FILE_TOO_BIG = "Ошибка загрузки файла: Файл слишком большой!";
  public static final String LOAD_FILE_ERROR = "Ошибка загрузки файла: ";
  public static final String LINE_NUMBER = "Строка номер: ";

  private ErrorMsg() {}

}
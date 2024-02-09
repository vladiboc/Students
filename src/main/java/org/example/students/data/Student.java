package org.example.students.data;

public record Student(int id, String firstName, String lastName, int age) {

  @Override
  public String toString() {
    return "Номер: " + this.id + " Имя: " + this.firstName + " Фамилия: " + this.lastName + " Возраст: " + this.age;
  }

}
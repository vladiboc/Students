package org.example.students.bean;

import lombok.Setter;
import org.example.students.data.Student;
import org.example.students.exception.IllegalFieldsException;
import org.example.students.util.Checkers;
import org.example.students.util.InfoMsg;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.TreeMap;

@Component
@Setter
public class StudentsManager {
  private Map<Integer, Student> studentsRegistry = new TreeMap<>();
  private int lastId = 0;

  public String listStudents() {
    if (this.studentsRegistry.isEmpty()) {
      return InfoMsg.LIST_IS_EMPTY;
    }
    StringBuilder listBuilder = new StringBuilder();
    listBuilder.append(String.format("%5s  %-10s  %-16s  %7s", "Номер", "Имя", "Фамилия", "Возраст"))
        .append(System.lineSeparator()).append("-".repeat(44)).append(System.lineSeparator());
    for (Map.Entry<Integer, Student> entry : this.studentsRegistry.entrySet()) {
      listBuilder.append(String.format("%5d", entry.getKey()))
          .append(String.format("  %-10s", entry.getValue().firstName()))
          .append(String.format("  %-16s", entry.getValue().lastName()))
          .append(String.format("  %7d", entry.getValue().age()))
          .append(System.lineSeparator());
    }
    return listBuilder.toString();
  }

  public Student addStudent(String firstName, String lastName, int age) throws IllegalFieldsException {
    Checkers.checkInputFields(firstName, lastName, age);
    final Student student = new Student(lastId, firstName, lastName, age);
    this.studentsRegistry.put(this.lastId, student);
    this.lastId++;
    return student;
  }

  public boolean removeStudent(int id) {
    return this.studentsRegistry.remove(id, this.studentsRegistry.get(id));
  }

  public void clearAllStudents() {
    this.studentsRegistry.clear();
    this.lastId = 0;
  }

}
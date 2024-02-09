package org.example.students.bean;

import lombok.RequiredArgsConstructor;
import org.example.students.data.MessageEvent;
import org.example.students.data.Student;
import org.example.students.exception.IllegalFieldsException;
import org.example.students.util.ErrorMsg;
import org.example.students.util.InfoMsg;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
@RequiredArgsConstructor
public class StudentsRegistryShell {
  private final ApplicationEventPublisher publisher;
  private final StudentsManager studentsManager;

  @ShellMethod(key = {"список", "сп"})
  public void listStudents() {
    final String list = this.studentsManager.listStudents();
    this.publisher.publishEvent(new MessageEvent(this, list));
  }

  @ShellMethod(key = {"добавить", "доб"})
  public void addStudent(@ShellOption("и") String firstName,
                         @ShellOption("ф") String lastName,
                         @ShellOption("в") int age) {
    Student student;
    try {
      student = this.studentsManager.addStudent(firstName, lastName, age);
    } catch (IllegalFieldsException e) {
      this.publisher.publishEvent(new MessageEvent(this, e.getMessage()));
      return;
    }
    final String message = InfoMsg.ADDED_STUDENT + student;
    this.publisher.publishEvent(new MessageEvent(this, message));
  }

  @ShellMethod(key = {"удалить", "уд"})
  public void removeStudent(@ShellOption("№") int id) {
    if (this.studentsManager.removeStudent(id)) {
      this.publisher.publishEvent(new MessageEvent(this, String.format(InfoMsg.REMOVED_STUDENT, id)));
    } else {
      this.publisher.publishEvent(new MessageEvent(this, String.format(ErrorMsg.NO_SUCH_STUDENT, id)));
    }
  }

  @ShellMethod(key = {"очистить", "оч"})
  public void clearAllStudents() {
    this.studentsManager.clearAllStudents();
    this.publisher.publishEvent(new MessageEvent(this, InfoMsg.ALL_STUDENTS_REMOVED));
  }

}
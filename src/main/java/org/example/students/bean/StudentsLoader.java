package org.example.students.bean;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.students.data.MessageEvent;
import org.example.students.exception.IllegalFieldsException;
import org.example.students.exception.StudentInputOutputException;
import org.example.students.util.Checkers;
import org.example.students.util.ErrorMsg;
import org.example.students.util.InfoMsg;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Component
@ConditionalOnProperty("app.load-students.enabled")
@ConfigurationProperties(prefix = "load")
@Setter
@RequiredArgsConstructor
public class StudentsLoader {
  public static final String FIELD_SEPARATOR = ",";
  private final StudentsManager studentsManager;
  private final ApplicationEventPublisher publisher;
  private String fileName;
  private int fileMaxSize;

  @EventListener(ApplicationStartedEvent.class)
  public void initLoad() {
    int lineNumber = 0;
    try {
      if (this.fileMaxSize < Files.size(Path.of(this.fileName))) {
        throw new StudentInputOutputException(ErrorMsg.FILE_TOO_BIG);
      }
      final List<String> studentsList = Files.readAllLines(Path.of(this.fileName));
      for (; lineNumber < studentsList.size(); lineNumber++) {
        this.addStudentFromString(studentsList.get(lineNumber));
      }
      this.publisher.publishEvent(new MessageEvent(this, InfoMsg.CONTACTS_LOADED + this.fileName));
    } catch (IOException | StudentInputOutputException e) {
      final String messageString = ErrorMsg.LOAD_FILE_ERROR + e.getMessage();
      this.publisher.publishEvent(new MessageEvent(this, messageString));
    } catch (IllegalFieldsException e) {
      final String messageString = ErrorMsg.LOAD_FILE_ERROR + ErrorMsg.LINE_NUMBER + lineNumber + " " + e.getMessage();
      this.publisher.publishEvent(new MessageEvent(this, messageString));
    }
  }
  private void addStudentFromString(String studentString) throws IllegalFieldsException {
    final String[] inputFields = Checkers.checkInputString(studentString, StudentsLoader.FIELD_SEPARATOR);

    final String firstName = inputFields[0];
    final String lastName = inputFields[1];
    final int age = Integer.parseInt(inputFields[2]);

    Checkers.checkInputFields(firstName, lastName, age);

    this.studentsManager.addStudent(firstName, lastName, age);
  }

}
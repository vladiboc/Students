package org.example.students.data;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class MessageEvent extends ApplicationEvent {
  private final Object source;
  private final String message;

  public MessageEvent(Object source, String message) {
    super(source);
    this.source = source;
    this.message = message;
  }

}
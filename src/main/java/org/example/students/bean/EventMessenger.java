package org.example.students.bean;

import org.example.students.data.MessageEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventMessenger {

  @EventListener(MessageEvent.class)
  public void message(MessageEvent event) {
    System.out.println(event.getMessage());
  }

}
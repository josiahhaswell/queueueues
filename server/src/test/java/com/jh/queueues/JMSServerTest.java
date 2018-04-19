package com.jh.queueues;

import com.jh.queueueues.api.ThingOne;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.jms.JMSException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = JMSServerConfiguration.class)
public class JMSServerTest {

  @Autowired private JmsTemplate template;


  @Test
  void send() throws JMSException, InterruptedException {
    for (; ; ) {
      template.convertAndSend("frapper", new ThingOne());
      Thread.sleep(50);
    }
  }
}

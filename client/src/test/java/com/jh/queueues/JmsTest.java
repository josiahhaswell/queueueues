package com.jh.queueues;

import com.jh.qs.client.JMSClientConfiguration;
import com.jh.queueueues.api.ThingOne;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.jms.Message;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = JMSClientConfiguration.class)
public class JmsTest {

  @Autowired private JmsTemplate jmsTemplate;

  @Test
  void ensureClientCanConnect() {
    for (; ; ) {
      ThingOne frapper = (ThingOne) jmsTemplate.receiveAndConvert("frapper");
      System.out.println(frapper);
    }
  }
}

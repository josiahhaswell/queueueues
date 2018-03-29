package com.jh.queueues;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.jh.qs.client.MessageReceiver;
import com.jh.qs.client.SqsConfiguration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static java.lang.Thread.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SqsConfiguration.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SqsTest {

    @Autowired
    private AmazonSQSAsync client;


    @Autowired
    private MessageReceiver receiver;




    @BeforeAll
    public void beforeAll() {
    }


    @Test
    public void ensureMessagesAreReceived() throws InterruptedException {
        int i = 0;
//        QueueMessagingTemplate queueMessagingTemplate = new QueueMessagingTemplate(client);
        while(true) {

//            try {
//                ReceiveMessageResult thing1 = client.receiveMessage("frapper");
//                System.out.println(thing1);
//            } catch(Exception ex) {
//                System.out.println("Warning: " + ex.getMessage());
//            }

            sleep(1000);
            if(i++ % 100 == 0) {
                System.out.println("tick");
            }

        }
    }
}

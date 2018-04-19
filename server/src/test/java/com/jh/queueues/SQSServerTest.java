package com.jh.queueues;

import com.jh.queueueues.api.ThingOne;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SQSServerConfiguration.class)
public class SQSServerTest {


    @Autowired
    private MessageSender sender;


    @Test
    void sendMessages() {
        for(int i = 0; i < 10; i++) {
            sender.send("frapper", new ThingOne());
        }
    }


}

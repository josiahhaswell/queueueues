package com.jh.qs.client;

import com.jh.queueueues.api.ThingOne;
import com.jh.queueueues.api.ThingTwo;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    @MessageMapping("frapper")
    @SqsListener(value = "frapper", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void receiveThing1(ThingOne one, @Header("SenderId") String senderId) {
        System.out.println("Got a thing one" + one);
    }

    @SqsListener("thing2")
    public void receiveThing2(ThingTwo one, @Header("SenderId") String senderId) {
        System.out.println("Got a thing 2");
    }
}

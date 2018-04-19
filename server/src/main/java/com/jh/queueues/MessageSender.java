package com.jh.queueues;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessageChannel;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;

public class MessageSender {

    final QueueMessageChannel thing1;
    final QueueMessageChannel thing2;
    final QueueMessagingTemplate template;
    private final String url;

    @Autowired
    public MessageSender(AmazonSQSAsync client) {
        this.template = new QueueMessagingTemplate(client);
        this.url = client.createQueue("frapper").getQueueUrl();
        thing1 = new QueueMessageChannel(client, client.createQueue("frapper").getQueueUrl());
        thing2 = new QueueMessageChannel(client, client.createQueue("dapper").getQueueUrl());
    }

    public <T> void send(String dest, T one) {
        template.convertAndSend(dest, one);
    }


}

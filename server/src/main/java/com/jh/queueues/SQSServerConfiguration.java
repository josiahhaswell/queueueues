package com.jh.queueues;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

@Configuration
public class SQSServerConfiguration {

    @Bean
    public MessageSender sender(AmazonSQSAsync amazonSQSAsync) {
        return new MessageSender(amazonSQSAsync);
    }

    @Bean
    public MappingJackson2MessageConverter converter() {
        final MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setObjectMapper(new ObjectMapper());
        return converter;
    }
    @Bean
    public AmazonSQSAsync amazonSQSAsync() {
        return AmazonSQSAsyncClient.asyncBuilder()
                .withCredentials(
                        new AWSStaticCredentialsProvider(
                                new BasicAWSCredentials(
                                        "AKIAIDDMH7JB5YCYRUBQ",
                                        "yYS7NKoa8nBRDzoTjDzKimn0bOf6vAA4mUhymeg1"
                                ))).withRegion(Regions.DEFAULT_REGION)
                .build();
    }
}

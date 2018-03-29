package com.jh.qs.client;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClient;
import org.springframework.cloud.aws.core.env.ResourceIdResolver;
import org.springframework.cloud.aws.core.region.RegionProvider;
import org.springframework.cloud.aws.messaging.config.annotation.EnableSqs;
import org.springframework.context.annotation.*;

@EnableSqs
@Configuration
public class SqsConfiguration {


    @Bean
    public MessageReceiver messageReceiver() {
        return new MessageReceiver();
    }

    @Bean
    public AWSCredentialsProvider awsCredentialsProvider() {
        return new AWSStaticCredentialsProvider(new BasicAWSCredentials(
                "AKIAIDDMH7JB5YCYRUBQ",
                "yYS7NKoa8nBRDzoTjDzKimn0bOf6vAA4mUhymeg1"
        ));
    }

    @Bean
    public RegionProvider regionProvider() {
        return () -> Region.getRegion(Regions.DEFAULT_REGION);
    }

    @Bean
    public ResourceIdResolver resourceIdResolver(AmazonSQSAsync async) {
        return logicalResourceId -> async.createQueue(logicalResourceId).getQueueUrl();
    }


    @Bean
    @Primary
    public AmazonSQSAsync amazonSQS() {
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

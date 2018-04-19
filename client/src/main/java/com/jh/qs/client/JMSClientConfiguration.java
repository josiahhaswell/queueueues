package com.jh.qs.client;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.jms.pool.PooledConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;

@EnableJms
public class JMSClientConfiguration {


  @Bean
  public ConnectionFactory activeMQConnectionFactory() {
    String url =
        "ssl://b-3fc65671-d743-47a1-8940-bd7eef456c93-1" + ".mq.us-west-2.amazonaws.com:61617";
    final ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(url);
    factory.setUserName("billgo");
    factory.setPassword("this-is-a-test");

    final PooledConnectionFactory pooledConnectionFactoryProducer = new PooledConnectionFactory();
    pooledConnectionFactoryProducer.setConnectionFactory(factory);
    pooledConnectionFactoryProducer.setMaxConnections(10);
    return factory;
  }

  @Bean
  public JmsListenerContainerFactory<?> jmsListenerContainerFactory(
      ConnectionFactory connectionFactory) {
    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
    return factory;
  }

  @Bean // Serialize message content to json using TextMessage
  public MessageConverter jacksonJmsMessageConverter() {
    MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
    converter.setTargetType(MessageType.TEXT);
    converter.setTypeIdPropertyName("_type");
    return converter;
  }

  @Bean
  public JmsTemplate jmsTemplate(ConnectionFactory factory, MessageConverter converter) {
    final JmsTemplate template = new JmsTemplate(factory);
    template.setMessageConverter(converter);
    return template;
  }
}

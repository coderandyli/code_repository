package com.coderandyli.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Rabbit Configuration
 *
 * @author Hanping QIAO
 * 2018-09-06 下午3:41
 **/
@Configuration
public class RabbitConfig {

    /**
     * MAIL TO SEND QUEUE
     */
    public static final String MAIL_TO_SEND_QUEUE = "mail_to_send";

    /**
     * EXCHANGE NAME
     */
    public static final String EXCHANGE = "message";

    /**
     * TOPIC ROUTING KEY FOR MAIL TO SEND QUEUE
     */
    public static final String MAIL_TO_SEND_ROUTING_KEY = "Mail.TO.SEND";


    @Bean
    @Qualifier("mailToSendQueue")
    public Queue mailToSendQueue() {
        return new Queue(MAIL_TO_SEND_QUEUE,true);
    }

    /**
     * Topic模式
     *
     * @return
     */
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding bindingMailToSend(@Qualifier("mailToSendQueue") Queue queue, TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with(MAIL_TO_SEND_ROUTING_KEY);
    }

}

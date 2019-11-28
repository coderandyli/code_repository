package com.coderandyli.demo.controller;

import com.coderandyli.demo.config.RabbitConfig;
import com.coderandyli.demo.form.SendMqForm;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lizhen on 2019-11-27
 */
@RestController
@RequestMapping("/rabbit")
public class RabbitMqController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/send")
    public void send(@RequestBody SendMqForm form){
        rabbitTemplate.convertAndSend(RabbitConfig.MAIL_TO_SEND_QUEUE, form.getMessage());
    }
}

package com.coderandyli.demo.receiver;

import com.coderandyli.demo.config.RabbitConfig;
import com.coderandyli.demo.utils.JsonUtil;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by lizhen on 2019-03-03
 */
@Slf4j
@Component
public class MQReceiver {

    /**
     * listen station_letter_to_send, consume message
     *
     * @param msg
     * @param message
     * @param channel
     */
    @RabbitListener(queues = RabbitConfig.MAIL_TO_SEND_QUEUE)
    public void receiveMail(String msg, Message message, Channel channel) {
        String msgContent = msg;
        log.info("listen station_letter_to_send queue, time: [{}], message: [{}]", LocalDateTime.now(), msgContent);
        if (msgContent.equals("return")){
            return;
        }

        try {
            if (msgContent.equals("ack")) {
                // 消息处理完成，手动确认提交
                // deliveryTag 该消息的index
                // multiple：是否批量 true:将一次性ack所有小于deliveryTag的消息。
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
                log.info("ack message, time: 【{}】; message：【{}】", LocalDateTime.now(), message);
            } else if (msgContent.equals("nack")) {
                log.error("nack message, time: 【{}】; message：【{}】", LocalDateTime.now(), message);
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
            } else {
                // 异常
                int i = 1/0;
            }
        } catch (Exception e) {
            if (e instanceof IOException) {
                log.error("failed to ack or nack message message for message : [{}], error : {}", message);
                try {
                    channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
                } catch (Exception e1) {
                    log.error("failed to reject message message from station_letter_to_send queue : [{}], error: [{}]", message, e1.getMessage());
                }
            } else {
                log.error("insert to database failed, message:{}, error:{}, reject message.", message);
                try {
                    channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
                } catch (IOException e2) {
                    log.error("failed to reject message from station_letter_to_send queue : message : [{}], error: [{}]", message, e2.getMessage());
                }
            }
        }
    }
}

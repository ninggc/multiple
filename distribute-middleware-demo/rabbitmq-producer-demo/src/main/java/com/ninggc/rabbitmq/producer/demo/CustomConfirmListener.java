// package com.ninggc.demo.rabbitmq.producer;
//
// import com.rabbitmq.client.ConfirmListener;
// import java.io.IOException;
// import lombok.extern.slf4j.Slf4j;
// import org.springframework.stereotype.Component;
//
// @Slf4j
// @Component
// public class CustomConfirmListener implements ConfirmListener {
//
//     @Override
//     public void handleAck(long deliveryTag, boolean multiple) throws IOException {
//         log.info("tag: {}, multiple: {}", deliveryTag, multiple);
//     }
//
//     @Override
//     public void handleNack(long deliveryTag, boolean multiple) throws IOException {
//         log.info("tag: {}, multiple: {}", deliveryTag, multiple);
//     }
// }

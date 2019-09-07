package tut1;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

public class Tut1Sender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        String msg = "Hello world!! now is "+LocalDateTime.now().toString();

        rabbitTemplate.convertAndSend(queue.getName(), msg);

        System.out.println(" [x] Sent '" + msg + "'");
    }
}

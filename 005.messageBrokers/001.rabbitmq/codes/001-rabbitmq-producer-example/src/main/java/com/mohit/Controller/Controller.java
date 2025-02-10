package com.mohit.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.Producer.Producer;

import ch.qos.logback.core.net.SyslogOutputStream;

@RestController
public class Controller {

    private Producer producer;

    public Controller(Producer producer) {

        this.producer = producer;
    }


    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage
    (@RequestParam("message") String message){
    	System.out.println("In controller");
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ ...");
    }
}

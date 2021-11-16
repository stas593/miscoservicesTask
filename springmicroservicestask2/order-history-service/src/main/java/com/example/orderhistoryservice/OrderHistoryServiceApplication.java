package com.example.orderhistoryservice;

import com.example.orderhistoryservice.entity.OrderHistoryEntity;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderHistoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderHistoryServiceApplication.class, args);
    }
}

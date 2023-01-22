package com.example.demo.orderdemo.database;

import java.sql.Timestamp;
import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.orderdemo.model.Order;
import com.example.demo.orderdemo.repository.OrderRepository;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(OrderRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Order("Maito", "1", Timestamp.from(Instant.now()))));
      log.info("Preloading " + repository.save(new Order("Kahvi", "2", Timestamp.from(Instant.now()))));
    };
  }
}
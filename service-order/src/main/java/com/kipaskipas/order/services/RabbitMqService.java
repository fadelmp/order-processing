package com.kipaskipas.order.services;

import org.springframework.stereotype.Service;

import com.kipaskipas.order.dto.ProductDto;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RabbitMqService {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  public void UpdateStock(ProductDto productDto) {

    try {
      String routingKey = "update_product_stock";

      rabbitTemplate.convertAndSend(routingKey, productDto);

    } catch (Exception e) {
      // Error Handling
      System.out.println(e);
    }

  }

}
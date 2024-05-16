package com.kipaskipas.order.route;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kipaskipas.order.controller.ProductController;
import com.kipaskipas.order.dto.ProductDto;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin()
@RestController
public class RabbitMqRoute {

  @Autowired
  private ProductController controller;

  @RabbitHandler
  @RabbitListener(queues = "product")
  public void UpdateStock(@RequestBody ProductDto productDto) {

    controller.UpdateStock(productDto);
  }

}
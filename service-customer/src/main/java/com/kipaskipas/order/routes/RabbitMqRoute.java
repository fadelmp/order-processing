package com.kipaskipas.order.routes;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kipaskipas.order.controllers.CustomerController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin()
@RestController
public class RabbitMqRoute {

  @Autowired
  private CustomerController controller;

  @RabbitHandler
  @RabbitListener(queues = "customer")
  public String CheckCustomerId(@RequestBody String id) {

    return controller.CheckId(id);
  }

}
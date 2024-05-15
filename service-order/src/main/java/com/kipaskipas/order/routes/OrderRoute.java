package com.kipaskipas.order.routes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kipaskipas.order.controllers.OrderController;
import com.kipaskipas.order.dto.OrderDto;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

@CrossOrigin()
@RestController
@RequestMapping("/orders")
public class OrderRoute {

  @Autowired
  private OrderController controller;

  @PostMapping
  public ResponseEntity<Object> Save(
      @Valid @RequestBody OrderDto orderDto, Errors errors,
      HttpServletRequest httpRequest) {

    return controller.Save(orderDto, errors);
  }

}
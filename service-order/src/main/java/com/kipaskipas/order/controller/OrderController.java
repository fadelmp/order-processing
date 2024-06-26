package com.kipaskipas.order.controller;

import org.springframework.validation.Errors;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.kipaskipas.order.config.OrderMessage;
import com.kipaskipas.order.dto.OrderDto;
import com.kipaskipas.order.helper.ResponseApi;
import com.kipaskipas.order.helper.Validate;
import com.kipaskipas.order.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;

public interface OrderController {

  ResponseEntity<Object> Save(OrderDto orderDto, Errors errors);
}

@Service
@RestController
class OrderControllerImpl implements OrderController {

  @Autowired
  private OrderService service;

  public ResponseEntity<Object> Save(OrderDto orderDto, Errors errors) {

    Validate.Request(errors);

    service.Save(orderDto);

    return ResponseApi.Success(OrderMessage.CREATE_SUCCESS, orderDto);
  }

}
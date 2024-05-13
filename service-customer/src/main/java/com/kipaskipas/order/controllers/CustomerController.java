package com.kipaskipas.order.controllers;

import java.util.Objects;

import org.springframework.validation.Errors;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.kipaskipas.order.dto.CustomerDto;
import com.kipaskipas.order.helpers.ResponseApi;
import com.kipaskipas.order.helpers.Validate;
import com.kipaskipas.order.messages.CustomerMessage;
import com.kipaskipas.order.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;

public interface CustomerController {

  ResponseEntity<Object> GetById(String id);

  ResponseEntity<Object> Create(CustomerDto customerDto, Errors errors);

  ResponseEntity<Object> Update(CustomerDto customerDto, String id, Errors errors);
}

@Service
@RestController
class CustomerControllerImpl implements CustomerController {

  @Autowired
  private CustomerService service;

  public ResponseEntity<Object> GetById(String id) {

    CustomerDto customerDto = service.GetById(id);

    return (Objects.isNull(customerDto))
        ? ResponseApi.Empty(CustomerMessage.NOT_FOUND)
        : ResponseApi.Success(CustomerMessage.GET_SUCCESS, customerDto);
  }

  public ResponseEntity<Object> Create(CustomerDto customerDto, Errors errors) {

    Validate.Request(errors);

    service.Create(customerDto);

    return ResponseApi.Success(CustomerMessage.CREATE_SUCCESS, customerDto);
  }

  public ResponseEntity<Object> Update(CustomerDto customerDto, String id, Errors errors) {

    Validate.Request(errors);

    service.Update(customerDto.setId(id));

    return ResponseApi.Success(CustomerMessage.UPDATE_SUCCESS, customerDto);
  }

}
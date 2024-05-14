package com.kipaskipas.order.controllers;

import java.util.Objects;

import org.springframework.validation.Errors;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.kipaskipas.order.config.ProductMessage;
import com.kipaskipas.order.dto.ProductDto;
import com.kipaskipas.order.helpers.ResponseApi;
import com.kipaskipas.order.helpers.Validate;
import com.kipaskipas.order.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;

public interface ProductController {

  String CheckId(String id);

  ResponseEntity<Object> GetById(String id);

  ResponseEntity<Object> Create(ProductDto productDto, Errors errors);

  ResponseEntity<Object> Update(ProductDto productDto, String id, Errors errors);
}

@Service
@RestController
class ProductControllerImpl implements ProductController {

  @Autowired
  private ProductService service;

  public String CheckId(String id) {

    ProductDto productDto = service.GetById(id);

    return (Objects.isNull(productDto)) ? ProductMessage.NOT_FOUND : "";
  }

  public ResponseEntity<Object> GetById(String id) {

    ProductDto productDto = service.GetById(id);

    return (Objects.isNull(productDto))
        ? ResponseApi.Empty(ProductMessage.NOT_FOUND)
        : ResponseApi.Success(ProductMessage.GET_SUCCESS, productDto);
  }

  public ResponseEntity<Object> Create(ProductDto productDto, Errors errors) {

    Validate.Request(errors);

    service.Create(productDto);

    return ResponseApi.Success(ProductMessage.CREATE_SUCCESS, productDto);
  }

  public ResponseEntity<Object> Update(ProductDto productDto, String id, Errors errors) {

    Validate.Request(errors);

    service.Update(productDto.setId(id));

    return ResponseApi.Success(ProductMessage.UPDATE_SUCCESS, productDto);
  }

}
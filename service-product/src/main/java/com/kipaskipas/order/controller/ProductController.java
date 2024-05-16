package com.kipaskipas.order.controller;

import java.util.Objects;

import org.springframework.validation.Errors;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.kipaskipas.order.config.ProductMessage;
import com.kipaskipas.order.dto.ProductDto;
import com.kipaskipas.order.helper.ResponseApi;
import com.kipaskipas.order.helper.Validate;
import com.kipaskipas.order.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;

public interface ProductController {

  void UpdateStock(ProductDto productDto);

  ResponseEntity<Object> GetById(String id);

  ResponseEntity<Object> Create(ProductDto productDto, Errors errors);

  ResponseEntity<Object> Update(ProductDto productDto, String id, Errors errors);
}

@Service
@RestController
class ProductControllerImpl implements ProductController {

  @Autowired
  private ProductService service;

  public void UpdateStock(ProductDto productDto) {

    service.UpdateStock(productDto);
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
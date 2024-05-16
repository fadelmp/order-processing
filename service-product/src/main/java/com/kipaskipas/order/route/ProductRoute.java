package com.kipaskipas.order.route;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kipaskipas.order.controller.ProductController;
import com.kipaskipas.order.dto.ProductDto;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin()
@RestController
@RequestMapping("/products")
public class ProductRoute {

  @Autowired
  private ProductController controller;

  @GetMapping(value = "/{id}")
  public ResponseEntity<Object> GetById(@PathVariable("id") String id, HttpServletRequest httpRequest) {

    return controller.GetById(id);
  }

  @PostMapping
  public ResponseEntity<Object> Create(
      @Valid @RequestBody ProductDto productDto, Errors errors,
      HttpServletRequest httpRequest) {

    return controller.Create(productDto, errors);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Object> Update(
      @PathVariable("id") String id,
      @Valid @RequestBody ProductDto productDto, Errors errors,
      HttpServletRequest httpRequest) {

    return controller.Update(productDto, id, errors);
  }

}
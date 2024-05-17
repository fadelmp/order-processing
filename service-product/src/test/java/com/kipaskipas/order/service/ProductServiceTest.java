package com.kipaskipas.order.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.kipaskipas.order.dto.ProductDto;

@DataJpaTest
public class ProductServiceTest {

  @Autowired
  private ProductService productService;

  @Test
  public void testCreate() {

    // Given ProductDto
    ProductDto productDto = new ProductDto()
        .setName("Baju Kerah")
        .setPrice(150000.00)
        .setStock(3)
        .setCreatedBy("Fadel")
        .setUpdatedBy("Fadel");

    // When
    productService.Create(productDto);

    // Then
    assertNotNull(productDto.getId());
    assertNotEquals(productDto.getId(), "");
    assertDoesNotThrow(() -> productService.Create(productDto));
  }

  @Test
  public void testUpdate() {

    // Given ProductDto
    ProductDto productDto = new ProductDto()
        .setId("3f4b1f2f-cb60-4842-9792-e4b2c3ff26cd")
        .setName("Baju Kerah")
        .setPrice(150000.00)
        .setStock(3)
        .setCreatedBy("Fadel")
        .setUpdatedBy("Fadel");

    // When
    productService.Update(productDto);

    // Then
    assertDoesNotThrow(() -> productService.Update(productDto));
  }

  @Test
  public void testUpdateStock() {

    // Given ProductDto
    ProductDto productDto = new ProductDto()
        .setId("3f4b1f2f-cb60-4842-9792-e4b2c3ff26cd")
        .setStock(1);

    // When
    productService.UpdateStock(productDto);

    // Then
    assertDoesNotThrow(() -> productService.UpdateStock(productDto));
  }

}

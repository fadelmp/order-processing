package com.kipaskipas.order.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.kipaskipas.order.dto.ProductDto;
import com.kipaskipas.order.model.Product;

@DataJpaTest
public class ProductMapperTest {

  @Autowired
  private ProductMapper productMapper;

  @Test
  public void testToProduct() {

    // Given ProductDto
    ProductDto productDto = new ProductDto()
        .setName("Baju")
        .setPrice(150000.00)
        .setStock(3)
        .setCreatedBy("Fadel")
        .setUpdatedBy("Fadel");

    // Given Result
    Product product = new Product()
        .setName("Baju")
        .setPrice(150000.00)
        .setStock(3)
        .setCreatedBy("Fadel")
        .setUpdatedBy("Fadel");

    // When
    Product result = productMapper.ToProduct(productDto);

    // Then
    assertEquals(product, result);
  }

  @Test
  public void testToProductDto() {

    // Given Result
    Product product = new Product()
        .setId("b3457f1c-b2ad-48c6-8ed7-3a5084223010")
        .setName("Baju")
        .setPrice(150000.00)
        .setStock(3)
        .setCreatedBy("Fadel")
        .setUpdatedBy("Fadel");

    // Given ProductDto
    ProductDto productDto = new ProductDto()
        .setId("b3457f1c-b2ad-48c6-8ed7-3a5084223010")
        .setName("Baju")
        .setPrice(150000.00)
        .setStock(3)
        .setCreatedBy("Fadel")
        .setUpdatedBy("Fadel");

    // When
    ProductDto result = productMapper.ToProductDto(product);

    // Then
    assertEquals(productDto, result);
  }

}

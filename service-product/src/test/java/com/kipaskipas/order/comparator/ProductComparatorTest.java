package com.kipaskipas.order.comparator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.kipaskipas.order.dto.ProductDto;

@DataJpaTest
public class ProductComparatorTest {

  @Autowired
  private ProductComparator productComparator;

  @Test
  public void testCheckId() {

    // Given
    ProductDto productDto = new ProductDto()
        .setId("3f4b1f2f-cb60-4842-9792-e4b2c3ff26cd")
        .setName("Celana")
        .setDescription("")
        .setPrice(200000.00)
        .setStock(10)
        .setCreatedBy("Fadel")
        .setUpdatedBy("Fadel");

    // Then
    assertDoesNotThrow(() -> productComparator.CheckId(productDto));
  }

  @Test
  public void testCheckName() {

    // Given
    ProductDto productDto = new ProductDto()
        .setId("b3457f1c-b2ad-48c6-8ed7-3a5084223010")
        .setName("Celana")
        .setDescription("")
        .setPrice(200000.00)
        .setStock(10)
        .setCreatedBy("Fadel")
        .setUpdatedBy("Fadel");

    // Then
    assertDoesNotThrow(() -> productComparator.CheckName(productDto));
  }

}

package com.kipaskipas.order.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.kipaskipas.order.dto.ProductDto;

@DataJpaTest
public class RabbitMqServiceTest {

  @Autowired
  private RabbitMqService rabbitService;

  @Test
  public void testUpdateStock() {

    // Given OrderDto
    ProductDto productDto = new ProductDto()
        .setId("3f4b1f2f-cb60-4842-9792-e4b2c3ff26cd")
        .setStock(3);

    // Then
    assertDoesNotThrow(() -> rabbitService.UpdateStock(productDto));
  }

}

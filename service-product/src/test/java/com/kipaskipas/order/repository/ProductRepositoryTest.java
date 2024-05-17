package com.kipaskipas.order.repository;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.kipaskipas.order.model.Product;

@DataJpaTest
public class ProductRepositoryTest {

  @Autowired
  private ProductRepository productRepo;

  @Test
  public void testSave() {

    // Given
    Product product = new Product()
        .setName("Kemeja")
        .setDescription("Kemeja Formal")
        .setPrice(200000.00)
        .setStock(10)
        .setCreatedBy("Fadel")
        .setUpdatedBy("Fadel");

    // When
    productRepo.save(product);

    // Then
    assertNotNull(product.getId());
    assertNotEquals(product.getId(), "");
    assertDoesNotThrow(() -> productRepo.save(product));
  }

}

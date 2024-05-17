package com.kipaskipas.order.repository;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.kipaskipas.order.model.Customer;
import com.kipaskipas.order.model.Order;
import com.kipaskipas.order.model.Product;

@DataJpaTest
public class OrderRepositoryTest {

  @Autowired
  private OrderRepository orderRepo;

  @Test
  public void testSave() {

    // Given
    Order order = new Order()
        .setCustomer(new Customer().setId("dcbc62d3-266a-43d5-a1aa-21265fb3dece"))
        .setCustomerName("Fadel")
        .setProduct(new Product().setId("3f4b1f2f-cb60-4842-9792-e4b2c3ff26cd"))
        .setProductName("Baju")
        .setAmount(150000.00)
        .setQuantity(3)
        .setCreatedBy("Fadel")
        .setUpdatedBy("Fadel");

    // When
    orderRepo.save(order);

    // Then
    assertNotNull(order.getId());
    assertNotEquals(order.getId(), "");
    assertDoesNotThrow(() -> orderRepo.save(order));
  }

}

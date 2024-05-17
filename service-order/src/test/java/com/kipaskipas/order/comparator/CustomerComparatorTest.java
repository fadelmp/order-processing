package com.kipaskipas.order.comparator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.kipaskipas.order.dto.OrderDto;

@DataJpaTest
public class CustomerComparatorTest {

  @Autowired
  private CustomerComparator customerComparator;

  @Test
  public void testCheckCustomer() {

    // Given
    OrderDto orderDto = new OrderDto()
        .setCustomerId("dcbc62d3-266a-43d5-a1aa-21265fb3dece")
        .setCustomerName("Fadel")
        .setProductId("3f4b1f2f-cb60-4842-9792-e4b2c3ff26cd")
        .setProductName("Baju")
        .setAmount(150000.00)
        .setQuantity(3)
        .setCreatedBy("Fadel")
        .setUpdatedBy("Fadel");

    // Then
    assertDoesNotThrow(() -> customerComparator.CheckCustomer(orderDto));
  }

}

package com.kipaskipas.order.comparator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.kipaskipas.order.dto.CustomerDto;

@DataJpaTest
public class CustomerComparatorTest {

  @Autowired
  private CustomerComparator CustomerComparator;

  @Test
  public void testCheckId() {

    // Given
    CustomerDto CustomerDto = new CustomerDto()
        .setId("3f4b1f2f-cb60-4842-9792-e4b2c3ff26cd")
        .setName("Fadel")
        .setAddress("Jakarta Selatan")
        .setPhone("081220717602")
        .setCreatedBy("Fadel")
        .setUpdatedBy("Fadel");

    // Then
    assertDoesNotThrow(() -> CustomerComparator.CheckId(CustomerDto));
  }

  @Test
  public void testCheckName() {

    // Given
    CustomerDto CustomerDto = new CustomerDto()
        .setId("b3457f1c-b2ad-48c6-8ed7-3a5084223010")
        .setName("Fadel")
        .setAddress("Jakarta Selatan")
        .setPhone("081220717602")
        .setCreatedBy("Fadel")
        .setUpdatedBy("Fadel");

    // Then
    assertDoesNotThrow(() -> CustomerComparator.CheckName(CustomerDto));
  }

}

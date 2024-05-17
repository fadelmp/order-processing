package com.kipaskipas.order.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.kipaskipas.order.dto.CustomerDto;

@DataJpaTest
public class CustomerServiceTest {

  @Autowired
  private CustomerService CustomerService;

  @Test
  public void testCreate() {

    // Given CustomerDto
    CustomerDto CustomerDto = new CustomerDto()
        .setName("Fadellll")
        .setAddress("Jakarta Selatan")
        .setPhone("081220717602")
        .setCreatedBy("Fadel")
        .setUpdatedBy("Fadel");

    // When
    CustomerService.Create(CustomerDto);

    // Then
    assertNotNull(CustomerDto.getId());
    assertNotEquals(CustomerDto.getId(), "");
    assertDoesNotThrow(() -> CustomerService.Create(CustomerDto));
  }

  @Test
  public void testUpdate() {

    // Given CustomerDto
    CustomerDto CustomerDto = new CustomerDto()
        .setId("3f4b1f2f-cb60-4842-9792-e4b2c3ff26cd")
        .setName("Fadel")
        .setAddress("Jakarta Selatan")
        .setPhone("081220717602")
        .setCreatedBy("Fadel")
        .setUpdatedBy("Fadel");

    // When
    CustomerService.Update(CustomerDto);

    // Then
    assertDoesNotThrow(() -> CustomerService.Update(CustomerDto));
  }

}

package com.kipaskipas.order.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.kipaskipas.order.dto.CustomerDto;
import com.kipaskipas.order.model.Customer;

@DataJpaTest
public class CustomerMapperTest {

  @Autowired
  private CustomerMapper CustomerMapper;

  @Test
  public void testToCustomer() {

    // Given CustomerDto
    CustomerDto CustomerDto = new CustomerDto()
        .setName("Fadel")
        .setAddress("Jakarta Selatan")
        .setPhone("081220717602")
        .setCreatedBy("Fadel")
        .setUpdatedBy("Fadel");

    // Given Result
    Customer Customer = new Customer()
        .setName("Fadel")
        .setAddress("Jakarta Selatan")
        .setPhone("081220717602")
        .setCreatedBy("Fadel")
        .setUpdatedBy("Fadel");

    // When
    Customer result = CustomerMapper.ToCustomer(CustomerDto);

    // Then
    assertEquals(Customer, result);
  }

  @Test
  public void testToCustomerDto() {

    // Given Result
    Customer Customer = new Customer()
        .setId("b3457f1c-b2ad-48c6-8ed7-3a5084223010")
        .setName("Fadel")
        .setAddress("Jakarta Selatan")
        .setPhone("081220717602")
        .setCreatedBy("Fadel")
        .setUpdatedBy("Fadel");

    // Given CustomerDto
    CustomerDto CustomerDto = new CustomerDto()
        .setId("b3457f1c-b2ad-48c6-8ed7-3a5084223010")
        .setName("Fadel")
        .setAddress("Jakarta Selatan")
        .setPhone("081220717602")
        .setCreatedBy("Fadel")
        .setUpdatedBy("Fadel");

    // When
    CustomerDto result = CustomerMapper.ToCustomerDto(Customer);

    // Then
    assertEquals(CustomerDto, result);
  }

}

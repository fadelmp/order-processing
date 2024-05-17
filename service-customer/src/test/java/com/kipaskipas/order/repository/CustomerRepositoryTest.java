package com.kipaskipas.order.repository;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.kipaskipas.order.model.Customer;

@DataJpaTest
public class CustomerRepositoryTest {

  @Autowired
  private CustomerRepository CustomerRepo;

  @Test
  public void testSave() {

    // Given
    Customer Customer = new Customer()
        .setName("Fadell")
        .setAddress("Jakarta Selatan")
        .setPhone("081220717602")
        .setCreatedBy("Fadel")
        .setUpdatedBy("Fadel");

    // When
    CustomerRepo.save(Customer);

    // Then
    assertNotNull(Customer.getId());
    assertNotEquals(Customer.getId(), "");
    assertDoesNotThrow(() -> CustomerRepo.save(Customer));
  }

}

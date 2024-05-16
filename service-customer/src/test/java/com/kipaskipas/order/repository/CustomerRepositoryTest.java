package com.kipaskipas.order.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.kipaskipas.order.models.Customer;

@DataJpaTest
public class CustomerRepositoryTest {

  @Autowired
  private CustomerRepository customerRepo;

  public void testFindById() {

    // Given
    String id = "12345";

    // When
    Optional<Customer> customer = customerRepo.findById(id);

    // Then
    if (customer.isPresent())
      assertEquals(customer.get().getId(), id);
  }

  public void testFindByName() {

    // Given
    String name = "fadel";

    // When
    Optional<Customer> customer = customerRepo.findByNameAndIsDeletedFalse(name);

    // Then
    if (customer.isPresent())
      assertEquals(customer.get().getName(), name);
  }

}

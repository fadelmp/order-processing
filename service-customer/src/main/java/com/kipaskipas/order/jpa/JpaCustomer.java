package com.kipaskipas.order.jpa;

import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kipaskipas.order.models.Customer;

public interface JpaCustomer extends JpaRepository<Customer, String> {

  @Cacheable("customer_id")
  Optional<Customer> findByIdAndIsDeletedFalse(String id);

  @Cacheable("customer_name")
  Optional<Customer> findByNameAndIsDeletedFalse(String name);

  @Override
  @CacheEvict(value = { "customer*" }, allEntries = true)
  <C extends Customer> C save(C customer);

}

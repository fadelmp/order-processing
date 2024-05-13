package com.kipaskipas.order.repository;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.kipaskipas.order.exceptions.InternalServer;
import com.kipaskipas.order.jpa.JpaCustomer;
import com.kipaskipas.order.messages.CustomerMessage;
import com.kipaskipas.order.models.Customer;

import org.springframework.beans.factory.annotation.Autowired;

public interface CustomerRepository {

  void Create(Customer Customer);

  void Update(Customer Customer);

  Optional<Customer> FindById(String id);

  Optional<Customer> FindByName(String name);
}

@Service
class CustomerRepositoryImpl implements CustomerRepository {

  @Autowired
  private JpaCustomer jpaCustomer;

  public void Create(Customer Customer) {

    save(Customer, CustomerMessage.CREATE_FAILED);
  }

  public void Update(Customer Customer) {

    save(Customer, CustomerMessage.UPDATE_FAILED);
  }

  public Optional<Customer> FindById(String id) {

    Optional<Customer> customer = Optional.empty();

    try {
      customer = jpaCustomer.findByIdAndIsDeletedFalse(id);

    } catch (Exception e) {
      // Error Handling
      throw new InternalServer(CustomerMessage.INTERNAL_SERVER);
    }

    return customer;
  }

  public Optional<Customer> FindByName(String name) {

    Optional<Customer> customer = Optional.empty();

    try {
      customer = jpaCustomer.findByNameAndIsDeletedFalse(name);

    } catch (Exception e) {
      // Error Handling
      throw new InternalServer(CustomerMessage.INTERNAL_SERVER);
    }

    return customer;
  }

  private void save(Customer customer, String errorMessage) {

    try {
      jpaCustomer.save(customer);

    } catch (Exception e) {
      // Error Handling
      throw new InternalServer(errorMessage);
    }
  }

}
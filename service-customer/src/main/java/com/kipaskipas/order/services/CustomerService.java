package com.kipaskipas.order.services;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.kipaskipas.order.comparator.CustomerComparator;
import com.kipaskipas.order.dto.CustomerDto;
import com.kipaskipas.order.mapper.CustomerMapper;
import com.kipaskipas.order.models.Customer;
import com.kipaskipas.order.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;

public interface CustomerService {

  void Create(CustomerDto CustomerDto);

  void Update(CustomerDto CustomerDto);

  CustomerDto GetById(String customerId);
}

@Service
class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerMapper mapper;

  @Autowired
  private CustomerComparator comparator;

  @Autowired
  private CustomerRepository repository;

  public void Create(CustomerDto customerDto) {

    comparator.CheckName(customerDto);

    Customer customer = mapper.ToCustomer(customerDto);
    repository.Create(customer);

    customerDto.setId(customer.getId());
  }

  public void Update(CustomerDto customerDto) {

    comparator.CheckId(customerDto);
    comparator.CheckName(customerDto);

    Customer customer = mapper.ToCustomer(customerDto);
    repository.Update(customer);

    customerDto.setId(customer.getId());
  }

  public CustomerDto GetById(String id) {

    Optional<Customer> customer = repository.FindById(id);

    return mapper.ToCustomerDto(customer.get());
  }

}
package com.kipaskipas.order.service;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.kipaskipas.order.comparator.CustomerComparator;
import com.kipaskipas.order.config.CustomerMessage;
import com.kipaskipas.order.dto.CustomerDto;
import com.kipaskipas.order.helper.exception.InternalServer;
import com.kipaskipas.order.mapper.CustomerMapper;
import com.kipaskipas.order.model.Customer;
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

    try {
      comparator.CheckName(customerDto);

      Customer customer = mapper.ToCustomer(customerDto);
      repository.save(customer);

      customerDto.setId(customer.getId());

    } catch (Exception e) {
      // Error Handling
      System.out.println(e);
      throw new InternalServer(CustomerMessage.CREATE_FAILED);
    }

  }

  public void Update(CustomerDto customerDto) {

    try {
      comparator.CheckId(customerDto);
      comparator.CheckName(customerDto);

      Customer customer = mapper.ToCustomer(customerDto);
      repository.save(customer);

      customerDto.setId(customer.getId());

    } catch (Exception e) {
      // Error Handling
      System.out.println(e);
      throw new InternalServer(CustomerMessage.UPDATE_FAILED);
    }

  }

  public CustomerDto GetById(String id) {

    CustomerDto customerDto = new CustomerDto();

    try {
      Optional<Customer> customerOpt = repository.findByIdAndIsDeletedFalse(id);

      customerDto = (customerOpt.isPresent()) ? mapper.ToCustomerDto(customerOpt.get()) : null;

    } catch (Exception e) {
      // Error Handling
      System.out.println(e);
      throw new InternalServer(CustomerMessage.INTERNAL_SERVER);
    }

    return customerDto;
  }

}
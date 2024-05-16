package com.kipaskipas.order.mapper;

import org.springframework.stereotype.Service;

import com.kipaskipas.order.dto.CustomerDto;
import com.kipaskipas.order.models.Customer;

public interface CustomerMapper {

  Customer ToCustomer(CustomerDto customerDto);

  CustomerDto ToCustomerDto(Customer customer);
}

@Service
class CustomerMapperImpl implements CustomerMapper {

  public Customer ToCustomer(CustomerDto customerDto) {

    return new Customer()
        .setId(customerDto.getId())
        .setName(customerDto.getName())
        .setPhone(customerDto.getPhone())
        .setAddress(customerDto.getAddress())
        .setCreatedBy(customerDto.getCreatedBy())
        .setUpdatedBy(customerDto.getUpdatedBy());
  }

  public CustomerDto ToCustomerDto(Customer customer) {

    return new CustomerDto()
        .setId(customer.getId())
        .setName(customer.getName())
        .setAddress(customer.getAddress())
        .setPhone(customer.getPhone())
        .setIsActived(customer.getIsActived())
        .setCreatedAt(customer.getCreatedAt())
        .setCreatedBy(customer.getCreatedBy())
        .setUpdatedAt(customer.getUpdatedAt())
        .setUpdatedBy(customer.getUpdatedBy());
  }

}
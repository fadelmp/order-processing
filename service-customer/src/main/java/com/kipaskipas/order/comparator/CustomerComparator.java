package com.kipaskipas.order.comparator;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.kipaskipas.order.config.CustomerMessage;
import com.kipaskipas.order.dto.CustomerDto;
import com.kipaskipas.order.helpers.CheckString;
import com.kipaskipas.order.helpers.exceptions.InternalServer;
import com.kipaskipas.order.helpers.exceptions.NotFound;
import com.kipaskipas.order.models.Customer;
import com.kipaskipas.order.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;

public interface CustomerComparator {

  void CheckId(CustomerDto customerDto);

  void CheckName(CustomerDto customerDto);
}

@Service
class CustomerComparatorImpl implements CustomerComparator {

  @Autowired
  protected CustomerRepository customerRepo;

  public void CheckId(CustomerDto customerDto) {

    String customerId = customerDto.getId();

    Optional<Customer> customer = customerRepo.findByIdAndIsDeletedFalse(customerId);

    if (!customer.isPresent())
      throw new NotFound(CustomerMessage.NOT_FOUND);
  }

  public void CheckName(CustomerDto customerDto) {

    String customerId = customerDto.getId();
    String customerName = customerDto.getName();

    Optional<Customer> customer = customerRepo.findByNameAndIsDeletedFalse(customerName);

    if (customer.isPresent())
      if (CheckString.Check(customer.get().getName(), customerName) &&
          !customer.get().getId().equals(customerId))
        throw new InternalServer(CustomerMessage.NAME_EXISTS);
  }

}
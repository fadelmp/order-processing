package com.kipaskipas.order.comparator;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.kipaskipas.order.config.OrderMessage;
import com.kipaskipas.order.dto.OrderDto;
import com.kipaskipas.order.helper.exception.InternalServer;
import com.kipaskipas.order.model.Customer;
import com.kipaskipas.order.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;

public interface CustomerComparator {

  void CheckCustomer(OrderDto orderDto);
}

@Service
class CustomerComparatorImpl implements CustomerComparator {

  @Autowired
  protected CustomerRepository customerRepo;

  public void CheckCustomer(OrderDto orderDto) {

    String customerId = orderDto.getCustomerId();

    Optional<Customer> customer = customerRepo.findByIdAndIsDeletedFalse(customerId);

    if (!customer.isPresent())
      throw new InternalServer(OrderMessage.CUSTOMER_NOT_FOUND);
  }

}
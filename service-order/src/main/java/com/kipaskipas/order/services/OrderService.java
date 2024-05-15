package com.kipaskipas.order.services;

import org.springframework.stereotype.Service;

import com.kipaskipas.order.comparator.OrderComparator;
import com.kipaskipas.order.config.OrderMessage;
import com.kipaskipas.order.dto.OrderDto;
import com.kipaskipas.order.helpers.exceptions.InternalServer;
import com.kipaskipas.order.mapper.OrderMapper;
import com.kipaskipas.order.models.Order;
import com.kipaskipas.order.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;

public interface OrderService {

  void Save(OrderDto orderDto);
}

@Service
class OrderServiceImpl implements OrderService {

  @Autowired
  private OrderMapper mapper;

  @Autowired
  private OrderComparator comparator;

  @Autowired
  private OrderRepository repository;

  public void Save(OrderDto orderDto) {

    try {
      comparator.CheckCustomer(orderDto);
      comparator.CheckProduct(orderDto);

      Order order = mapper.ToOrder(orderDto);
      repository.save(order);

      orderDto.setId(order.getId());

    } catch (Exception e) {
      // Error Handling
      System.out.println(e);
      throw new InternalServer(OrderMessage.CREATE_FAILED);
    }

  }

}
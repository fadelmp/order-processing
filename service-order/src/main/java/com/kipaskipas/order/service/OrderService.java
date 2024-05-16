package com.kipaskipas.order.service;

import org.springframework.stereotype.Service;

import com.kipaskipas.order.comparator.OrderComparator;
import com.kipaskipas.order.config.OrderMessage;
import com.kipaskipas.order.dto.OrderDto;
import com.kipaskipas.order.dto.ProductDto;
import com.kipaskipas.order.helper.exception.InternalServer;
import com.kipaskipas.order.mapper.OrderMapper;
import com.kipaskipas.order.model.Order;
import com.kipaskipas.order.repository.OrderRepository;

import org.hibernate.QueryException;
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

  @Autowired
  private RabbitMqService rabbitService;

  public void Save(OrderDto orderDto) {

    try {
      comparator.CheckCustomer(orderDto);
      comparator.CheckProduct(orderDto);

      Order order = mapper.ToOrder(orderDto);
      repository.save(order);

      ProductDto productDto = mapper.ToProductDto(orderDto);
      rabbitService.UpdateStock(productDto);

      orderDto.setId(order.getId());

    } catch (QueryException e) {
      // Error Handling
      System.out.println(e);
      throw new InternalServer(OrderMessage.CREATE_FAILED);
    }

  }

}
package com.kipaskipas.order.service;

import org.springframework.stereotype.Service;

import com.kipaskipas.order.comparator.CustomerComparator;
import com.kipaskipas.order.comparator.ProductComparator;
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
  private OrderRepository repository;

  @Autowired
  private RabbitMqService rabbitService;

  @Autowired
  private ProductComparator productComp;

  @Autowired
  private CustomerComparator customerComp;

  public void Save(OrderDto orderDto) {

    try {
      customerComp.CheckCustomer(orderDto); // Validate Customer Data
      productComp.CheckProduct(orderDto); // Validate Product Data

      Order order = mapper.ToOrder(orderDto); // Map OrderDto to Order
      repository.save(order); // Save to Database

      ProductDto productDto = mapper.ToProductDto(orderDto); // Map To ProductDto
      rabbitService.UpdateStock(productDto); // Send Update Stock via RabbitMq

      orderDto.setId(order.getId());

    } catch (QueryException e) {
      // Error Handling
      System.out.println(e);
      throw new InternalServer(OrderMessage.CREATE_FAILED);
    }

  }

}
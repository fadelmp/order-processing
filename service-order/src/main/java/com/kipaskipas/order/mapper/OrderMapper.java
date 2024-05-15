package com.kipaskipas.order.mapper;

import org.springframework.stereotype.Service;

import com.kipaskipas.order.dto.OrderDto;
import com.kipaskipas.order.models.Customer;
import com.kipaskipas.order.models.Order;
import com.kipaskipas.order.models.Product;

public interface OrderMapper {

  Order ToOrder(OrderDto orderDto);
}

@Service
class OrderMapperImpl implements OrderMapper {

  public Order ToOrder(OrderDto orderDto) {

    return new Order()
        .setCustomer(new Customer().setId(orderDto.getCustomerId()))
        .setProduct(new Product().setId(orderDto.getProductId()))
        .setCustomerName(orderDto.getCustomerName())
        .setProductName(orderDto.getProductName())
        .setAmount(orderDto.getAmount())
        .setQuantity(orderDto.getQuantity())
        .setCreatedBy(orderDto.getCreatedBy())
        .setUpdatedBy(orderDto.getUpdatedBy());
  }

}
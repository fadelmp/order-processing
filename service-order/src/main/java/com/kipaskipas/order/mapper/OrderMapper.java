package com.kipaskipas.order.mapper;

import org.springframework.stereotype.Service;

import com.kipaskipas.order.dto.OrderDto;
import com.kipaskipas.order.models.Order;

public interface OrderMapper {

  Order ToOrder(OrderDto OrderDto);
}

@Service
class OrderMapperImpl implements OrderMapper {

  public Order ToOrder(OrderDto OrderDto) {

    return new Order()
        .setName(OrderDto.getName())
        .setDescription(OrderDto.getDescription())
        .setPrice(OrderDto.getPrice())
        .setStock(OrderDto.getStock())
        .setCreatedBy(OrderDto.getCreatedBy())
        .setUpdatedBy(OrderDto.getUpdatedBy());
  }

}
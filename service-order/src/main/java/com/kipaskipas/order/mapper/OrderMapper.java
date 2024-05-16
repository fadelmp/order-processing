package com.kipaskipas.order.mapper;

import org.springframework.stereotype.Service;

import com.kipaskipas.order.dto.OrderDto;
import com.kipaskipas.order.dto.ProductDto;
import com.kipaskipas.order.model.Customer;
import com.kipaskipas.order.model.Order;
import com.kipaskipas.order.model.Product;

public interface OrderMapper {

  Order ToOrder(OrderDto orderDto);

  ProductDto ToProductDto(OrderDto orderDto);
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

  public ProductDto ToProductDto(OrderDto orderDto) {

    return new ProductDto()
        .setId(orderDto.getProductId())
        .setStock(orderDto.getQuantity());
  }

}
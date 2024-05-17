package com.kipaskipas.order.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.kipaskipas.order.dto.OrderDto;
import com.kipaskipas.order.dto.ProductDto;
import com.kipaskipas.order.model.Customer;
import com.kipaskipas.order.model.Order;
import com.kipaskipas.order.model.Product;

@DataJpaTest
public class OrderMapperTest {

  @Autowired
  private OrderMapper orderMapper;

  @Test
  public void testToOrder() {

    // Given OrderDto
    OrderDto orderDto = new OrderDto()
        .setCustomerId("dcbc62d3-266a-43d5-a1aa-21265fb3dece")
        .setCustomerName("Fadel")
        .setProductId("3f4b1f2f-cb60-4842-9792-e4b2c3ff26cd")
        .setProductName("Baju")
        .setAmount(150000.00)
        .setQuantity(3)
        .setCreatedBy("Fadel")
        .setUpdatedBy("Fadel");

    // Given Result
    Order order = new Order()
        .setCustomer(new Customer().setId("dcbc62d3-266a-43d5-a1aa-21265fb3dece"))
        .setCustomerName("Fadel")
        .setProduct(new Product().setId("3f4b1f2f-cb60-4842-9792-e4b2c3ff26cd"))
        .setProductName("Baju")
        .setAmount(150000.00)
        .setQuantity(3)
        .setCreatedBy("Fadel")
        .setUpdatedBy("Fadel");

    // When
    Order result = orderMapper.ToOrder(orderDto);

    // Then
    assertEquals(order, result);
  }

  @Test
  public void testToProductDto() {

    // Given OrderDto
    OrderDto orderDto = new OrderDto()
        .setCustomerId("dcbc62d3-266a-43d5-a1aa-21265fb3dece")
        .setCustomerName("Fadel")
        .setProductId("3f4b1f2f-cb60-4842-9792-e4b2c3ff26cd")
        .setProductName("Baju")
        .setAmount(150000.00)
        .setQuantity(3)
        .setCreatedBy("Fadel")
        .setUpdatedBy("Fadel");

    // Given Result
    ProductDto result = new ProductDto()
        .setId("3f4b1f2f-cb60-4842-9792-e4b2c3ff26cd")
        .setStock(3);

    // When
    ProductDto productDto = orderMapper.ToProductDto(orderDto);

    // Then
    assertEquals(productDto, result);
  }

}

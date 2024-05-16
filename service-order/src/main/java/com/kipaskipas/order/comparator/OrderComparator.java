package com.kipaskipas.order.comparator;

import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.kipaskipas.order.config.OrderMessage;
import com.kipaskipas.order.dto.OrderDto;
import com.kipaskipas.order.helpers.exceptions.InternalServer;
import com.kipaskipas.order.models.Customer;
import com.kipaskipas.order.models.Product;
import com.kipaskipas.order.repository.CustomerRepository;
import com.kipaskipas.order.repository.OrderRepository;
import com.kipaskipas.order.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;

public interface OrderComparator {

  void CheckProduct(OrderDto orderDto);

  void CheckCustomer(OrderDto orderDto);
}

@Service
class OrderComparatorImpl implements OrderComparator {

  @Autowired
  protected OrderRepository OrderRepo;

  @Autowired
  protected ProductRepository productRepo;

  @Autowired
  protected CustomerRepository customerRepo;

  public void CheckProduct(OrderDto orderDto) {

    String productId = orderDto.getProductId();

    Optional<Product> product = productRepo.findByIdAndIsDeletedFalse(productId);

    checkProductId(product);
    checkProductStock(product.get(), orderDto);
    checkProductAmount(product.get(), orderDto);
  }

  public void CheckCustomer(OrderDto orderDto) {

    String customerId = orderDto.getCustomerId();

    Optional<Customer> customer = customerRepo.findByIdAndIsDeletedFalse(customerId);

    if (!customer.isPresent())
      throw new InternalServer(OrderMessage.CUSTOMER_NOT_FOUND);
  }

  private void checkProductId(Optional<Product> productOpt) {

    if (!productOpt.isPresent())
      throw new InternalServer(OrderMessage.PRODUCT_NOT_FOUND);
  }

  private void checkProductStock(Product product, OrderDto orderDto) {

    Integer quantity = orderDto.getQuantity();
    Integer productStock = product.getStock();

    if (productStock == 0)
      throw new InternalServer(OrderMessage.OUT_STOCK);

    if (quantity > productStock)
      throw new InternalServer(OrderMessage.INSUFFICIENT_STOCK);
  }

  private void checkProductAmount(Product product, OrderDto orderDto) {

    BigDecimal amount = orderDto.getAmount();
    BigDecimal productPrice = product.getPrice();
    Integer quantity = orderDto.getQuantity();

    BigDecimal total = productPrice.multiply(BigDecimal.valueOf(quantity));

    if (amount.compareTo(total) != 0)
      throw new InternalServer(OrderMessage.AMOUNT_MISMATCH);
  }

}
package com.kipaskipas.order.comparator;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.kipaskipas.order.config.OrderMessage;
import com.kipaskipas.order.dto.OrderDto;
import com.kipaskipas.order.helper.exception.InternalServer;
import com.kipaskipas.order.model.Product;
import com.kipaskipas.order.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;

public interface ProductComparator {

  void CheckProduct(OrderDto orderDto);
}

@Service
class ProductComparatorImpl implements ProductComparator {

  @Autowired
  protected ProductRepository productRepo;

  public void CheckProduct(OrderDto orderDto) {

    String productId = orderDto.getProductId();

    Optional<Product> product = productRepo.findByIdAndIsDeletedFalse(productId);

    checkProductId(product);
    checkProductStock(product.get(), orderDto);
    checkProductAmount(product.get(), orderDto);
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

    Double amount = orderDto.getAmount();
    Double productPrice = product.getPrice();
    Integer quantity = orderDto.getQuantity();

    Double total = productPrice * quantity;

    if (amount.compareTo(total) != 0)
      throw new InternalServer(OrderMessage.AMOUNT_MISMATCH);
  }

}
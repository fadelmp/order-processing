package com.kipaskipas.order.comparator;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.kipaskipas.order.config.ProductMessage;
import com.kipaskipas.order.dto.ProductDto;
import com.kipaskipas.order.helper.CheckString;
import com.kipaskipas.order.helper.exception.InternalServer;
import com.kipaskipas.order.helper.exception.NotFound;
import com.kipaskipas.order.model.Product;
import com.kipaskipas.order.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;

public interface ProductComparator {

  void CheckId(ProductDto ProductDto);

  void CheckName(ProductDto ProductDto);
}

@Service
class ProductComparatorImpl implements ProductComparator {

  @Autowired
  protected ProductRepository productRepo;

  public void CheckId(ProductDto productDto) {

    String productId = productDto.getId();

    Optional<Product> product = productRepo.findByIdAndIsDeletedFalse(productId);

    if (!product.isPresent())
      throw new NotFound(ProductMessage.NOT_FOUND);
  }

  public void CheckName(ProductDto productDto) {

    String productId = productDto.getId();
    String productName = productDto.getName();

    Optional<Product> product = productRepo.findByNameAndIsDeletedFalse(productName);

    if (product.isPresent())
      if (CheckString.Check(product.get().getName(), productName) &&
          !product.get().getId().equals(productId))
        throw new InternalServer(ProductMessage.NAME_EXISTS);
  }

}
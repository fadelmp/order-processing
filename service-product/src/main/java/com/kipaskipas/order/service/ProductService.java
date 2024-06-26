package com.kipaskipas.order.service;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.kipaskipas.order.comparator.ProductComparator;
import com.kipaskipas.order.config.ProductMessage;
import com.kipaskipas.order.dto.ProductDto;
import com.kipaskipas.order.helper.exception.InternalServer;
import com.kipaskipas.order.mapper.ProductMapper;
import com.kipaskipas.order.model.Product;
import com.kipaskipas.order.repository.ProductRepository;

import org.hibernate.QueryException;
import org.springframework.beans.factory.annotation.Autowired;

public interface ProductService {

  void Create(ProductDto productDto);

  void Update(ProductDto productDto);

  ProductDto GetById(String productId);

  void UpdateStock(ProductDto productDto);
}

@Service
class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductMapper mapper;

  @Autowired
  private ProductComparator comparator;

  @Autowired
  private ProductRepository repository;

  public void Create(ProductDto productDto) {

    try {
      comparator.CheckName(productDto);

      Product product = mapper.ToProduct(productDto);
      repository.save(product);

      productDto.setId(product.getId());

    } catch (QueryException e) {
      // Error Handling
      System.out.println(e);
      throw new InternalServer(ProductMessage.CREATE_FAILED);
    }

  }

  public void Update(ProductDto productDto) {

    try {
      comparator.CheckId(productDto);
      comparator.CheckName(productDto);

      Product product = mapper.ToProduct(productDto);
      repository.save(product);

      productDto.setId(product.getId());

    } catch (Exception e) {
      // Error Handling
      System.out.println(e);
      throw new InternalServer(ProductMessage.UPDATE_FAILED);
    }

  }

  public ProductDto GetById(String id) {

    ProductDto productDto = new ProductDto();

    try {
      Optional<Product> productOpt = repository.findByIdAndIsDeletedFalse(id);

      productDto = (productOpt.isPresent()) ? mapper.ToProductDto(productOpt.get()) : null;

    } catch (Exception e) {
      // Error Handling
      System.out.println(e);
      throw new InternalServer(ProductMessage.INTERNAL_SERVER);
    }

    return productDto;
  }

  public void UpdateStock(ProductDto productDto) {

    try {
      Optional<Product> productOpt = repository.findByIdAndIsDeletedFalse(productDto.getId());

      Product product = productOpt.get();
      product.setStock(product.getStock() - productDto.getStock());

      repository.save(product);

    } catch (Exception e) {
      // Error Handling
      System.out.println(e);
    }
  }

}
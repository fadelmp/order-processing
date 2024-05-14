package com.kipaskipas.order.services;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.kipaskipas.order.comparator.ProductComparator;
import com.kipaskipas.order.config.ProductMessage;
import com.kipaskipas.order.dto.ProductDto;
import com.kipaskipas.order.helpers.exceptions.InternalServer;
import com.kipaskipas.order.mapper.ProductMapper;
import com.kipaskipas.order.models.Product;
import com.kipaskipas.order.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;

public interface ProductService {

  void Create(ProductDto ProductDto);

  void Update(ProductDto ProductDto);

  ProductDto GetById(String ProductId);
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

    } catch (Exception e) {
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

      productDto = (!productOpt.isPresent()) ? mapper.ToProductDto(productOpt.get()) : null;

    } catch (Exception e) {
      // Error Handling
      System.out.println(e);
      throw new InternalServer(ProductMessage.INTERNAL_SERVER);
    }

    return productDto;
  }

}
package com.kipaskipas.order.mapper;

import org.springframework.stereotype.Service;

import com.kipaskipas.order.dto.ProductDto;
import com.kipaskipas.order.models.Product;

public interface ProductMapper {

  Product ToProduct(ProductDto ProductDto);

  ProductDto ToProductDto(Product Product);
}

@Service
class ProductMapperImpl implements ProductMapper {

  public Product ToProduct(ProductDto productDto) {

    return new Product()
        .setName(productDto.getName())
        .setDescription(productDto.getDescription())
        .setPrice(productDto.getPrice())
        .setStock(productDto.getStock())
        .setCreatedBy(productDto.getCreatedBy())
        .setUpdatedBy(productDto.getUpdatedBy());
  }

  public ProductDto ToProductDto(Product product) {

    return new ProductDto()
        .setId(product.getId())
        .setName(product.getName())
        .setDescription(product.getDescription())
        .setPrice(product.getPrice())
        .setStock(product.getStock())
        .setIsActived(product.getIsActived())
        .setCreatedAt(product.getCreatedAt())
        .setCreatedBy(product.getCreatedBy())
        .setUpdatedAt(product.getUpdatedAt())
        .setUpdatedBy(product.getUpdatedBy());
  }

}
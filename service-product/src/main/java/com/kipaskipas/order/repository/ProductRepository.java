package com.kipaskipas.order.repository;

import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kipaskipas.order.models.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

  @Cacheable("product_id")
  Optional<Product> findByIdAndIsDeletedFalse(String id);

  @Cacheable("product_name")
  Optional<Product> findByNameAndIsDeletedFalse(String name);

  @Override
  @CacheEvict(value = { "product*" }, allEntries = true)
  <C extends Product> C save(C Product);

}

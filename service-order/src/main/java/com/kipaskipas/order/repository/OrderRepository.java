package com.kipaskipas.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kipaskipas.order.models.Order;

public interface OrderRepository extends JpaRepository<Order, String> {
}

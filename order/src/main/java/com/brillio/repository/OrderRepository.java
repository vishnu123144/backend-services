package com.brillio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brillio.model.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{

	Order save(Order order);

	List<Order> findByCustomerId(Long id);

}

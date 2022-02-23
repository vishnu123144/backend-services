package com.brillio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brillio.model.Order;
import com.brillio.service.OrderService;

@RestController
public class OrderController {
	
	@Value("${Server.port}")
	String port;

	@Autowired
	private OrderService serviceOrder;
	
	
	@PostMapping("saveOrder")
	public ResponseEntity<Object> saveOderDetails(@RequestBody Order order) {
		return new ResponseEntity<>(serviceOrder.saveOrder(order), HttpStatus.CREATED);
	}

	@GetMapping("findCustomer/{customerId}")
	public List<Order> getOrderDetailByCustomerId(@PathVariable("customerId") Long id) {
		return serviceOrder.findOrderByCustomerId(id);
	}
	
	@GetMapping("/load")
	public String getPortNo()
	{
		return port;
	}

}

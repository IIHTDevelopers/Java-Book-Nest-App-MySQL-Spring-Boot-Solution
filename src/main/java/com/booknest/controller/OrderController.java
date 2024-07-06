package com.booknest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booknest.dto.OrderDTO;
import com.booknest.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping
	public ResponseEntity<OrderDTO> placeOrder(@RequestBody @Valid OrderDTO orderDTO) {
		OrderDTO placedOrder = orderService.placeOrder(orderDTO);
		return ResponseEntity.ok(placedOrder);
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
		OrderDTO order = orderService.getOrderById(id);
		return ResponseEntity.ok(order);
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<OrderDTO>> getOrdersForUser(@PathVariable Long userId) {
		List<OrderDTO> orders = orderService.getOrdersForUser(userId);
		return ResponseEntity.ok(orders);
	}

	@PutMapping("/{id}/status")
	public ResponseEntity<OrderDTO> updateOrderStatus(@PathVariable Long id, @RequestParam String status) {
		OrderDTO updatedOrder = orderService.updateOrderStatus(id, status);
		return ResponseEntity.ok(updatedOrder);
	}

	@PostMapping("/{id}/payment")
	public ResponseEntity<OrderDTO> processPayment(@PathVariable Long id) {
		OrderDTO processedOrder = orderService.processPayment(id);
		return ResponseEntity.ok(processedOrder);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> cancelOrder(@PathVariable Long id) {
		orderService.cancelOrder(id);
		return ResponseEntity.noContent().build();
	}
}

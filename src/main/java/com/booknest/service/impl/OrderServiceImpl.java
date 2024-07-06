package com.booknest.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booknest.dto.OrderDTO;
import com.booknest.entity.Order;
import com.booknest.entity.OrderStatus;
import com.booknest.exception.NotFoundException;
import com.booknest.repo.OrderRepository;
import com.booknest.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public OrderDTO placeOrder(OrderDTO orderDTO) {
		Order order = modelMapper.map(orderDTO, Order.class);
		Order savedOrder = orderRepository.save(order);
		return modelMapper.map(savedOrder, OrderDTO.class);
	}

	@Override
	public OrderDTO getOrderById(Long orderId) {
		Order order = orderRepository.findOrderById(orderId)
				.orElseThrow(() -> new NotFoundException("Order not found with id " + orderId));
		return modelMapper.map(order, OrderDTO.class);
	}

	@Override
	public List<OrderDTO> getOrdersForUser(Long userId) {
		List<Order> orders = orderRepository.findByUserId(userId);
		return orders.stream().map(order -> modelMapper.map(order, OrderDTO.class)).collect(Collectors.toList());
	}

	@Override
	public OrderDTO updateOrderStatus(Long orderId, String status) {
		Order order = orderRepository.findOrderById(orderId)
				.orElseThrow(() -> new NotFoundException("Order not found with id " + orderId));
		order.setStatus(OrderStatus.valueOf(status));
		Order updatedOrder = orderRepository.save(order);
		return modelMapper.map(updatedOrder, OrderDTO.class);
	}

	@Override
	public OrderDTO processPayment(Long orderId) {
		Order order = orderRepository.findOrderById(orderId)
				.orElseThrow(() -> new NotFoundException("Order not found with id " + orderId));
		// Implement payment processing logic here
		order.setStatus(OrderStatus.COMPLETED); // Example status update
		Order updatedOrder = orderRepository.save(order);
		return modelMapper.map(updatedOrder, OrderDTO.class);
	}

	@Override
	public void cancelOrder(Long orderId) {
		Order order = orderRepository.findOrderById(orderId)
				.orElseThrow(() -> new NotFoundException("Order not found with id " + orderId));
		orderRepository.delete(order);
	}
}

package com.booknest.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import jakarta.validation.constraints.NotNull;

public class OrderDTO {

	private Long id;

	@NotNull
	private Long userId;

	@NotNull
	private Date orderDate;

	@NotNull
	private String status;

	@NotNull
	private BigDecimal totalAmount;

	@NotNull
	private Set<OrderItemDTO> items;

	public OrderDTO() {
		super();
	}

	public OrderDTO(Long id, @NotNull Long userId, @NotNull Date orderDate, @NotNull String status,
			@NotNull BigDecimal totalAmount, @NotNull Set<OrderItemDTO> items) {
		super();
		this.id = id;
		this.userId = userId;
		this.orderDate = orderDate;
		this.status = status;
		this.totalAmount = totalAmount;
		this.items = items;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Set<OrderItemDTO> getItems() {
		return items;
	}

	public void setItems(Set<OrderItemDTO> items) {
		this.items = items;
	}
}

package com.booknest.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;

public class OrderItemDTO {

	private Long id;

	@NotNull
	private Long bookId;

	@NotNull
	private Integer quantity;

	@NotNull
	private BigDecimal price;

	public OrderItemDTO() {
		super();
	}

	public OrderItemDTO(Long id, @NotNull Long bookId, @NotNull Integer quantity, @NotNull BigDecimal price) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.quantity = quantity;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}

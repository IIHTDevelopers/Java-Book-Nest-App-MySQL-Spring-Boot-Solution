package com.booknest.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.booknest.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	@Query("SELECT o FROM Order o WHERE o.user.id = :userId")
	List<Order> findByUserId(@Param("userId") Long userId);

	@Query("SELECT o FROM Order o WHERE o.id = :orderId")
	Optional<Order> findOrderById(@Param("orderId") Long orderId);

	@Query("SELECT o FROM Order o WHERE o.status = :status")
	List<Order> findByStatus(@Param("status") String status);
}
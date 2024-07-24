package com.example.StatsCollector.repository;

import com.example.StatsCollector.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}

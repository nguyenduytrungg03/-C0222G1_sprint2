package com.demo.repository;

import com.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepo extends JpaRepository<Product, Integer> {
}

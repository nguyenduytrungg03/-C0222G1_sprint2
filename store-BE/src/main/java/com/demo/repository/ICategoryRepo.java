package com.demo.repository;

import com.demo.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface ICategoryRepo extends JpaRepository<Category ,Integer> {
    @Query(value = " SELECT * FROM category", nativeQuery = true)
    List<Category> getAllCategory();
}

package com.praveen.financialtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.praveen.financialtracker.model.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

	Category findByCategoryName(String categoryName);
}

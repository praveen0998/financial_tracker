package com.praveen.financialtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.praveen.financialtracker.model.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{

}

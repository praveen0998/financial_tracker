package com.praveen.financialtracker.model;

import java.time.Instant;

import com.praveen.financialtracker.model.entity.Category;
import com.praveen.financialtracker.model.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseModel {
	
	private Long id;
	private Instant expenseDate;
	private String expenseDescription;
	private Category category;
	private User user;

}

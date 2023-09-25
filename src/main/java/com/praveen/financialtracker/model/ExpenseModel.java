package com.praveen.financialtracker.model;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseModel {
	
	private Long id;
	private String expenseDate;
	private String expenseDescription;
	private CategoryModel category;
	private UserModel user;

}

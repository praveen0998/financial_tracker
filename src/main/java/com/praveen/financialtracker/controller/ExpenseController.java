package com.praveen.financialtracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praveen.financialtracker.model.ExpenseModel;
import com.praveen.financialtracker.model.UserModel;
import com.praveen.financialtracker.service.ExpenseService;

@RestController
@RequestMapping("/financial")
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;

	@GetMapping(value = "/expense/{expenseId}")
	public ResponseEntity<ExpenseModel> getAllExpenseDetails(@PathVariable Long expenseId) {
		return ResponseEntity.ok().body(expenseService.fetchExpense(expenseId));
	}

	@PostMapping(value = "/save/expense")
	public ResponseEntity<ExpenseModel> saveExpense(@RequestBody ExpenseModel expenseModel) {
		return ResponseEntity.ok().body(expenseService.saveExpense(expenseModel));
	}

	@PutMapping(value = "/update/expense")
	public ResponseEntity<ExpenseModel> updateExpense(@RequestBody ExpenseModel userModel) {
		return ResponseEntity.ok().body(expenseService.updateExpense(userModel));
	}

	@DeleteMapping(value = "/delete/expense/{expenseId}")
	public ResponseEntity<ExpenseModel> deleteExpense(@PathVariable Long expenseId) {
		expenseService.deleteExpense(expenseId);
		return ResponseEntity.ok().build();
	}

}

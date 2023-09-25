package com.praveen.financialtracker.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praveen.financialtracker.model.CategoryModel;
import com.praveen.financialtracker.model.ExpenseModel;
import com.praveen.financialtracker.model.UserModel;
import com.praveen.financialtracker.model.entity.Category;
import com.praveen.financialtracker.model.entity.Expense;
import com.praveen.financialtracker.model.entity.User;
import com.praveen.financialtracker.repository.ExpenseRepository;

@Service
public class ExpenseService {

	@Autowired
	ExpenseRepository expenseRepository;

	public ExpenseModel fetchExpense(Long id) {
		Optional<Expense> expenseOptional = expenseRepository.findById(id);
		ExpenseModel expenseModel = new ExpenseModel();

		if (expenseOptional.isPresent()) {
			Expense expense = expenseOptional.get();

			BeanUtils.copyProperties(expense, expenseModel);
			if (expense.getCategory() != null) {
				CategoryModel categoryModel = new CategoryModel();
				BeanUtils.copyProperties(expense.getCategory(), categoryModel);
				expenseModel.setCategory(categoryModel);
			}

			if (expense.getUser() != null) {
				UserModel userModel = new UserModel();
				BeanUtils.copyProperties(expense.getUser(), userModel);
				expenseModel.setUser(userModel);
			}
		}

		return expenseModel;
	}

	public ExpenseModel saveExpense(ExpenseModel expense) {
		Expense expenseEntity = new Expense();
		expenseEntity.setExpenseDate(expense.getExpenseDate());
		expenseEntity.setExpenseDescription(expense.getExpenseDescription());
		Category category = new Category();
		BeanUtils.copyProperties(expense.getCategory(), category);
		expenseEntity.setCategory(category);
		User user = new User();
		BeanUtils.copyProperties(expense.getUser(), user);
		expenseEntity.setUser(user);
		expenseEntity = expenseRepository.save(expenseEntity);
		BeanUtils.copyProperties(expenseEntity, expense);
		CategoryModel categoryModel = new CategoryModel();
		BeanUtils.copyProperties(expenseEntity.getCategory(), categoryModel);
		expense.setCategory(categoryModel);
		UserModel userModel = new UserModel();
		BeanUtils.copyProperties(expenseEntity.getUser(), userModel);
		expense.setUser(userModel);
		return expense;
	}

	public ExpenseModel updateExpense(ExpenseModel expenseModel) {
		Expense expense = new Expense();
		BeanUtils.copyProperties(expenseModel, expense);
		Optional<Expense> expenseById = expenseRepository.findById(expenseModel.getId());

		if (expenseById.isPresent()) {
			expense = expenseById.get();
			// user.setCategory(userModel.getCategory());
			expense.setExpenseDate(expenseModel.getExpenseDate());
			expense.setExpenseDescription(expenseModel.getExpenseDescription());
			Category category = new Category();
			BeanUtils.copyProperties(expenseModel.getCategory(), category);
			expense.setCategory(category);
			User user = new User();
			BeanUtils.copyProperties(expenseModel.getUser(), user);
			expense.setUser(user);
			expense = expenseRepository.save(expense);
			BeanUtils.copyProperties(expense, expenseModel);
		}
		return expenseModel;
	}

	public void deleteExpense(Long id) {
		Optional<Expense> expenseById = expenseRepository.findById(id);

		if (expenseById.isPresent()) {
			expenseRepository.delete(expenseById.get());
		}
	}

}

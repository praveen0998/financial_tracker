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

import com.praveen.financialtracker.model.CategoryModel;
import com.praveen.financialtracker.service.CategoryService;


@RestController
@RequestMapping("/financial")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(value = "/categories")
	public ResponseEntity<List<CategoryModel>> getAllCategoriesDetails()
	{
		return ResponseEntity.ok().body(categoryService.fetchCategory());
	}
	
	@PostMapping(value = "/save/category")
	public ResponseEntity<CategoryModel> saveCategory(@RequestBody CategoryModel categoryModel)
	{
		return ResponseEntity.ok().body(categoryService.saveCategory(categoryModel));
	}
	
	@PutMapping(value = "/update/category")
	public ResponseEntity<CategoryModel> updateCategory(@RequestBody CategoryModel categoryModel)
	{
		return ResponseEntity.ok().body(categoryService.updateCategory(categoryModel));
	}
	
	@DeleteMapping(value = "/delete/category/{catergoryId}")
	public ResponseEntity<CategoryModel> deleteCategory(@PathVariable Long catergoryId)
	{
		categoryService.deleteCategory(catergoryId);
		return ResponseEntity.ok().build();
	}

}

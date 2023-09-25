package com.praveen.financialtracker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praveen.financialtracker.model.CategoryModel;
import com.praveen.financialtracker.model.UserModel;
import com.praveen.financialtracker.model.entity.Category;
import com.praveen.financialtracker.model.entity.User;
import com.praveen.financialtracker.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	public List<CategoryModel> fetchCategory()
	{
		List<Category> categories = categoryRepository.findAll();
		List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();
		for(Category category : categories)
		{
			CategoryModel categoryModel = new CategoryModel();
			BeanUtils.copyProperties(category, categoryModel);
			categoryModelList.add(categoryModel);
		}
		
		return categoryModelList;
	}
	
	public CategoryModel saveCategory(CategoryModel categoryModel)
	{
		Category category = new Category();
		BeanUtils.copyProperties(categoryModel, category);
		category = categoryRepository.save(category);
		BeanUtils.copyProperties(category, categoryModel);
		return categoryModel;
	}
	
	public CategoryModel updateCategory(CategoryModel categoryModel)
	{
		Category category = new Category();
		BeanUtils.copyProperties(categoryModel, category);
		Optional<Category> categoryById = categoryRepository.findById(categoryModel.getId());
		
		if(categoryById.isPresent()) 
		{
			category = categoryById.get();
			category.setCategoryName(categoryModel.getCategoryName());
			category = categoryRepository.save(categoryById.get());
			BeanUtils.copyProperties(category, categoryModel);
		}
		return categoryModel;
	}
	
	public void deleteCategory(Long id)
	{
		Optional<Category> categoryById = categoryRepository.findById(id);
		
		if(categoryById.isPresent()) 
		{
			categoryRepository.delete(categoryById.get());
		}
	}

}

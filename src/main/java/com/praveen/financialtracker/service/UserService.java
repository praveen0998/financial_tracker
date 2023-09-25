package com.praveen.financialtracker.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
import com.praveen.financialtracker.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public List<UserModel> fetchUsers() {
		List<User> userList = userRepository.findAll();
		List<UserModel> userModelList = new ArrayList<UserModel>();
		for (User user : userList) {
			UserModel userModel = new UserModel();
			userModel.setId(user.getId());
			userModel.setUserEmailId(user.getUserEmailId());
			userModel.setUserName(user.getUserName());
			userModelList.add(userModel);
		}

		return userModelList;
	}

	public UserModel fetchUserById(Long id) {
		Optional<User> userOptional = userRepository.findById(id);
		UserModel userModel = new UserModel();

		if (userOptional.isPresent()) {
			User user = userOptional.get();
			BeanUtils.copyProperties(user, userModel);
		}

		return userModel;
	}

	public UserModel saveUser(UserModel userModel) {
		User user = new User();
		BeanUtils.copyProperties(userModel, user);
		user = userRepository.save(user);
		BeanUtils.copyProperties(user, userModel);
		return userModel;
	}

	public UserModel updateUser(UserModel userModel) {
		User user = new User();
		BeanUtils.copyProperties(userModel, user);
		Optional<User> userById = userRepository.findById(userModel.getId());

		if (userById.isPresent()) {
			user = userById.get();
			// user.setCategory(userModel.getCategory());
			user.setUserEmailId(userModel.getUserEmailId());
			user.setUserName(userModel.getUserName());
			user = userRepository.save(user);
			BeanUtils.copyProperties(user, userModel);
		}
		return userModel;
	}

	public void deleteUser(Long id) {
		Optional<User> userById = userRepository.findById(id);

		if (userById.isPresent()) {
			userRepository.delete(userById.get());
		}
	}

}

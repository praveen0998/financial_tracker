package com.praveen.financialtracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

	private Long id;
	private String userName;
	private String userEmailId;

}

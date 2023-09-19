package com.praveen.financialtracker.model.entity;

import java.util.Set;

import org.springframework.aot.generate.GeneratedTypeReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="USER_ID")
	private Long id;
	@Column(name="USER_NAME")
	private String userName;
	@Column(name="USER_EMAIL")
	private String userEmailId;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<Category> category;

}

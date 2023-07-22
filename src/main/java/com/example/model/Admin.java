package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ADMIN")
public class Admin {
	
	@Id
	private int id;
	private String userNmae;
	private String password;
	private String email;
	public Admin(int id, String userNmae, String password, String email) {
		super();
		this.id = id;
		this.userNmae = userNmae;
		this.password = password;
		this.email = email;
	}
	
	

}

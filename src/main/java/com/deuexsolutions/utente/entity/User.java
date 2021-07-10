package com.deuexsolutions.utente.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes= "ID of the user", name= "userId", required= false, value= "123456")
	private Long userId;
	@ApiModelProperty(notes= "First name of the user", name= "firstName", required= true, value= "Abhishek")
	private String firstName;
	@ApiModelProperty(notes= "Last name of the user", name= "lastName", required= true, value= "Sharma")
	private String lastName;
	@ApiModelProperty(notes= "Email ID of the user", name= "email", required= true, value= "abhishek@email.com")
	private String email;
	
	
}

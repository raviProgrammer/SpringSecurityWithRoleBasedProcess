package com.ravi.entity;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String firstName;
	    private String lastName;
	    private String gender;
	    private String email;
		private Long contactNumber;
		private String designation;
		private String department;
		private String address;
		private Double salary;
	    private LocalDate dateOfJoining;
	    private String username;
	    private String password;
	    
	    @Enumerated(EnumType.STRING)
		private Role role;
}

package com.java.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity(name="SFUser")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue
	int user_id;
	String firstName;
	String lastName;
	@Column(unique = true)
	String email;
	String password;

	@Override
	public String toString() {
		return "User: " + firstName + " " + lastName + "\nEmail: " + email + "\n";
	}
}

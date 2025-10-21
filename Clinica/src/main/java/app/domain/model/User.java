package app.domain.model;

import app.domain.model.Enum.Role;
import app.domain.valueobject.*;

public class User {
	private long id;
	private String name;
	private String password;
	private int age;
	private Role role;
	private String username;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void changePassword(String newPassword) {
		this.password = newPassword;
	}

	public void changeRole(Role newRole) {
		this.role = newRole;
	}
}

package com.revature.ers.models;

public class Employee {
	
	private String name;
	private String position;
	private int id;
	private String username;
	private String password;
	
	public Employee(String name, String position, int id, String username, String password) {
		super();
		this.name = name;
		this.position = position;
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", position=" + position + ", id=" + id + ", username=" + username
				+ ", password=" + password + "]";
	}

}

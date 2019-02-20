package com.selasi.qm.Models;

import com.selasi.qm.Database.Database;

public class Student {

	private int id;
	
	 Database db = new Database();

	
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		
		return name;
		
	}

	public void setName(String name) {
		this.name = name;
	}
}

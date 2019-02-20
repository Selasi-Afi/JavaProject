package com.selasi.qm.Models;

import java.util.HashMap;
import java.util.Map;

import com.selasi.qm.Database.Database;

public class MCQChoice {
	
	private int id;
	
	//CREATE TABLE CHOICE (ID INT PRIMARY KEY, LABEL VARCHAR(255), VALID BOOLEAN, QUESTIONID INT);
	

	private Database db;


	
	private String label;
	
	

	private MCQQuestion question;

	private boolean valid;

	public MCQChoice() {
		super();
		this.db = new Database();
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public MCQQuestion getQuestion() {

			return question;
		
	}

	public void setQuestion(MCQQuestion question) {
		this.question = question;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}

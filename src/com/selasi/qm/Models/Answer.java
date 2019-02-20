package com.selasi.qm.Models;

import java.util.HashMap;
import java.util.Map;

import com.selasi.qm.Database.Database;

public class Answer {

	private String text;
	
	private Question question;

	private Database db;
	
	
	
	public Answer() {
		super();
		this.db = new Database();
	}

	public Answer(String text) {
		super();
		this.text = text;
	}

	public String getText() {
		return text;
		
	}

	public void setText(String text) {
		this.text = text;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	
}

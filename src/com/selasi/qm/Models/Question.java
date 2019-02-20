package com.selasi.qm.Models;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.selasi.qm.Database.Database;

public class Question {

	// CREATE TABLE QUESTION (ID INT PRIMARY KEY, LABEL VARCHAR(255));

	private int id;

	private String question;

	private String[] topics;

	private int difficulty;
	
	private Database db;

	public Question() {
		super();
		this.db = new Database();
	
	}

	public Question(String question) {
		super();
		this.question = question;
	}

	public String getQuestion() {
		
// get question and append it to an array
		
	  Map<String, String[]> condition = new HashMap<String, String[]>();

      condition.put("QUESTION", new String[] {"=", "QUESTION"});

      String[] fields = {"ID,QUESTION"};
    

      String[][] result = db.select("QUESTIONS", fields, condition);
		return question;
		
		
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String[] getTopics() {
		//THE TOPICS CODE GOES HERE
		
		
    
		
		return topics;
	}

	public void setTopics(String[] topics) {
		this.topics = topics;
	}

	public int getDifficulty() {
		//THE DIFFICULTY CODE GOES HERE
		
		Map<String, String[]> condition = new HashMap<String, String[]>();
    	condition.put("QUESTION", new String[] {"=", question});
    	String[] fields = { "DIFFICULTY"};
     
    	String[][] result = db.select("QUESTIONS", fields, condition);
    	int difficulty = Integer.parseInt(result[0][0]);
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", topics=" + Arrays.toString(topics) + ", difficulty="
				+ difficulty + "]";
	}
	

}

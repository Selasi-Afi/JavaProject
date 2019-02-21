package com.selasi.qm.Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.selasi.qm.Database.Database;

public class Question {

	// CREATE TABLE QUESTION (ID INT PRIMARY KEY, LABEL VARCHAR(255));

	private int id;

	private String question;

	private String topics;

	private int difficulty;
	
	private Database db;

	private String type;

	private String choice1;

	private String choice2;
	
	private String choice3;

	private String choice4;

	private List<Question> list = new ArrayList<>();;

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
		
//	  Map<String, String[]> condition = new HashMap<String, String[]>();
//
//      condition.put("QUESTION", new String[] {"=", "QUESTION"});
//
//      String[] fields = {"ID,QUESTION"};
//    
//
//      String[][] result = db.select("QUESTIONS", fields, condition);
		return question;
		
		
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getTopics() {
		//THE TOPICS CODE GOES HERE
		
		
    
		
		return topics;
	}

	public void setTopics(String topics) {
		this.topics = topics;
	}

	public int getDifficulty() {
		//THE DIFFICULTY CODE GOES HERE
		
//		Map<String, String[]> condition = new HashMap<String, String[]>();
//    	condition.put("QUESTION", new String[] {"=", question});
//    	String[] fields = { "DIFFICULTY"};
//     
//    	String[][] result = db.select("QUESTIONS", fields, condition);
//    	int difficulty = Integer.parseInt(result[0][0]);
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public int getId() {
		return id;
	}


	public List<Question> getList() {
		return list;
	}

	public void setList(List<Question> list) {
		this.list = list;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
		//THE
	}
	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}

	public String getChoice1() {
		return  choice1;
		//THE
	}
	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}

	public String getChoice2() {
		return  choice2;
		//THE
	}
	public void setChoice3(String choice3) {
		this.choice3 = choice3;
	}

	public String getChoice3() {
		return  choice3;
		//THE
	}
	public void setChoice4(String choice3) {
		this.choice4 = choice4;
	}

	public String getChoice4() {
		return  choice3;
		//THE
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", topics=" + (topics) + ", difficulty="
				+ difficulty+",type=" + type + ", choice1" +choice1+", choice2" + choice2 +", choice3" + choice3 + ", choice4" + choice4 + "]";
	}
	
	public String toQuestion() {
		return question + "\n" + "1) " + choice1 + "\n" + "2) " + choice2 + "\n" + "3) " + choice3 + "\n" + "4) " + choice2;
	}
	

}

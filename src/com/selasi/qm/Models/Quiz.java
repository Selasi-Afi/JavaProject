package com.selasi.qm.Models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.selasi.qm.Database.Database;

public class Quiz {
    private String title;
    
	private Database db;


    private List<Question> listQuestions;
    
    Question question = new Question();

    MCQChoice mcqchoice= new MCQChoice();
    
    public Quiz() {
		super();
		this.db = new Database();
	}

   

    public String getTitle() {
    	 Map<String, String[]> condition = new HashMap<String, String[]>();

         condition.put("TITLE", new String[] {"=", "TITLE"});

         String[] fields = {"TITLE"};
       

         String[][] result = db.select("QUIZ", fields, condition);
   		
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getListQuestions() {
    	question.getQuestion();
    	mcqchoice.getId();
    	
        return listQuestions;
        
        
    }

    public void setListQuestions(List<Question> listQuestions) {
        this.listQuestions = listQuestions;
    }

  


}

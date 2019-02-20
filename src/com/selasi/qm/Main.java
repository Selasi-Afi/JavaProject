package com.selasi.qm;
/**
 * 
 */


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.selasi.qm.Models.Question;



import com.selasi.qm.Database.Database;

//import java.util.HashMap;

import java.util.Map;



public class Main {
	public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
    	
   	 Database db = new Database();

   	 String verification = db.Login();
   	 Scanner  scanner = new Scanner(System.in);
   	
		  

   	 if (verification.equalsIgnoreCase("student")) {
   		int studentBlock= scanner.nextInt();
   		
   	 }
   	 else if (verification.equalsIgnoreCase("admin")){
   		//Scanner  scanner = new Scanner(System.in);
   		 
   		 System.out.println("Please enter 1 for Create, 2 for Update, 3 for update and 4 for Delete");
   		 String adminBlock= scanner.nextLine();
   		 
//   		 System.out.println("Please enter the table you want to edit");
//   		 String table = scanner.nextLine();

   		
   		 switch(Integer.parseInt(adminBlock)) {
   		 
   		
		 case 1:
			 	
				System.out.println("Please enter your ID");
				String id= input.nextLine();
				System.out.println("Please enter your question");
				String question= input.nextLine();
				System.out.println("Please enter your desired difficulty");
				String difficulty = input.nextLine();
				System.out.println("Please enter your desired type");
				String type = input.nextLine();
				System.out.println("Please enter your possible answer a");
				String a1= input.nextLine();
				System.out.println("Please enter your possible answer b");
				String a2= input.nextLine();
				System.out.println("Please enter your possible answer c");
				String a3 = input.nextLine();
				System.out.println("Please enter your possible answer d");
				String a4 = input.nextLine();

				db.insert(id,question,difficulty,type,a1,a2,a3,a4);
				
				break;
				
					
				
   	 		    
		  case 2:
//			  
			  System.out.println("Please enter the ID for the tab you want to modify");
			  String updateID = input.nextLine();
			  Integer ID = Integer.parseInt(updateID);
			  Question updateQuestion = new Question();
			  updateQuestion.setId(ID);
			  System.out.println("Please enter the column you want to edit");
			  List<Question> details = new ArrayList<>();
			  details = db.search(updateQuestion);
			  updateQuestion.setQuestion(details.get(0).getQuestion());
			  updateQuestion.setDifficulty(details.get(0).getDifficulty());
			  updateQuestion.setChoice1(details.get(0).getChoice1());
			  updateQuestion.setChoice2(details.get(0).getChoice2());
			  updateQuestion.setChoice3(details.get(0).getChoice3());
			  updateQuestion.setChoice4(details.get(0).getChoice4());
			  
			  updateQuestion.setList(details);
			  Question newQuestions = new Question();
			  newQuestions = updateQuestion;
			  String updateColumn=input.nextLine();
			  
			  switch(Integer.parseInt(updateColumn)){
			  case 1: 
				  System.out.println("Enter the new question");
				   String newQuestion=scanner.nextLine();
				  newQuestions.setQuestion(newQuestion);
				  
				  db.update(newQuestions);
			break;
			  case 2: 
				  System.out.println("Enter the new difficulty");
				   String newDifficulty=scanner.nextLine();
				 
				  newQuestions.setDifficulty(Integer.parseInt(newDifficulty));
				  db.update(newQuestions);
			break;
			  case 3: 
				  System.out.println("Enter the new choice a");
				   String newChoicea=scanner.nextLine();
				  newQuestions.setChoice1(newChoicea);
				  db.update(newQuestions);
			break;
			  case 4: 
				  System.out.println("Enter the new choice b");
				   String newChoiceb=scanner.nextLine();
				  newQuestions.setChoice2(newChoiceb);
				  db.update(newQuestions);
			break;
			  case 5: 
				  System.out.println("Enter the new choice c");
				   String newChoicec=scanner.nextLine();
				  newQuestions.setChoice3(newChoicec);
				  db.update(newQuestions);
			break; 
			  case 6: 
				  System.out.println("Enter the new choice d");
				   String newChoiced=scanner.nextLine();
				  newQuestions.setChoice3(newChoiced);
				  db.update(newQuestions);
			break; 
				}
			  
			  
			 
			  break;

			  
			 
		
		  case 3:
			  System.out.println("Enter the question ID of the question to be read");
			  String response = scanner.nextLine();
			  Integer QID = Integer.parseInt(response);
			  Question readQuestion = new Question();
			  readQuestion.setId(QID);
			  List<Question> readList = new ArrayList<>();
			  readList = db.search(readQuestion);
			  System.out.println("The question details are");
			  for(int i=0;i<readList.size();i++)
			  {
				  System.out.println(readList.get(i).toString());
			  }
			  break;
			  
		  case 4:
			  System.out.println("Enter the question ID of the question to be deleted");
			  String resp = scanner.nextLine();
			  Integer qid = Integer.parseInt(resp);
			  Question delQuestion = new Question();
			  delQuestion.setId(qid);
			  db.delete(delQuestion);
			  
			  break;

 }
    }}
}

package com.selasi.qm;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
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
   		 
   		 System.out.println("Please enter 1 for Create, 2 for Read, 3 for update and 4 for Delete");
   		 int adminBlock= scanner.nextInt();
   		 
//   		 System.out.println("Please enter the table you want to edit");
//   		 String table = scanner.nextLine();

   		
   		 switch(adminBlock) {
   		 
   		
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
				
				}
					//db.insert(id, question, difficulty, type)
				}
   	 }
//			 
//			 break;
//		    
//		  case 2:
//			  String fun_table = scanner.nextLine();
//			  db.select(fun_table);
//			  break;
//		
//		  case 3:
//			  String querry_table = scanner.nextLine();
//			  db.update(querry_table);
//			  break;
//		  case 4:
//			  String del_table = scanner.nextLine();
//			  db.delete(del_table); 
//			  break;
//	   	  default:
//	   		  System.out.println("Invalid Option");
//   		  }
//   	 }
//   	 else {
//   		 System.out.println("You are not welcome");
//    
//   	 }
   	 
   	 

// write your code here
//    	Scanner  scanner = new Scanner(System.in);
//    	
//    	int qNum;
//    	
//    	String array[] = new String[10];
//    	int i;
//    
//    	while( !array[i].equals ("0")) {
//    	
//    		System.out.println( "Please enter your desired topics. Type 0 to end");
//    		array[i]= scanner.nextLine();
//    		
//    		
//    	}
    	
//    	System.out.println("How many questions would you like");
//    	qNum=scanner.nextInt();
//    	
//    	for (int t=0; t<10; t++) {
//			System.out.println(array[t]);
//		}
//    	Database db = new Database();
//    	
//    	Map<String, String[]> condition = new HashMap<String, String[]>();
//
//    	condition.put("TOPIC", new String[] {"=", "array[]"});
//
//    	String[] fields = {"QUESTIONS", "DIFFICULTY"};
//    	int diffPerTopic = 0;
		
		//diffPerTopic = qNum/array.length;
//     
    	//for(int i =0; i <0 ; i++) {
    		
    		
    		
    		
    	//}
    	
    	
    
    		
    	




//
//        Map<String, String> insertData = new HashMap<String, String>();
//
//       insertData.put("ID", "5");
//
//       insertData.put("NAME", "Jacques");
//
//       
//
//
//
//       db.insert("STUDENT", insertData);
//
//







//        Map<String, String> change = new HashMap<String, String>();

//        change.put("NAME", "Anwti-Boateng");

//        change.put("age", "34");

//

//        Map<String, String[]> condition = new HashMap<String, String[]>();

//        condition.put("firstname", new String[] {"=", "Kojo"});

//        condition.put("ID", new String[] {"=", "4"});

//

//        db.update("STUDENT", change, condition);

        

//        db.delete("STUDENT", condition);



//        Map<String, String[]> condition = new HashMap<String, String[]>();

//        condition.put("TOPIC", new String[] {"=", "ADDITION"});

//        String[] fields = {"QUESTIONS", "DIFFICULTY"};

//       

//        String[][] result = db.select("QUESTIONS", fields, condition);

//        result[0][0];
    	
//    	System.out.println("");



//    Question q1 = new Question();
//
//    q1.setQuestion("WHAT IS AN ANIMAL?");
//
//    System.out.print(q1.getDifficulty());
//    
//    String[] s = q1.getTopics();
//    
//    for (int x = 0; x < s.length; x++){
//		System.out.print(s[x]);
//	}
    
//    BufferedWriter writer = null;
//    try {
//        //create a temporary file
//        String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
//        File logFile = new File("Quizes/" + "quiz_" + timeLog + ".txt");
//
//        // This will output the full path where the file will be written to...
//        System.out.println(logFile.getCanonicalPath());
//
//        writer = new BufferedWriter(new FileWriter(logFile));
//        writer.write("Hello world!");
//    } catch (Exception e) {
//        e.printStackTrace();
//    } finally {
//        try {
//            // Close the writer regardless of what happens...
//            writer.close();
//        } catch (Exception e) {
//        }
//    }
//
 }

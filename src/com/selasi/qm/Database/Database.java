package com.selasi.qm.Database;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import com.selasi.qm.Models.Question;



public class Database {

    private Connection dbconnect;
    private PreparedStatement ps;
    private Properties properties;
	private static final String SEARCH_QUERY = "SELECT * FROM QUESTIONS WHERE ID = ?";
	private static final String UPDATE_QUERY = "UPDATE QUESTIONS SET QUESTION=?,DIFFICULTY=?,CHOICE1=?,CHOICE2=?,CHOICE3=?,CHOICE4=? WHERE ID=?";
	private static final String DELETE_QUERY = "DELETE  from QUESTIONS where ID =?";
	private static final String DELETEQuestion_QUERY = "DELETE  from topic where QUESTIONID =?";
	private static final String QUIZ_Query = "SELECT * FROM TOPIC JOIN QUESTIONS WHERE  TOPIC.TOPICTYPE = ? ORDER BY RAND() LIMIT 3";


    public Database() {
        File file = new File("config/db.properties");
        properties = new Properties();

        try {
            properties.load(new FileInputStream(file));

            if (properties.get("DB_TYPE").toString().matches("H2")) {
                
                String URL = properties.get("URL").toString();
                String USERNAME = properties.get("USERNAME").toString();
                String PASSWORD = properties.get("PASSWORD").toString();
                Class.forName("org.h2.Driver");
                this.dbconnect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }



    private String conditions(Map<String, String[]> condition) {
        StringBuilder conditions;
        conditions = new StringBuilder(" ");

        int size = condition.size();
        if (size == 1) {
            conditions.append(condition.keySet().toArray()[0]).append(" ").append(condition.get(condition.keySet().toArray()[0])[0]).append(" ? ");
        } else {
            conditions.append(condition.keySet().toArray()[0]).append(" ").append(condition.get(condition.keySet().toArray()[0])[0]).append(" ?");
            for (int i = 1; i < size; i++) {
                if (i < size - 1) {
                    conditions.append(", ").append(condition.keySet().toArray()[i]).append(" ").append(condition.get(condition.keySet().toArray()[i])[0]).append(" ?");
                } else {
                    conditions.append(" AND ").append(condition.keySet().toArray()[i]).append(" ").append(" " + condition.get(condition.keySet().toArray()[i])[0]).append(" ? ");
                }
            }
        }
        return conditions.toString();
    }

    private void buildBindParam(Map<String, String[]> condition) {
        int size = condition.size();
        try {
            for (int i = 0; i < size; i++) {
                this.ps.setString(i + 1, condition.get(condition.keySet().toArray()[i])[1]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public boolean insert(String id, String question, String difficulty,String type,String a1,String a2,String a3,String a4) {
        boolean success = false;


        String sql = "INSERT INTO QUESTIONS VALUES (?,?,?,?,?,?,?,?)";

        try {
        	// commit test
            ps = dbconnect.prepareStatement(sql);
            ps.setString (1, id);
            ps.setString (2, question);

			ps.setString (3, difficulty);
			ps.setString (4, type);
			ps.setString (5, a1);
            ps.setString (6, a2);

			ps.setString (7, a3);
			ps.setString (8, a4);
			
		
			int result = ps.executeUpdate();
						
			

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }
    


    public void update(Question question) {
		try {
			PreparedStatement ps = dbconnect.prepareStatement(UPDATE_QUERY);
			System.out.println("-------");
			System.out.println(question.getQuestion());
			System.out.println(question.getDifficulty());
			System.out.println(question.getChoice1());
			System.out.println(question.getChoice2());
			System.out.println(question.getChoice3());
			System.out.println(question.getChoice4());
			System.out.println(question.getId());
			System.out.println("-------");
			ps.setString(1, question.getQuestion());
			ps.setInt(2, question.getDifficulty());
			ps.setString(3, question.getChoice1());
			ps.setString(4, question.getChoice2());
			ps.setString(5, question.getChoice3());
			ps.setString(6, question.getChoice4());
			ps.setInt(7, question.getId());
			int check = ps.executeUpdate();
			boolean isUpdated = (check > 0);
			if(isUpdated)
				System.out.println("Question successfully comments");
			else
				System.out.println("Question not successfully updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


    public void delete(Question question) {
		try {
			PreparedStatement ps = dbconnect.prepareStatement(DELETEQuestion_QUERY);
			ps.setInt(1, question.getId());
			ps.execute();
			ps.close();
			PreparedStatement sp = dbconnect.prepareStatement(DELETE_QUERY);
			sp.setInt(1, question.getId());
			sp.execute();
			sp.close();
			//connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    

   
    public List<Question> search(Question question) {
		List<Question> questions = new ArrayList<>();
		try {
            PreparedStatement ps = dbconnect.prepareStatement(SEARCH_QUERY);
			ps.setInt(1, question.getId());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Question currentQuestion = new Question();
				currentQuestion.setId(rs.getInt("ID"));
				currentQuestion.setQuestion(rs.getString("QUESTION"));
				currentQuestion.setDifficulty(rs.getInt("DIFFICULTY"));
				currentQuestion.setType(rs.getString("TYPE"));
				currentQuestion.setChoice1(rs.getString("CHOICE1"));
				currentQuestion.setChoice2(rs.getString("CHOICE2"));
				currentQuestion.setChoice3(rs.getString("CHOICE3"));
				currentQuestion.setChoice4(rs.getString("CHOICE4"));
				questions.add(currentQuestion);
			}
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return questions;
	}

    public List<Question> getQuiz(Question question) {
		List<Question> questions = new ArrayList<>();
//		String topicStr = "";
//		for(int i = 0; i < topics.size(); i++) {
//			if(i == (topics.size() - 1)) {
//				topicStr += "TOPIC.TOPICTYPE=" + topics + ")";
//			}else {
//				topicStr += "TOPIC.TOPICTYPE=" + topics + " OR ";
//			}
//		}
//		String searchQuery = "";
//		if(topicStr == "") {
//			searchQuery = QUIZ_Query + " ORDER BY RAND() LIMIT 10;";
//		}else {
//			searchQuery = QUIZ_Query + " AND ("+ topicStr + " ORDER BY RAND() LIMIT 10;";
//		}
		try {
            PreparedStatement ps = dbconnect.prepareStatement(QUIZ_Query);
            ps.setString(1, question.getTopics());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Question currentQuestion = new Question();
				currentQuestion.setQuestion(rs.getString("QUESTION"));
				currentQuestion.setChoice1(rs.getString("CHOICE1"));
				currentQuestion.setChoice2(rs.getString("CHOICE2"));
				currentQuestion.setChoice3(rs.getString("CHOICE3"));
				currentQuestion.setChoice4(rs.getString("CHOICE4"));
				questions.add(currentQuestion);
			}
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return questions;
	}
    
    public String Login() {
    	
		String type ="Incorrect";
    	
    		try {
    			
    			Scanner  scanner = new Scanner(System.in); 
    			System.out.println("Please enter your username");
    			String username= scanner.nextLine();
    			System.out.println("Please enter your password");
    			String password = scanner.nextLine();
    			
    			String SQL= "SELECT * FROM LOGIN where  NAME =? and PASSWORD=? ";
    	
    			PreparedStatement stmt = dbconnect
    					.prepareStatement(SQL);
    			stmt.setString (1, username);
    			stmt.setString (2, password);

    			
    			System.out.println("Statment: " + stmt);
    			
    			ResultSet rs = stmt.executeQuery();
    			
    			
    			while(rs.next()) {
    				 type = rs.getString("TYPE");
    				
    				
    			}
    			
    			stmt.close();
    		
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
			System.out.println("Type of login: " + type);
			return type;
 
    	
    }
    
    

}



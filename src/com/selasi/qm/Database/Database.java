package com.selasi.qm.Database;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;


public class Database {

    private Connection dbconnect;
    private PreparedStatement ps;
    private Properties properties;

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


    public boolean insert(String id, String question, String difficulty,String type) {
        boolean success = false;

//        StringBuilder fields, questionMarks;
//        fields = new StringBuilder(" (");
//        questionMarks = new StringBuilder(" values(");
//        int size = dictionary.size();
//        for (int i = 0; i < size; i++) {
//            if (i < size - 1) {
//                fields.append(dictionary.keySet().toArray()[i]).append(", ");
//                questionMarks.append("?, ");
//            } else {
//                fields.append(dictionary.keySet().toArray()[i]).append(")");
//                questionMarks.append("?)");
//            }
//        }

        String sql = "INSERT INTO QUESTIONS ID, QUESTION, DIFFICULTY, TYPE VALUES (?,?,?,?)";

        try {
        	// commit test
            ps = dbconnect.prepareStatement(sql);
            ps.setString (1, id);
            ps.setString (2, question);

			ps.setString (3, difficulty);
			ps.setString (4, type);
			
		
			int rs = ps.executeUpdate();
						
			

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }


    public boolean update(String table) {
        boolean success = false;
//        String conditions = conditions(condition);
//        StringBuilder changes;
//        changes = new StringBuilder(" ");
//        int size = change.size();
//        for (int i = 0; i < size; i++) {
//            if (i < size - 1) {
//                changes.append(change.keySet().toArray()[i]).append(" = ?, ");
//            } else {
//                changes.append(change.keySet().toArray()[i]).append(" = ? ");
//            }
        

        String sql = "UPDATE " + table + " SET COLUMN_NAME=? WHERE ID = ? ";

        try {
            ps = dbconnect.prepareStatement(sql);
            
            Scanner  scanner = new Scanner(System.in); 
			System.out.println("Please enter your column_name");
			String column= scanner.nextLine();
			System.out.println("Please enter the ID");
			String identify = scanner.nextLine();
	            ps.setString (1, column);
				ps.setString (2, identify);
				int rs = ps.executeUpdate();
				
			
            

//            size = change.size();
//            int count = 1;
//            for (int i = 0; i < size; i++) {
//                ps.setString(count, change.values().toArray()[i].toString());
//                count++;
//            }
//            size = condition.size();
//            for (int i = 0; i < size; i++) {
//                ps.setString(count, condition.get(condition.keySet().toArray()[i])[1]);
//                count++;
//            }
//            if (ps.executeUpdate() == 1) {
//                success = true;
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }


    public boolean delete(String table) {
        boolean success = false;
        String sql = "DELETE FROM " + table + " WHERE ID = ?";

        try {
        	 Scanner  scanner = new Scanner(System.in); 
 			
 			System.out.println("Please enter the ID");
 			String identify = scanner.nextLine();
 	           
 				ps.setString (1, identify);
 				int rs = ps.executeUpdate();
            ps = dbconnect.prepareStatement(sql);
//            buildBindParam(condition);
//            if (ps.executeUpdate() == 1) {
//                success = true;
				success = ps.execute();

            }
       catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }

    public String select(String table) {
        
        String sql = "SELECT * FROM " + table + " WHERE=?";

        try {
            ps = dbconnect.prepareStatement(sql);
            Scanner  scanner = new Scanner(System.in); 
			
			
			

            ResultSet rs = ps.executeQuery();
            String data= rs.getString("QUESTIONS");
             String answer;
             answer=rs.getString("ANSWER");
             System .out.println (data);
             System .out.println (answer);
             

            
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return null;
        
		//Object data;
		
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



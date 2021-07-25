package com.revature.ers.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.revature.ers.models.Employee;
import com.revature.ers.models.RequestEntity;

public class LoginDao {
	
	private static final Logger logger = Logger.getLogger(LoginDao.class.getName());

	
	public static boolean validate(String name,String pass){ 
		BasicConfigurator.configure(); 
		boolean status=false;  
		try{  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:xe","system","4024768+uU");  
		      
		PreparedStatement ps=con.prepareStatement(  
		"select * from userers where username=? and pass=?");  
		ps.setString(1,name);  
		ps.setString(2,pass);  
		      
		ResultSet rs=ps.executeQuery();  

		status=rs.next();  
		con.close();   
		}catch(Exception e){System.out.println(e);}  
		logger.info("Username and password match!");
		return status;  
		}  
	
	public static String getFullName(String username) {
		BasicConfigurator.configure();
		String fullName = null;
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","4024768+uU");  
			      
			PreparedStatement ps=con.prepareStatement(  
			"select * from userers where username=?");  
			ps.setString(1,username);  
			ResultSet rs=ps.executeQuery();  
			if (rs.next()) {
				fullName = rs.getString("FULLNAME");
			}
			
			con.close();
			}catch(Exception e){System.out.println(e);}  
		logger.info("Full Name: " + fullName);
		return fullName;
		
	}
	
	public static Employee getEmplyeeDetails(String username) {
		BasicConfigurator.configure();
		String name = null;
		String position = null;
		String pass = null;
		int id = 0;
		
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","4024768+uU");  
			      
			PreparedStatement ps=con.prepareStatement(  
			"select * from userers where username=?");  
			ps.setString(1,username);  
			ResultSet rs=ps.executeQuery();  
			if (rs.next()) {
				name = rs.getString("NAME");
				position = rs.getString("position");
				pass = rs.getString("pass");
				id = rs.getInt("id");
			}
			con.close();
			}catch(Exception e){System.out.println(e);}
		Employee emp = new Employee(name, position, id, username, pass);
		logger.info("Employee details: " + emp.toString());
		return emp;
	}
	
	public static List<RequestEntity> getAllRequest(String username) {
		BasicConfigurator.configure();
		String status = null;
		int requestId = 0;
		int id = 0;
		List<RequestEntity> list = new ArrayList<RequestEntity>();
		String position = getPositionByUsername(username);
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","4024768+uU");  
			
			String QUERY = "select * from reimburserequest";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
 
			while (rs.next()) {
				status = rs.getString("status");
				requestId = rs.getInt("requestid");
				id = rs.getInt("id");	
				RequestEntity re = new RequestEntity(id, requestId, status, position);
				list.add(re);
			}
			con.close();
			}catch(Exception e){System.out.println(e);}
		//logger.info("Reimbursement requests retrieved: " + list.toString());
		return list ;
	}
	
	public static void updateUserInfo(String oldUN, String username, String pass) {
		BasicConfigurator.configure();
		try{  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:xe","system","4024768+uU");  
		      
		PreparedStatement ps=con.prepareStatement(  
		"update userers set username=?, pass=? where username=?");  
		ps.setString(1,username);  
		ps.setString(2,pass);  
		ps.setString(3, oldUN);
		      
		ResultSet rs=ps.executeQuery();  
		con.close();
		}catch(Exception e){System.out.println(e);}
		logger.info("User updated!");
	}
	
	public static void registerNewEmployee(String name, String username, String pass, String position) {
		BasicConfigurator.configure();
		try{  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:xe","system","4024768+uU");  
		      
		PreparedStatement ps=con.prepareStatement(  
		"insert into userers values (?, ?, ?, ?, ?)");  
		ps.setInt(1, (int) Math.floor(Math.random()*(9876-9+1)+9));;  
		ps.setString(2,name);  
		ps.setString(3, pass);
		ps.setString(4, position);
		ps.setString(5, username);
		
		ResultSet rs=ps.executeQuery();  
		          
		con.close();
		}catch(Exception e){System.out.println(e);}
		logger.warn("New Employee registered!");
	}
	
	public static Integer getEmployeeId(String username) {
		BasicConfigurator.configure();
		int id = 0;
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","4024768+uU");  
			
			PreparedStatement ps=con.prepareStatement(  
					"select id from userers where username = ?");
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();  
 
			if (rs.next()) {
				id = rs.getInt("id");	
			}
			con.close();
			}catch(Exception e){System.out.println(e);}
		logger.info("Employee ID retrieved: " + id);
		return id;
	}
	
	public static String getPositionByUsername(String username) {
		BasicConfigurator.configure();
		String position = null;
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","4024768+uU");
			
			PreparedStatement ps=con.prepareStatement(  
					"select position from userers where username = ?");
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			
			if (rs.next()) {
				position = rs.getString("position");
			}
			con.close();
		} catch(Exception e){System.out.println(e);}
		
		//logger.info("Employee position: " + position);
		return position;
	}
	
	public static List<RequestEntity> getRequestsByEmployee(String username) {
		BasicConfigurator.configure();
		String status = null;
		int requestId = 0;
		int id = 0;
		List<RequestEntity> list = new ArrayList<RequestEntity>();
		String position = getPositionByUsername(username);
	
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","4024768+uU");  
			
			id = getEmployeeId(username);
			
			PreparedStatement ps2=con.prepareStatement(  
					"select * from reimburserequest where id = ?");
			ps2.setInt(1, id);
			
			ResultSet rs2=ps2.executeQuery(); 

			while (rs2.next()) {
				status = rs2.getString("status");
				requestId = rs2.getInt("requestid");
			
				list.add(new RequestEntity(id, requestId, status, position));
			}
			con.close();
			}catch(Exception e){System.out.println(e);}
		logger.info("Reimbursement requests: " + list.toString());
		return list ;
	}
	
	public static void submitReimbusementRequest(int id) {
		BasicConfigurator.configure();
		
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","4024768+uU");  
			
			PreparedStatement ps=con.prepareStatement(  
					"insert into reimburserequest values( ?, ?, ?)");
			ps.setInt(1, (int) Math.floor(Math.random()*(9876-9+1)+9));
			ps.setInt(2, id);
			ps.setString(3, "Pending");
			
			ps.executeQuery();
			con.close();
		} catch(Exception e){System.out.println(e);}
		logger.warn("Reimbursement request submited!");
	}
	
	public static void setRequestStatus(String requestId, String status) {
		BasicConfigurator.configure();
		String setStatus = null;
		if (status.equals("approve"))
			setStatus = "Approved";
		else
			setStatus = "Denied";
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","4024768+uU");  
			
			PreparedStatement ps=con.prepareStatement(  
					"update reimburserequest set status = ? where requestid = ?");
			ps.setString(1, setStatus);
			ps.setInt(2, Integer.parseInt(requestId));;
			
			ps.executeQuery();
			con.close();
		} catch(Exception e){System.out.println(e);}
		logger.info("Reimbursement request " + setStatus);
	}
}  
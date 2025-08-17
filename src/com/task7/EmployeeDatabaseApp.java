package com.task7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeDatabaseApp {
	private static final String URL ="jdbc:mysql://localhost:3306/employee_db";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	public static void main(String[] args) {
		try {
			  Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
			Scanner sc = new Scanner(System.in);
			while(true) {
				System.out.println("1.Add Employee");
				System.out.println("2.View Employee");
				System.out.println("3.Update Employee");
				System.out.println("4.Delete Employee");
				System.out.println("5.Exit!"); 
				System.out.println("Enter your choice :");
				int choice = sc.nextInt();
				switch(choice) {
				 case 1: addEmployee(con, sc); break;
                 case 2: viewEmployees(con); break;
                 case 3: updateEmployee(con, sc); break;
                 case 4: deleteEmployee(con, sc); break;
                 case 5: System.exit(0);
                 default: System.out.println("Invalid choice");
				
				}
				
			}
	    } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found. Please add the JAR file to your classpath.");
            e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		

	}
	private static void addEmployee(Connection con,Scanner sc) throws SQLException {
		System.out.println("Enter Name :");
		String name = sc.next();
		System.out.println("enter Department :");
		String dept = sc.next();
		System.out.println("Enter your salary :");
		double salary = sc.nextDouble();
		String sql = "Insert into employees(name,department,salary) VALUES(?,?,?)";
		try 
			(PreparedStatement st = con.prepareStatement(sql)){
			st.setString(1,name);
			st.setString(2,dept);
			st.setDouble(3,salary);
			st.executeUpdate();
			System.out.println("Employee added sucessfully!");
		}
		
		
	}
	private static void viewEmployees(Connection con) throws SQLException{
		String sql= "Select * from Employees";
		try(PreparedStatement st = con.prepareStatement(sql);     ResultSet rs = st.executeQuery()) {
			 while (rs.next()) {
	                System.out.println(rs.getInt("id") + " | " +
	                                   rs.getString("name") + " | " +
	                                   rs.getString("department") + " | " +
	                                   rs.getDouble("salary"));
	            }
		}
	}
	 private static void updateEmployee(Connection con, Scanner sc) throws SQLException {
	        System.out.print("Enter Employee ID: ");
	        int id = sc.nextInt();
	        System.out.print("Enter New Salary: ");
	        double salary = sc.nextDouble();

	        String sql = "UPDATE employees SET salary=? WHERE id=?";
	        try (PreparedStatement stmt = con.prepareStatement(sql)) {
	            stmt.setDouble(1, salary);
	            stmt.setInt(2, id);
	            int rows = stmt.executeUpdate();
	            System.out.println(rows > 0 ? "Updated successfully!" : "Employee not found.");
	        }
	    }

	    private static void deleteEmployee(Connection conn, Scanner sc) throws SQLException {
	        System.out.print("Enter Employee ID to delete: ");
	        int id = sc.nextInt();

	        String sql = "DELETE FROM employees WHERE id=?";
	        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setInt(1, id);
	            int rows = stmt.executeUpdate();
	            System.out.println(rows > 0 ? "Deleted successfully!" : "Employee not found.");
	        }
	    }

}

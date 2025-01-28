package com.ty.emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Result;

public class EmployeeImplementation implements EmployeeInterface {

	static Scanner scanner = new Scanner(System.in);

	public void addEmployee() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdetails2", "root", "Star#789");

			String query = "INSERT INTO employee2 VALUES  (?,?,?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(query);

			System.out.println("Enter Employee ID:-");
			int empid = scanner.nextInt();

			scanner.nextLine();

			System.out.println("Enter Employee Name:");
			String name = scanner.nextLine();

			System.out.println("Enter Employee Salary:");
			int salary = scanner.nextInt();

			scanner.nextLine();

			System.out.println("Enter Employee Phone No:");
			String phno = scanner.nextLine();

			System.out.println("Enter Employee Email:");
			String email = scanner.nextLine();

			System.out.println("Enter Employee Address:");
			String address = scanner.nextLine();

			System.out.println("Enter Employee Company:");
			String companyName = scanner.nextLine();

			ps.setInt(1, empid);
			ps.setString(2, name);
			ps.setInt(3, salary);
			ps.setString(4, phno);
			ps.setString(5, email);
			ps.setString(6, address);
			ps.setString(7, companyName);

			ps.execute();

			con.close();

			System.out.println("Employee Added");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void removeEmployee() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdetails2", "root", "Star#789");

			String query = "DELETE FROM EMPLOYEE WHERE empid=?";

			PreparedStatement ps = con.prepareStatement(query);

			System.out.println("Enter Employee ID:-");

			int empid = scanner.nextInt();

			ps.setInt(1, empid);

			ps.executeUpdate();

			con.close();

			System.out.println("Employee ID:-" + empid + "Deleted");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void removeAllEmployee() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdetails2", "root", "Star#789");

			String query = "DELETE * FROM EMPLOYEE2";

			PreparedStatement ps = con.prepareStatement(query);

			ps.executeUpdate();

			con.close();

			System.out.println("All Employee Data Deleted");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void displayEmployee() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdetails2", "root", "Star#789");

			String query = "SELECT * FROM EMPLOYEE2 WHERE empid=?";

			PreparedStatement ps = con.prepareStatement(query);

			System.out.println("Enter Employee ID to Display:-");
			int empid = scanner.nextInt();

			ps.setInt(1, empid);

			ps.execute();

			ResultSet rs = ps.getResultSet();

			System.out.println("Employee ID " + empid + " Data");

			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getInt(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				System.out.println(rs.getString(6));
				System.out.println(rs.getString(7));
				System.out.println("---------------");
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void displayAllEmployee() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdetails2", "root", "Star#789");

			String query = "SELECT * FROM EMPLOYEE2";

			PreparedStatement ps = con.prepareStatement(query);

			ps.executeQuery();

			ResultSet rs = ps.getResultSet();

			System.out.println("All Employee Data");

			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getInt(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				System.out.println(rs.getString(6));
				System.out.println(rs.getString(7));
				System.out.println("---------------");
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateEmployee() {

		System.out.println(
				"1. Update Name\n2. Update Salary\n3. Update Phone No\n4. Update Email\n5. Update Address \n6. Update Company Name");

		System.out.println("Enter Choice");
		int choice1 = scanner.nextInt();

		switch (choice1) {
		case 1: {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdetails2", "root",
						"Star#789");

				String query = "UPDATE employee2 SET name=? WHERE empid=?";

				PreparedStatement ps = con.prepareStatement(query);

				System.out.println("Enter Employee ID:-");
				int empid = scanner.nextInt();

				scanner.nextLine();

				System.out.println("Enter Employee Updated name");
				String name = scanner.nextLine();

				ps.setString(1, name);
				ps.setInt(2, empid);

				ps.execute();

				con.close();

				System.out.println("Employee Name Updated");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			break;
		case 2: {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdetails2", "root",
						"Star#789");

				String query = "UPDATE employee2 SET salary=? WHERE empid=?";

				PreparedStatement ps = con.prepareStatement(query);

				System.out.println("Enter Employee ID:-");
				int empid = scanner.nextInt();

				scanner.nextLine();

				System.out.println("Enter Employee Updated Salary");
				int salary = scanner.nextInt();

				ps.setInt(1, salary);
				ps.setInt(2, empid);

				ps.execute();

				con.close();

				System.out.println("Employee Salary Updated");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			break;
		case 3: {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdetails2", "root",
						"Star#789");

				String query = "UPDATE employee2 SET phno=? WHERE empid=?";

				PreparedStatement ps = con.prepareStatement(query);

				System.out.println("Enter Employee ID:-");
				int empid = scanner.nextInt();

				scanner.nextLine();

				System.out.println("Enter Employee Updated Phone Number");
				String phno = scanner.nextLine();

				ps.setString(1, phno);
				ps.setInt(2, empid);

				ps.execute();

				con.close();

				System.out.println("Employee Phone Number Updated");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			break;
		case 4: {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdetails2", "root",
						"Star#789");

				String query = "UPDATE employee2 SET email=? WHERE empid=?";

				PreparedStatement ps = con.prepareStatement(query);

				System.out.println("Enter Employee ID:-");
				int empid = scanner.nextInt();

				scanner.nextLine();

				System.out.println("Enter Employee Updated Email");
				String email = scanner.nextLine();

				ps.setString(1, email);
				ps.setInt(2, empid);

				ps.execute();

				con.close();

				System.out.println("Employee Email Updated");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			break;
		case 5: {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdetails2", "root",
						"Star#789");

				String query = "UPDATE employee2 SET address=? WHERE empid=?";

				PreparedStatement ps = con.prepareStatement(query);

				System.out.println("Enter Employee ID:-");
				int empid = scanner.nextInt();

				scanner.nextLine();

				System.out.println("Enter Employee Updated Address");
				String address = scanner.nextLine();

				ps.setString(1, address);
				ps.setInt(2, empid);

				ps.execute();

				con.close();

				System.out.println("Employee Address Updated");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			break;
		case 6: {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdetails2", "root",
						"Star#789");

				String query = "UPDATE employee2 SET companyName=? WHERE empid=?";

				PreparedStatement ps = con.prepareStatement(query);

				System.out.println("Enter Employee ID:-");
				int empid = scanner.nextInt();

				scanner.nextLine();

				System.out.println("Enter Employee Updated Company Name:-");
				String companyName = scanner.nextLine();

				ps.setString(1, companyName);
				ps.setInt(2, empid);

				ps.execute();

				con.close();

				System.out.println("Employee Company Name Updated");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			break;

		}

	}

	public void countEmployee() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdetails2", "root", "Star#789");

			String query = "SELECT count(*) FROM employee2";

			PreparedStatement ps = con.prepareStatement(query);
			ps.execute();

			ResultSet rs = ps.getResultSet();

			if (rs.next()) {
				int count = rs.getInt(1);
				System.out.println("Total Employee:-" + count);
			}

			rs.close();

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void sortEmployee() {

		System.out.println("1.By Name\n2.By Salary \n3.By Email_id\n4. By Phone Number");

		System.out.println("Enter Sort Choice:-");
		int sortchoice = scanner.nextInt();

		switch (sortchoice) {
		case 1: {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdetails2", "root",
						"Star#789");

				String query = "SELECT * FROM employee2 ORDER BY name ASC";

				PreparedStatement ps = con.prepareStatement(query);
				ps.execute();

				ResultSet rs = ps.getResultSet();

				while (rs.next()) {
					System.out.println(rs.getInt(1));
					System.out.println(rs.getString(2));
					System.out.println(rs.getInt(3));
					System.out.println(rs.getString(4));
					System.out.println(rs.getString(5));
					System.out.println(rs.getString(6));
					System.out.println(rs.getString(7));

				}

				con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
			break;
		case 2: {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdetails2", "root",
						"Star#789");

				String query = "SELECT * FROM employee2 ORDER BY salary ASC";

				PreparedStatement ps = con.prepareStatement(query);
				ps.execute();

				ResultSet rs = ps.getResultSet();

				while (rs.next()) {
					System.out.println(rs.getInt(1));
					System.out.println(rs.getString(2));
					System.out.println(rs.getInt(3));
					System.out.println(rs.getString(4));
					System.out.println(rs.getString(5));
					System.out.println(rs.getString(6));
					System.out.println(rs.getString(7));

				}

				con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
			break;
		case 3: {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdetails2", "root",
						"Star#789");

				String query = "SELECT * FROM employee2 ORDER BY email ASC";

				PreparedStatement ps = con.prepareStatement(query);
				ps.execute();

				ResultSet rs = ps.getResultSet();

				while (rs.next()) {
					System.out.println(rs.getInt(1));
					System.out.println(rs.getString(2));
					System.out.println(rs.getInt(3));
					System.out.println(rs.getString(4));
					System.out.println(rs.getString(5));
					System.out.println(rs.getString(6));
					System.out.println(rs.getString(7));

				}

				con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
			break;
		case 4: {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdetails2", "root",
						"Star#789");

				String query = "SELECT * FROM employee2 ORDER BY phno ASC";

				PreparedStatement ps = con.prepareStatement(query);
				ps.execute();

				ResultSet rs = ps.getResultSet();

				while (rs.next()) {
					System.out.println(rs.getInt(1));
					System.out.println(rs.getString(2));
					System.out.println(rs.getInt(3));
					System.out.println(rs.getString(4));
					System.out.println(rs.getString(5));
					System.out.println(rs.getString(6));
					System.out.println(rs.getString(7));

				}

				con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
			break;

		default:
			break;
		}

	}

	public void findEmployeeWithHighestSalary() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdetails2", "root", "Star#789");
			String query = "select * from employee2 where salary=(select max(salary) from employee2)";
			PreparedStatement ps = con.prepareStatement(query);

			ps.execute();

			ResultSet rs = ps.getResultSet();

			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getInt(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				System.out.println(rs.getString(6));
				System.out.println(rs.getString(7));

			}

			con.close();

			System.out.println("");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void findEmployeeWithLowestSalary() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdetails2", "root", "Star#789");
			String query = "select * from employee2 where salary=(select min(salary) from employee2)";
			PreparedStatement ps = con.prepareStatement(query);

			ps.execute();

			ResultSet rs = ps.getResultSet();

			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getInt(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				System.out.println(rs.getString(6));
				System.out.println(rs.getString(7));

			}

			con.close();

			System.out.println("");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}

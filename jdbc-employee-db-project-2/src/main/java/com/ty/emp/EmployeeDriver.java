package com.ty.emp;

import java.util.Scanner;

public class EmployeeDriver {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		EmployeeInterface employeeInterface = new EmployeeImplementation();
		while (true) {
			System.out.println("Welcome to Employee DBMS Project");
			System.out.println("------------------------------------");
			System.out.print("1.Add\n2.Remove\n3.RemoveAll\n4.Display\n5.DisplayAll\n6.Update");
			System.out.print("7.Count\n8.Sort\n9.HigestSalary\n10.LowestSalary\n11.Exit\n");
			System.out.println("\nEnter Choice");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				employeeInterface.addEmployee();
				break;
			case 2:
				employeeInterface.removeEmployee();
				break;
			case 3:
				employeeInterface.removeAllEmployee();
				break;
			case 4:
				employeeInterface.displayEmployee();
				break;
			case 5:
				employeeInterface.displayAllEmployee();
				break;
			case 6:
				employeeInterface.updateEmployee();
				break;
			case 7:
				employeeInterface.countEmployee();
				break;
			case 8:
				employeeInterface.sortEmployee();
				break;
			case 9:
				employeeInterface.findEmployeeWithHighestSalary();
				break;
			case 10:
				employeeInterface.findEmployeeWithLowestSalary();
				break;

			case 11:
				System.out.println("Thank You");
				System.exit(0);

			default:
				// throw custom exception call Invalid choice Exception

				break;
			}
		}
	}

}

package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of employees: ");
		int n = sc.nextInt();
		
		List<Employee> employees = new ArrayList<>();
		
		for(int i = 0 ; i<n ; i++) {
			String outsourced = "";
			System.out.printf("Employee #%d data: \n", i+1);
			sc.nextLine();
			while (!outsourced.equals("y") && !outsourced.equals("n")){
				System.out.print("Outsourced (y/n)? ");				
				outsourced = sc.nextLine();
			} 
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Hours: ");
			int hours = sc.nextInt();
			System.out.print("Value per Hour: ");
			double valuePerHour = sc.nextDouble();
			if(outsourced.equals("y")) {
				System.out.print("Additional charge: ");
				double additionalCharge = sc.nextDouble();
				employees.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
			}
			else {
				employees.add(new Employee(name, hours, valuePerHour));
			}
			System.out.println();
		}
		
		System.out.println("Payments:");
		
		for (Employee emp : employees) {
			System.out.print(emp.getName() + " - $ " + String.format("%.2f\n", emp.payment()));
		}
				
		sc.close();

	}

}

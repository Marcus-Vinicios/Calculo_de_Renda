package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Main {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();

		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();

		System.out.print("Level: ");
		String workerLevel = sc.nextLine();

		System.out.print("Base Salary: ");
		double baseSalary = sc.nextDouble();

		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary,
				new Department(departmentName));

		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Enter contract #" + (i + 1) + " data: ");
			System.out.print("Date (DD/MM/YYYY): ");
			LocalDate contractDate = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();

			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}

		System.out.print("\nEnter month and year to calculate income (MM/YYYY): ");
		String dateIncome = sc.next();

		int month = Integer.parseInt(dateIncome.substring(0, 2));
		int year = Integer.parseInt(dateIncome.substring(3));

		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + dateIncome + ": " + String.format("%.2f", worker.income(year, month)));

		sc.close();
	}

}

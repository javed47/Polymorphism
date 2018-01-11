package payrollProject;

import payrollProject.DownCastHelper;
import java.util.Scanner;

public class PayrollSystemTest {

	public static void main(String[] args) {
		int month;

		// Ask user to give for which month the payroll should calculate
		Scanner input = new Scanner(System.in);
		System.out.println("Give the month: (if January give 1, february 2 and so on ): ");
		month = input.nextInt();

		// Instantiate DownCastHelper
		DownCastHelper downCastHelper = new DownCastHelper();

		// Creating Date class array
		Date[] birthDate = new Date[4];

		birthDate[0] = new Date(12, 30, 1991);
		birthDate[1] = new Date(5, 30, 1970);
		birthDate[2] = new Date(7, 20, 1995);
		birthDate[3] = new Date(7, 29, 1995);

		// create subclass objects
		SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Smith", "111-11-1111", birthDate[0], 800.00);
		HourlyEmployee hourlyEmployee = new HourlyEmployee("Karen", "Price", "222-22-2222", birthDate[1], 16.75, 40);
		CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Jones", "333-33-3333", birthDate[2],
				10000, .06);
		BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob", "Lewis",
				"444-44-4444", birthDate[3], 5000, .04, 300);

		System.out.println("Employees processed individually:");

		System.out.printf("%n%s%n%s: $%,.2f%n%n", salariedEmployee, "earned", salariedEmployee.earnings(0.0));
		System.out.printf("%s%n%s: $%,.2f%n%n", hourlyEmployee, "earned", hourlyEmployee.earnings(0.0));
		System.out.printf("%s%n%s: $%,.2f%n%n", commissionEmployee, "earned", commissionEmployee.earnings(0.0));
		System.out.printf("%s%n%s: $%,.2f%n%n", basePlusCommissionEmployee, "earned",
				basePlusCommissionEmployee.earnings(0.0));

		// create four-element Employee array
		Employee[] employees = new Employee[4];

		// initialize array with Employees
		employees[0] = salariedEmployee;
		employees[1] = hourlyEmployee;
		employees[2] = commissionEmployee;
		employees[3] = basePlusCommissionEmployee;

		System.out.printf("Employees processed polymorphically:%n%n");

		// generically process each element in array employees
		for (Employee currentEmployee : employees) {
			System.out.println(currentEmployee); // invokes toString

			// determine whether element is a BasePlusCommissionEmployee
			if (currentEmployee instanceof BasePlusCommissionEmployee) {
				// downcast Employee reference to
				// BasePlusCommissionEmployee reference
				BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;

				employee.setBaseSalary(1.10 * employee.getBaseSalary());

				System.out.printf("new base salary with 10%% increase is: $%,.2f%n", employee.getBaseSalary());
			} // end if
			System.out.printf("earned $%,.2f%n%n", currentEmployee.earnings(0.0));

			// Determine the month is employees birth month and raise $100
			if (month == currentEmployee.getMonth()) {
				if (currentEmployee instanceof SalariedEmployee) {
					// downcast Employee reference to
					// CommissionEmployee reference
					System.out.println(downCastHelper.downcastToSalariedEmployee(currentEmployee));
				}

				else if (currentEmployee instanceof CommissionEmployee) {
					// downcast Employee reference to
					// CommissionEmployee reference
					System.out.println(downCastHelper.downcastToCommissionEmployee(currentEmployee));
				}

				else if (currentEmployee instanceof BasePlusCommissionEmployee) {
					// downcast Employee reference to
					// CommissionEmployee reference
					System.out.println(downCastHelper.downcastToBasePlusCommissionEmployee(currentEmployee));
				}

				else if (currentEmployee instanceof HourlyEmployee) {
					// downcast Employee reference to
					// CommissionEmployee reference
					System.out.println(downCastHelper.downcastToHourlyEmployee(currentEmployee));
				}
			}

		} // end for
			// get type name of each object in employees array
		for (int j = 0; j < employees.length; j++)
			System.out.printf("Employee %d is a %s%n", j, employees[j].getClass().getName());

	}
}

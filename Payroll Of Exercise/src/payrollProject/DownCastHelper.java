package payrollProject;

public class DownCastHelper {

	private SalariedEmployee salariedEmployee;
	private CommissionEmployee commissionEmployee;
	private BasePlusCommissionEmployee basePlusCommissionEmployee;
	private HourlyEmployee hourlyEmployee;

	// downcast Employee reference to SalariedEmployee
	public String downcastToSalariedEmployee(Employee employee) {
		this.salariedEmployee =  (SalariedEmployee) employee;

		return String.format("%s%.2f%n%n", "Happy Birthday your this month salary is:", salariedEmployee.earnings(100.0));
	}

	// downcast Employee reference to BasePlusCommissionEmployee
	public String downcastToBasePlusCommissionEmployee(Employee employee) {
		this.basePlusCommissionEmployee = (BasePlusCommissionEmployee) employee;

		return String.format("%s%.2f%n%n", "Happy Birthday your this month salary is:",
				basePlusCommissionEmployee.earnings(100.0));
	}

	// downcast Employee reference to CommissionEmployee
	public String downcastToCommissionEmployee(Employee employee) {
		this.commissionEmployee = (CommissionEmployee) employee;

		return String.format("%s%.2f%n%n", "Happy Birthday your this month salary is:",
				commissionEmployee.earnings(100.0));
	}

	// downcast Employee reference to HourlyEmployee
	public String downcastToHourlyEmployee(Employee employee) {
		this.hourlyEmployee = (HourlyEmployee) employee;

		return String.format("%s%.2f%n%n", "Happy Birthday your this month salary is:", hourlyEmployee.earnings(100.0));
	}

}

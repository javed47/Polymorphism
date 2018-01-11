package exercise;

public class PayableInterfaceTest {
	public static void main(String[] args) {
		// Instantiating classes
		Payable[] payable = new Payable[6];

		payable[0] = new Invoice("01122", "Patil", 3, 375.00);
		payable[1] = new Invoice("22221", "mobile", 9, 15000.00);
		payable[2] = new CommissionEmployee("Muntasir", "Sami", "Jani na", 12000.00, 0.7);
		payable[3] = new SalariedEmployee("Javed", "Rahman", "55-22-253", 1008.00);
		payable[4] = new HourlyEmployee("Mashnunul", "Huq", "252-291-1995", 25.0, 8);
		payable[5] = new BasePlusCommmissionEmployee("Padd", "Raiyan", "2525-55-555", 3000.0, 0.3, 5000.0);

		System.out.println("Invoices and Employees processed polymorphically:");

		// Processing data in a loop
		for (Payable currentPayable : payable) {
			System.out.printf("%n%s %n%s: $%,.2f%n", currentPayable.toString(), "payment due",
					currentPayable.getPaymentAmount());
		}
	}
}

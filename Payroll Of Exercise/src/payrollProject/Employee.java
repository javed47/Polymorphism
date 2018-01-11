package payrollProject;

public abstract class Employee {
	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;
	private final Date birthdate;
	
	public Employee(String firstName, String lastName, String socialSecurityNumber, Date birthdate)
	{
		this(firstName, lastName, socialSecurityNumber, birthdate, 0.0);
	}
	// main constructor
	public Employee(String firstName, String lastName, String socialSecurityNumber, Date birthdate, double earning)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.birthdate  = birthdate;
	}
	
	// return first name
	public String getFirstName()
	{
		return firstName;
	}
	
	// return last name
	public String getLastName()
	{
		return lastName;
	}
	
	// return social security number
	public String getSocialSecurityNumber()
	{
		return socialSecurityNumber;
	}
	
	// return String representation of Employee object
	@Override
	public String toString()
	{
		return String.format("%s %s%nsocial security number: %s%n Date of Birth: %s",
				getFirstName(), getLastName(), getSocialSecurityNumber(), birthdate);
	}
	
	// abstract method must be overridden by concrete subclasses
	public abstract double earnings(double extra);
	
	public int getMonth ()
	{
		return birthdate.getMonth();
	}
}

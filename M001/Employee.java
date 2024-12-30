// Program M001 by Matt Packwood
// CIS 2151 Orchard Ridge Summer 2006, Monday 6pm
// This is the actual Employee class

public class Employee
{
	private String firstName;
	private String lastName;
	private double salary;
	
	// constructor (assuming data provided during initiator
	public Employee(String firstName, String lastName, double salary)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		setSalary(salary);
	}
	
	// now a constructor that will build the object if no data has been passed during initiation
	public Employee()
	{
		this("n/a","n/a",0);
	}

	// basic set method for first name
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	// basic set method for last name
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	// this set method makes sure we do not try to set a negative salary
	public void setSalary(double salary)
	{
		this.salary = ((salary > 0) ? salary : 0);
	}
	
	// this just returns the first name
	public String getFirstName()
	{
		return firstName;
	}
	
	// return the last name
	public String getLastName()
	{
		return lastName;
	}
	
	// return the salary as a double
	public double getSalary()
	{
		return salary ;
	}

}
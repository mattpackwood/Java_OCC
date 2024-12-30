// Program M001 by Matt Packwood
// CIS 2151 Orchard Ridge Summer 2006, Monday 6pm
// This is the class to test the Employee class.....

public class EmployeeTest
{
	public static void main(String args[])
	{
		// first we set up a couple of employees, the first one in instanstated with the data passed to the constructor
		Employee employee1 = new Employee("John", "Smith", 54321);
		// the second one is instanstated with the default values I set in the constructor then has the valves set
		Employee employee2 = new Employee();
		// now use the set methods to set up this employee
		employee2.setFirstName("Jane");
		employee2.setLastName("Doe");
		employee2.setSalary(12345);
		// now print out the data that I entered
		printEmployee(employee1);
		printEmployee(employee2);
		// give them a 10% raise
		employee1.setSalary(employee1.getSalary() * 1.10);
		employee2.setSalary(employee2.getSalary() * 1.10);
		
		// print out the new info
		System.out.printf("After a 10%% increase\n");
		printEmployee(employee1);
		printEmployee(employee2);
		
	}
	private static void printEmployee(Employee tempEmployee)
	 {
	 	System.out.printf("Employee name %s %s and salary $%.2f\n", tempEmployee.getFirstName(), tempEmployee.getLastName(), tempEmployee.getSalary() );
	 }
	
}
public class Employee
{
	private String name;
	private int idNumber;
	private String department;
	private String position;
	
	public Employee()
	{
		this.name = "";
		this.idNumber = 0;
		this.department = "";
		this.position = "";
	}
	
	public Employee(String name, int idNumber, String department, String position)
	{
		this.name = name;
		this.idNumber = idNumber;
		this.department = department;
		this.position = position;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String toString()
	{
		String s = "Name: " + this.name + 
		"\nID Number: " + this.idNumber + 
		"\nDepartment: " + this.department + 
		"\nPosition: " + this.position;
		
		return s;
	}
}
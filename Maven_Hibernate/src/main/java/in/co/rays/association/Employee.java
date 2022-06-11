package in.co.rays.association;

public class Employee {

	private int id;
	private String firstName;
	private String lastName;
	private Address empAdd;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Address getEmpAdd() {
		return empAdd;
	}
	public void setEmpAdd(Address empAdd) {
		this.empAdd = empAdd;
	}
	
}

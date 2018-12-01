/**
 * 
 */
package mixconfig;

/**
 * @author amit
 * Class/bean to demonstrate importing javaconfig and xml config into another
 */

public class Employee {

	private Qualification qualification;
	private Address address;
	private Manager manager;
	private Designation designation;
	
	public Employee(Qualification qualification, Address address, Manager manager, Designation designation) {
		super();
		this.qualification = qualification;
		this.address = address;
		this.manager = manager;
		this.designation = designation;
	}
}

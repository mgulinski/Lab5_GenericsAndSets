package lab5_genericsandsets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author Machi
 */
public class Employee {
    
    private String firstName;
    private String lastName;
    private String ssn;

    

    public Employee(String firstName, String lastName, String ssn) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.ssn = ssn;
	
    }

    public String getSsn() {
	return ssn;
    }

    public void setSsn(String ssn) {
	this.ssn = ssn;
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

    
    // hashCode and equals determin equality based on employee ID number
    @Override
    public int hashCode() {
	int hash = 5;
	hash = 61 * hash + Objects.hashCode(this.ssn);
	return hash;
    }

    @Override
    public boolean equals(Object obj) {
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	final Employee other = (Employee) obj;
	if (!Objects.equals(this.ssn, other.ssn)) {
	    return false;
	}
	return true;
    }

        
    
    @Override
    public String toString() {
	
	String str = "\nName: " + firstName + " " + lastName
		    + "\nEmployee ID: " + ssn;
		    
	
	return str;  
    
    }
    
    
    public static void main(String[] args) {
	
	
		
	Employee e1 = new Employee("Macio", "Gulinski", "333-33-3333");
	Employee e2 = new Employee("Alex", "Druzny", "222-22-222");
	Employee e3 = new Employee("Seba", "Gulinski", "333-33-3333");
	
	
	List<Employee> employees = new ArrayList<Employee>();
	
	employees.add(e1);
	employees.add(e2);
	employees.add(e3);
	
	
	System.out.println("\n" + employees.size());
	
	for (Employee emp: employees) {
	    
	    System.out.println(emp);	
	}
	
	// push arraylist through hashset
	Set<Employee> hashemps = new HashSet<Employee>(employees);
	employees = new ArrayList<Employee>(hashemps);
	
	
	System.out.println("\nNow after hashset push\n" + employees.size());

	
	for(Employee e: employees) {
	    
	    System.out.println(e);
	}
	
	
	
    }
    
}

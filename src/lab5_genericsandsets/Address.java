package lab5_genericsandsets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Address {
    
    private String address;
    private String city;
    private String state;
    private int zip;
    private String phone;
    private String email;
    
    

    // address + zip = unique address
    public Address(String address, String city, int zip) {
	this.address = address;
	this.city = city;
	this.zip = zip;
    }
    
    // but adding city will make it more unique
    public Address(String address, String city, String state, int zip) {
	this.address = address;
	this.city = city;
	this.state = state;
	this.zip = zip;
    }

    

    
// getters and setters
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //hashCode and equals
    @Override
    public int hashCode() {
	int hash = 3;
	hash = 79 * hash + Objects.hashCode(this.address);
	hash = 79 * hash + Objects.hashCode(this.city);
	hash = 79 * hash + this.zip;
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
	final Address other = (Address) obj;
	if (!Objects.equals(this.address, other.address)) {
	    return false;
	}
	if (!Objects.equals(this.city, other.city)) {
	    return false;
	}
	if (this.zip != other.zip) {
	    return false;
	}
	return true;
    }

  // custom toString
    @Override
    public String toString() {
	
	String str = 
		  "\nStreet Address:\t" + address
		+ "\nCity:\t" + city
		+ "\nZip:\t" + zip
		+ "\nPhone:\t" + phone;
			
	return str;
    }
    
    
    public static void main(String[] args) {
	
	
	Address myaddress = new Address("5367 Eastway apt2", "Greendale" , 53129);
	Address heraddress = new Address("5367 Eastway apt2", "Greendale", 53129);
	Address diffaddress = new Address("306 W Hampton Ave apt205", "Milwaukee", 53211);
	Address diffaddress2 = new Address("306 W Hampton Ave apt205", "Milwaukee", 53211);
	
	
	List<Address> mybook = new ArrayList<Address>();
	
	mybook.add(myaddress);
	mybook.add(heraddress);
	mybook.add(diffaddress);
	mybook.add(diffaddress2);
	
	int i = 1;
	for(Address ad: mybook){
	    
	    System.out.println("\nEntry" + (i) + "\n-----------" + ad);
	    i++;
	}
	
	// pushing through Hashset bookset to get ridd off duplicates
	Set<Address> bookset = new HashSet<Address>(mybook);
	
	mybook = new ArrayList<Address>(bookset);
	
	System.out.println("\nNow after hash set filter...\n");
	
	i = 1;
	for(Address ad: mybook){
	    
	    System.out.println("\nEntry" + (i) + "\n-----------" + ad);
	    i++;
	}
	
    }
}

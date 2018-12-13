package TelephoneBook;

import java.util.List;
import java.util.Scanner;

public class Address {
	private String street, city, state, zip;
	
	Address() {}
	
	Address(String str, String c, String sta, String zip){
		this.street = str;
		this.city = c;
		this.state = sta;
		this.zip = zip;
	}
	
	public void setStreet(String str) {
		this.street = str;
	}
	
	public void setCity(String ct) {
		this.city = ct;
	}
	
	public void setState(String st) {
		this.state = st;
	}
	
	public void setZip(String z) {
		this.zip = z;
	}

	@Override
	public String toString() {
		return street + ", " + city + ", " + state + " " + zip;
	}
	
	// Used in Application.update() to update address.
	public void updateAddress(Scanner input, List<Card> rolodex) {
		System.out.print("Street: ");
		this.street = input.next();
		System.out.print("City: ");
		this.city = input.next();
		System.out.print("State: ");
		this.state = input.next();
		System.out.print("Zip: ");
		this.zip = input.next();
		//Application.displayMenu(input, rolodex);
	}
}

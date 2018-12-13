package TelephoneBook;

import java.util.List;
import java.util.Scanner;

public class Address {
	private String street, city, state, zip;

	
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
		setStreet(input.next());
		System.out.print("City: ");
		this.setCity(input.next());
		System.out.print("State: ");
		this.setState(input.next());
		System.out.print("Zip: ");
		this.setZip(input.next());
	}
}

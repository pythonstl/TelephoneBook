package TelephoneBook;

import java.util.List;

public class Card implements Comparable<Card>{
	private String firstName, lastName, telephone;
	private Address address;
	
	public void setFirstName(String name) {
		this.firstName = capitalize(name);
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setLastName(String name) {
		this.lastName = capitalize(name);
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setTelephone(String tel) {
		this.telephone = formatTelephone(tel);
	}
	
	public String getTelephone() {
		return this.telephone;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Address getAddress() {
		return this.address;
	}
	
	@Override
	public String toString() {
		return firstName + " " + lastName + ", " + telephone + ", " + address;
	}
	
	// Capitalizes just the first letter.
	String capitalize(String string) {
		return string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
	}
	
	// to format telephone numbers to (333) 333-3333
	public static String formatTelephone(String tel) {
		return tel.replaceFirst("(\\d{3})(\\d{3})(\\d{4})", "($1) $2-$3");
	}

	// This is needed for Collection.sort() in Application.addCard().
	@Override
	public int compareTo(Card o) {
		int compare = firstName.compareTo(o.firstName);
		return compare;
	}
	
	// Displays all cards in List<Card> anyList.
	public static void displayAll(List<Card> rolodex) {
		System.out.println();
		if (rolodex.isEmpty()) {
			System.out.print("There are 0 contacts in your directory.\n");
			return;
		}
		int i = 1;
		for (Card card : rolodex) {
			System.out.println(i + ". " + card.firstName + " " + card.lastName + ", " + card.telephone + ", " + card.address);
			i++;
		}
	}
}

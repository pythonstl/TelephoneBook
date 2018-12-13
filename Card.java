package TelephoneBook;

import java.util.List;

public class Card implements Comparable<Card>{
	private String firstName, lastName, telephone;
	protected Address address;
	
	public Card() {}
	
	public Card(String f, String l, String t, Address a) {
		this.firstName = f;
		this.lastName = l;
		this.telephone = t;
		this.address = a;
	}
	
	public void setFirstName(String name) {
		this.firstName = name;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setLastName(String name) {
		this.lastName = name;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setTelephone(String tel) {
		this.telephone = tel;
	}
	
	public String getTelephone() {
		return this.telephone;
	}
	
	@Override
	public String toString() {
		return firstName + " " + lastName + ", " + telephone + address;
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
			System.out.println(i + ". " + card.firstName + " " + card.lastName + ", " + card.telephone + " " + card.address);
			i++;
		}
	}
}

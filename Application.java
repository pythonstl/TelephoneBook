package TelephoneBook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		List<Card> rolodex = new ArrayList<>();
		System.out.println("Welcome!");
		displayMenu(input, rolodex);
	}

	// Displays main menu options and directs flow accordingly.
	public static void displayMenu(Scanner input, List<Card> rolodex) {
		int choice = 0;
		do {
			System.out.println("\nWhat would you like to do?"
					+ "\n[1] Add New"
					+ "\n[2] Delete"
					+ "\n[3] Update"
					+ "\n[4] Search"
					+ "\n[5] Display All"
					+ "\n[6] Exit\n");
			System.out.print("Your Selection: ");
			try {
				choice = input.nextInt();
			}
			catch (Exception e) {
				String invalidChoice = input.next();
				System.out.printf("Error: \"%s\" is not a valid entry.\n", invalidChoice);
			}
			// calls other methods based on chosen action
			switch(choice) {
			case 1: addCard(input, rolodex);
					displayMenu(input, rolodex);
					break;
			case 2: deleteCard(input, rolodex);
					displayMenu(input, rolodex);
					break;
			case 3: update(input, rolodex);
					displayMenu(input, rolodex);
					break;
			case 4: search(input, rolodex);
					displayMenu(input, rolodex);
					break;
			case 5: Card.displayAll(rolodex);
					displayMenu(input, rolodex);
					break;
			case 6: System.out.println("The program has been closed.");
					System.exit(0);
			default: System.out.println("Please choose 1, 2, 3, 4, 5, or 6.\n");
					break;
			}
		} while (choice < 1 || choice > 5);
	}
	
	// to add cards to rolodex alphabetically
	private static void addCard(Scanner input, List<Card> rolodex) {
		Card card = new Card();
		System.out.print("\nFirst Name: ");
		card.setFirstName(input.next());
		System.out.print("Last Name: ");
		card.setLastName(input.next());
		System.out.print("Telephone: ");
		card.setTelephone(input.next());
		Address address = new Address();
		System.out.print("Street: ");
		address.setStreet(input.next());
		System.out.print("City: ");
		address.setCity(input.next());
		System.out.print("State: ");
		address.setState(input.next());
		System.out.print("ZIP: ");
		address.setZip(input.next());
		card.setAddress(address);
		rolodex.add(card);
		Collections.sort(rolodex);
		Card.displayAll(rolodex);
	}
	
	// to remove cards from the rolodex
	private static void deleteCard(Scanner input, List<Card> rolodex) {
		Card.displayAll(rolodex);
		if (rolodex.isEmpty())
			return;
		System.out.println("\nWhose contact information would you like to remove?\n"
				+ "(Enter the first name.)\n");
		
		
		
		String deleteThis;
		do {
			System.out.print("Your Selection: ");
			deleteThis = input.next();
		} while(deleteThis.equals(null));
		List<Card> toRemove = new ArrayList<>();
		for (Card card : rolodex) {
			if(card.getFirstName().equalsIgnoreCase(deleteThis)) {
				toRemove.add(card);
			}
		}

		rolodex.removeAll(toRemove);
		Card.displayAll(rolodex);
	}
	
	// to update card/address if user chooses to do so
	private static void update(Scanner input, List<Card> rolodex) {
		if (rolodex.isEmpty()) {
			System.out.println("\nYou have to have contacts before you can update them.\n");
			return;
		}
		System.out.println("\nEnter the telephone number of the person whose information\n"
				+ "you would like to update.\n");
		System.out.print("Your Selection: ");
		String updateThis = Card.formatTelephone(input.next());
		boolean matches = false;
		for (Card card : rolodex) {
			if(updateThis.equalsIgnoreCase(card.getTelephone())) {
				matches = true;
				int choice = 0;
				System.out.println("\nWhat would you like to update?\n"
						+ "1. First Name\n"
						+ "2. Last Name\n"
						+ "3. Address\n"
						+ "4. Telephone\n");
				System.out.print("Your Selection: ");
				choice = input.nextInt();
				switch(choice) {
					case 1: prompt(); card.setFirstName(input.next());
					break;
					case 2: prompt(); card.setLastName(input.next());
					break;
					case 3: card.getAddress().updateAddress(input, rolodex);
					break;
					case 4: prompt(); card.setTelephone(input.next());
					break;
					default: System.out.println("Invalid choice.\n");
					break;
				}					
			}
		}
		if (matches == false)
			System.out.println("\nNo matches found!");
	}
	
	// to avoid repetition above in Application.update()
	private static void prompt() {
		System.out.print("Enter new: ");
	}
	
	// to search for a contact in Application.displayMenu()
	private static void search(Scanner input, List<Card> rolodex) {
		if (rolodex.isEmpty()) {
			System.out.println("\nYou have to have contacts before you can search for them.\n");
			return;
		}
		System.out.println("\nWhose contact information would you like to find?\n"
				+ "(Enter the first name.)\n");

		System.out.print("Your Selection: ");
		String searchThis = input.next();
		System.out.println();
		for (Card card : rolodex) {
			if (card.getFirstName().equalsIgnoreCase(searchThis)) {
				System.out.println(card.toString());
			}
		}
	}
}

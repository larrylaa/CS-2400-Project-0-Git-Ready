import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.util.ArrayList;
public class SandwichApp {
	public static void printBreadOptions() {
		System.out.println("=== Select Sandwich Bread: ===");
		System.out.println("1 - White Bread $1.50");
		System.out.println("2 - Wheat Bread $1.60");		
		System.out.println("3 - French Bread $1.80");		
		System.out.println("4 - Organic Bread $2.00");		
	}
	
	public static void printVeggieOptions() {
		System.out.println("=== Select Sandwich Vegetables: ===");
		System.out.println("1 - Red Onions $0.05");
		System.out.println("2 - Olives $0.10");		
		System.out.println("3 - Pickles $0.10");		
		System.out.println("4 - Lettuce $0.20");	
		System.out.println("5 - Green Peppers $0.25");
		System.out.println("6 - Tomatoes $0.30");		
		System.out.println("7 - Cheese $0.50");		
		System.out.println("8 - Quit Vegetable Selection");	
	}
	
	public static void printMeatOptions() {
		System.out.println("=== Select Sandwich Meat: ===");
		System.out.println("1 - Ham $1.00");
		System.out.println("2 - Roasted Chicken Breast $1.10");		
		System.out.println("3 - Turkey Breast $1.20");		
		System.out.println("4 - Roast Beef $1.50");	
		System.out.println("5 - Quit Meat Selection (No Meat)");
	}
	

	public static void main(String[] args) {
		Scanner userChoice = new Scanner(System.in);
		boolean keepOrdering = true;
		
		while (keepOrdering) {
		// Prompt user to pick bread
		printBreadOptions();
		System.out.println("Select a bread [1,4]: ");
		int selectedBread = userChoice.nextInt();
		
		while (selectedBread <= 0 || selectedBread > 4) {
			System.out.println("Error! Number must be greater than 0 and less than 4!");
			System.out.println("Select a bread [1,4]: ");
			selectedBread = userChoice.nextInt();
		}
		
		// Prompt user to pick vegetables
		ArrayList<Integer> selectedVegetables = new ArrayList<>();
		int selectedVeggie = 0;
		while (selectedVeggie != 8) {
		printVeggieOptions();
		System.out.println("Select vegetables: [1,8]: ");
		selectedVeggie = userChoice.nextInt();
		if (selectedVeggie <= 0 || selectedVeggie > 8) {
			System.out.println("Error! Number must be greater than 0 and less than 8!");
			continue;
		}
		if (selectedVeggie == 8) {
			break;
		}
		selectedVegetables.add(selectedVeggie); 
		}
		
		// Prompt user to pick meat
		printMeatOptions();
		System.out.println("Select a meat [1,5]: ");
		int selectedMeat = userChoice.nextInt();
		
		while (selectedMeat <= 0 || selectedMeat > 5) {
			System.out.println("Error! Number must be greater than 0 and less than 5!");
			System.out.println("Select a bread [1,5]: ");
			selectedMeat = userChoice.nextInt();
		}
		
		// Prompt user for their name
		System.out.println("Enter your name: ");
		userChoice.nextLine();
		String userName = userChoice.nextLine();
		
		// Create a sandwich object with the user's selection
		Sandwich userSandwich = new Sandwich(selectedBread, selectedVegetables, selectedMeat);
		
		// Calculate the price
		userSandwich.calculatePrice();
		
		// Determine the date and time of order
		Date now = new Date(); 
		DateFormat defaultDate = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM); 
		String timeStamp = defaultDate.format(now);
		
		// Create a order object with the sandwich object
		Order userOrder = new Order(userSandwich, timeStamp, userName);
		
		// Print out order details
		System.out.println(userOrder.printOrder());
		
		// Write order to file
		SandwichIO.writeOrderToFile(userOrder);
		System.out.println("Sucessfully tracked order to orderline.txt"); 
		
        // Ask user if they'd like to order more
		while (true) {
		    System.out.println("Would you like to continue ordering more sandwiches? (y/n)");
		    String userDesire = userChoice.nextLine();
		    
		    if (userDesire.equalsIgnoreCase("y")) {
		        System.out.println("Great! Let's continue ordering.");
		        break; 
		    } else if (userDesire.equalsIgnoreCase("n")) {
		        System.out.println("Thank you for ordering with us. Have a great day!");
		        keepOrdering = false;
		        break; 
		    } else {
		        System.out.println("Invalid input. Please enter 'y' to continue ordering or 'n' to finish.");
		    }
		}
		
		}
		userChoice.close();
	}
}

// LARRY LA - CS 1400 - FINAL PROJECT
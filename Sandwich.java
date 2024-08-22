import java.util.ArrayList;
public class Sandwich {
	private double price;
	private int bread;
	private ArrayList<Integer> vegetables = new ArrayList<>();
	private int meat;
	
	private String breadName;
	private ArrayList<String> veggieList = new ArrayList<>();
	private String meatName;
	
	public Sandwich(int bread, ArrayList<Integer> vegetables, int meat) {
		this.bread = bread;
		this.vegetables = vegetables;
		this.meat = meat;
	}
	
	public void calculatePrice() {
		// Determine price of bread
		double breadPrice = 0.00;
		switch (this.bread) {
		  case 1:
		    breadPrice = 1.50;
		    breadName = "White Bread";
		    break;
		  case 2:
			breadPrice = 1.60;
		    breadName = "Wheat Bread";
		    break;
		  case 3:
			breadPrice = 1.80;
		    breadName = "French Bread";
		    break;
		  case 4:
			breadPrice = 2.00;
		    breadName = "Organic Bread";
		    break;
		}
		
		// Determine price of vegetables
		double veggiePrice = 0.00;
		for (int i : this.vegetables) {
		    switch (i) {
		        case 1:
		            veggiePrice += 0.05;
		            veggieList.add("Red Onions");
		            break;
		        case 2:
		            veggiePrice += 0.10;
		            veggieList.add("Olives");
		            break;
		        case 3:
		            veggiePrice += 0.10;
		            veggieList.add("Pickles");
		            break;
		        case 4:
		            veggiePrice += 0.20;
		            veggieList.add("Lettuce");
		            break;
		        case 5:
		            veggiePrice += 0.25;
		            veggieList.add("Green Peppers");
		            break;
		        case 6:
		            veggiePrice += 0.30;
		            veggieList.add("Tomatoes");
		            break;
		        case 7:
		            veggiePrice += 0.50;
		            veggieList.add("Cheese");
		            break;
		    }
		}
	
		// Determine price of meat
		double meatPrice = 0.00;
		switch (this.meat) {
		  case 1:
			meatPrice = 1.00;
			meatName = "Ham";
		    break;
		  case 2:
			meatPrice = 1.10;
			meatName = "Roasted Chicken Breast";
		    break;
		  case 3:
			meatPrice = 1.20;
			meatName = "Turkey Breast";
		    break;
		  case 4:
			meatPrice = 1.50;
			meatName = "Roast Beef";
		    break;
		  case 5:
			meatPrice = 0.00;
			meatName = "No Meat";
			break;
		}
		
		// Calculate and set total price of sandwich
		this.price = (breadPrice + veggiePrice + meatPrice);
	}
	
	// Getters so that the Order class can access the sandwich attributes as strings of their respective ingredient names
	public String getBread() {
		return breadName;
	}
	
	public String getVeggies() {
		String stringVeggieList = "";
		for (String i: veggieList) {
			stringVeggieList += (i + ", ");
		}
		return stringVeggieList;
	}
	
	public String getMeat() {
		return meatName;
	}
	
	public double getPrice() {
		return this.price;
	}

}

// LARRY LA - CS 1400 - FINAL PROJECT
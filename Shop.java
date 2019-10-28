import java.util.Scanner;

public class Shop {
	
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		
		
		int max = 100; 
		
		String [] names = new String [max];
		double [] prices = new double [max]; 
		int    [] amounts = new int [max]; 
		int    [] discount = new int [max];
		int items = 0;
		int setup = 0; 
		int buy = 0; 
		int checkout = 0;
		
		do {
		System.out.println("This program supports 4 functions:");
		System.out.println("	1. Set Up Shop");
		System.out.println("	2. Buy");
		System.out.println("	3. List Items");
		System.out.println("	4. Checkout"); 
		System.out.print("Please choose the function you want: ");
		
		
		int function = input.nextInt(); 
		System.out.println("");
		

		if (function == 1) { 
			Setup(input, names, prices, discount, items);
			setup = 1;
			}
		
			

		if (function == 2) { 
			if (setup == 1)
				Buy (input, names, amounts, items); 
			buy = 1;
			if (setup != 1)
				System.out.println("Shop is not set up yet! "); 
				System.out.println("");
			}
			 
			
	
		if (function == 3) { 
			if (setup == 1 && buy == 1) { 
				List (names, prices, amounts);
			}
			if (setup != 1) {
				System.out.println("Shop is not set up yet! ");
				System.out.println("");
			}
			if (setup == 1 && buy != 1) {
				System.out.println("You have not bought anything! ");
				System.out.println("");
			}
			}
			
		if (function == 4) { 
			if (setup == 1 && buy == 1) { 
				Checkout (prices, amounts); 
				System.out.println("-------------------------------------------------"); 
				checkout = 1; 
			}
			if (setup != 1) {
				System.out.println("Shop is not set up yet! ");
				System.out.println("");
			}
			if (setup == 1 && buy != 1) {
				System.out.println("You have not bought anything! ");
				System.out.println("");
			}
			} 
		else if (function < 1 || function > 4) { 
			System.out.println("Error! Function " + function + " was not an option.");
			System.out.println("");
			}
		if (checkout == 1); 
			System.out.print("Would you like to re-run (1 for yes, 0 for no)?");
			int rerun = input.nextInt();
			System.out.println("-------------------------------------------------"); 
			if (rerun == 1) {
				continue;
			}
			if (rerun == 0) {
				break;
			}
				
		} while (true);
	}

// Setup 
	public static int Setup(Scanner input, String [] names, double [] prices, int [] discount, int items) {
		//ask for # of items to sell 
		System.out.print("Please enter the number of items to setup shop: "); 
		items = input.nextInt();
		//for loop that commits the names and prices of each item to an array  
		for (int i = 0; i < items; i++) { 
			System.out.print("Enter the name of the " + numSuffix(i+1) + " product: ");
			names[i] = input.next(); 
			System.out.print("Enter the per package price of " + names[i] + ": ");
			prices[i] = input.nextDouble(); 
			System.out.print("Enter the number of packages ('x') to qualify for Sepcial Discount (buy 'x' get 1 free) for " + names[i] + ", or 0 if no Special Discount offered: "); 
			discount[i] = input.nextInt(); 
		}
		 System.out.println("");
		 return items;
	}
	
	
	//name suffix code 
		public static String numSuffix(int i) { 
			int rem = i % 10; 
			switch (rem) { 
			case 0: 
			case 4: 
			case 5: 
			case 6: 
			case 7: 
			case 8: 
			case 9: 
				return (i + "th"); 
			case 1: 
				if (i % 100 != 11) 
					return (i + "st");
				else 
					return (i + "th");
			case 2: 
				if (i % 100 != 12) 
					return (i + "nd"); 
				else 
					return (i + "th"); 
			case 3: 
				if (i % 100 != 13)
					return (i + "rd");
				else 
					return (i + "th"); 
			default: 
				break;
			}
			return "";
		}
	
//Buy 
	public static void Buy(Scanner input, String [] names, int [] amounts, int items) { 
		for (int i = 0; i < names.length; i++){
			System.out.print("Enter the number of " + names[i] + " packages to buy: ");
			amounts[i] = input.nextInt(); 
		}
			System.out.println(""); 
			System.out.print("Enter the dollar amount to qualify for Additional Discount (or 0 if none offered): ");
			
		int Adiscount$ = input.nextInt(); 
			System.out.println("Enter the Additional Discount rate (e.g., 0.1 for 10%): ");
			
		double Adiscountr = input.nextDouble(); 
		if(Adiscountr < 0 || Adiscountr > 0.5) {
			System.out.print("Invalid input. Enter a value > 0 and <= 0.5: "); 
			Adiscountr = input.nextDouble(); 
		}
		System.out.println("");
	}
//List 
	public static void List(String [] names, double [] prices, int [] amounts) { 
	   for( int i = 0; i < names.length; i++) {
	   if (amounts[i] == 1){ 
		   System.out.println(amounts[i] + " package of " + names[i] + " @ $" + prices[i] + " per pkg = $" + amounts[i] * prices [i]);
	   } 
	   else if (amounts[i] > 1) {
			System.out.println(amounts[i] + " packages of " + names[i] + " @ $" + prices[i] + " per pkg = $" + amounts[i] * prices [i]);
	   } 
	   else if (amounts[i] == 0) {
		   System.out.println("No items were purchased.");
	   } 
	   } 
	   System.out.println("");
	}
//Checkout 
	public static void Checkout(double [] prices, int [] amounts) { 
		double subtotal = 0; 
		double sdiscount = 0; 
		
		for (int i = 0; i < amounts.length; i++)
			subtotal = subtotal + (amounts[i] * prices[i]); 
		
	System.out.println("Original Sub Total:		 $" + subtotal); 
	// if statement should be used to calculate and check for special discounts 
	System.out.println("Special Discounts:		-$" + sdiscount); 
	System.out.println("No Special Discounts applied"); 
	System.out.println("New Sub Total: 			 $" + (subtotal - sdiscount)); 
	subtotal = subtotal - sdiscount; 
	//if statement to check if user qualifies for additional discount 
    //
	//System.out.println("Additional + (Adiscountr * 10) + "% Discount: 		-$" + (Adiscountr * subtotal)
	//discount = Adiscount% * subtotal;
	//System.out.println("Final Sub Total: 		$" + (subtotal - discount)); 
	//System.out.println(""); 
	//System.out.println("System.out.println(Thanks for coming!); 
	//System.out.println("");
	
	}


}
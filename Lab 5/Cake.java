abstract public class Cake {
	String name, get_size;
	String[] topping, toppingOrder;
	double priceSmall, priceMedium, priceBig, priceSize, totalPrice;
	int size, quantity;
	
	Cake(String n){
		name = n;
	}
	
	abstract void setCake(String[] t, double ps, double pm, double db);
	
	void orderCake(String[] ts, int s, int q) {
		toppingOrder = ts;
		size = s;
		quantity = q;
	}
	
	double getSizePrice() {
		switch (size) {
			case 1: 
				priceSize = priceSmall; break;
			case 2: 
				priceSize = priceMedium; break;
			case 3: 
				priceSize = priceBig; break;
			default: break;
		}
		return priceSize;
	}
	
	double getTotalPrice(double ps) {
		totalPrice = ps * quantity + (toppingOrder.length * 10);
		return totalPrice;
	}
	
	String getSize() {
		switch (size) {
			case 1: get_size = "Small"; break;
			case 2: get_size = "Medium"; break;
			case 3: get_size = "Big"; break;
			default: get_size = " "; break;
		}
		return get_size;
	}
	
	void printCake() {
		System.out.println("--------------------");
		System.out.println("      Cake Menu     ");
		System.out.println("--------------------");
		System.out.println(name + " with available toppings:");

		for (int i = 0; i < topping.length; i++) {
			System.out.println((Integer.toString(i+1)) + ") " + topping[i]);
		}
		
		System.out.println("\nPrice:");
		System.out.println("[1] Small : RM" + priceSmall);
		System.out.println("[2] Medium: RM" + priceMedium);
		System.out.println("[3] Big   : RM" + priceBig);

	}
	
	void printOrder(String gs, double tp) {
		System.out.println("\n\nCake Order Details:");
		System.out.println("-------------------------------------------");
		System.out.print("Topping: ");
		for(int i = 0; i < toppingOrder.length; i++) {
			System.out.print(Integer.toString(i+1) + ") " + toppingOrder[i] + " ");
		}
		System.out.println("\nSize   : " + get_size);
		System.out.println("-------------------------------------------");
		System.out.print("Total Price: RM");
		System.out.print(totalPrice);
		System.out.println("\n-------------------------------------------");
		
	}
}
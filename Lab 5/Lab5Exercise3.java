public class Lab5Exercise3 {

	public static void main(String[] args) {
		Cake c = new BlackForest("BlackForest");
		String[] topping = {"Chocolate", "Cherries", "Whipped Cream"};
		c.setCake(topping, 45.00, 65.00, 80.00);
		c.printCake();
		String[] order = {"Chocolate", "Cherries"};
		
		c.orderCake(order, 1, 2);
		c.printOrder(c.getSize(), c.getTotalPrice(c.getSizePrice()));
		
	}

}

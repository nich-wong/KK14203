public class BlackForest extends Cake{

	BlackForest(String n) {
		super(n);
	}
	
	void setCake(String[] t, double ps, double pm, double pb) {
		topping = t;
		priceSmall = ps;
		priceMedium = pm;
		priceBig = pb;
	}

}

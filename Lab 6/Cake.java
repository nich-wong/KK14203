
interface Cake {
	void setCake(String[] t, double ps, double pm, double db);	
	void orderCake(String[] ts, int s, int q);	
	double getSizePrice();
	double getTotalPrice(double ps);	
	String getSize();	
	void printCake();
	void printOrder(String gs, double tp);
}

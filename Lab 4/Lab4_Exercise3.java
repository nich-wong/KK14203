import java.util.Scanner;  

class Menu{
   int id;
   String item;
   double price;
   
   Menu(String i, double p){
      item = i;
      price = p;
   }
   
   double getPrice(){
      return price;
   }
   
   void printItem(){
      System.out.print(item);
   }
}

public class Lab4_Exercise3{
   public static void main(String[] args){
      Scanner scanMenu = new Scanner(System.in);
      Scanner scanQuantity = new Scanner(System.in);
      
      Menu[] menu = new Menu[4];
      
      menu[0] = new Menu("Nasi Lemak", 2.00);
      menu[1] = new Menu("Roti", 1.00);
      menu[2] = new Menu("Teh Tarik", 1.50);
      menu[3] = new Menu("Kopi O", 1.00);
     
      char ch;
      int quantity;
      double price = 0;
      double totalPrice = 0;
      
      System.out.println("Menu:");
      for (int i = 0; i < 38; i++) System.out.print('-');
      System.out.println("\n[1] Nasi Lemak [RM2.00]");
      System.out.println("[2] Roti [RM1.00]");
      System.out.println("[3] Teh Tarik [RM1.50]");
      System.out.println("[4] Kopi O [RM1.00]");
      for (int i = 0; i < 38; i++) System.out.print('-');
      System.out.println("\nPlace order [1-4] or type 'q' to exit.\n");
      
      do{
         System.out.print("Add menu: ");
         String s_menu = scanMenu.nextLine();
         ch = s_menu.charAt(0);     
         if(ch == 'q') break;
         
         switch (ch){
            case '1': System.out.print("\t");
               menu[0].printItem();
               System.out.print(" - Quantity: ");
               quantity = scanQuantity.nextInt(); 
               price = quantity * menu[0].getPrice();
               System.out.printf("\tPrice: RM%.2f\n\n", price);
               break;
                      
            case '2': System.out.print("\t");
               menu[1].printItem();
               System.out.print(" - Quantity: "); 
               quantity = scanQuantity.nextInt();
               price = quantity * menu[1].getPrice();                     
               System.out.printf("\tPrice: RM%.2f\n\n", price);
               break;
                      
            case '3': System.out.print("\t");
               menu[2].printItem();
               System.out.print(" - Quantity: "); 
               quantity = scanQuantity.nextInt();
               price = quantity * menu[2].getPrice(); 
               System.out.printf("\tPrice: RM%.2f\n\n", price);
               break;
                      
            case '4': System.out.print("\t");
               menu[3].printItem();
               System.out.print(" - Quantity: "); 
               quantity = scanQuantity.nextInt();
               price = quantity * menu[3].getPrice(); 
               System.out.printf("\tPrice: RM%.2f\n\n", price);
               break;
         
            default: 
               break;
         }
         
         totalPrice += price;
                        
      } while(ch != 'q');
      
      System.out.println("\nThank you for your order!");     
      System.out.printf("Total due: RM%.2f\n", totalPrice); 
   }  
}
import java.util.ArrayList;
import java.util.List;

class MenuArray{
   int id;
   String food;
   double price;
}

public class Lab4_Exercise2{
   public static void main(String[] args){
      //2a
      String[][] Q2A = {{"1", "Nasi Lemak", "2.00"}, {"2", "Roti", "1.00"}, {"3", "Teh Tarik", "1.50"}};
      
      //2b
      List<List> Q2B = new ArrayList<List>();
      
      List list1 = new ArrayList();
      list1.add("1");
      list1.add("Nasi Lemak");
      list1.add("2.00");
      
      List list2 = new ArrayList();
      list2.add("2");
      list2.add("Roti");
      list2.add("1.00");
       
      
      List list3 = new ArrayList();
      list3.add("3");
      list3.add("Teh Tarik");
      list3.add("1.50");
      
      Q2B.add(list1);
      Q2B.add(list2);
      Q2B.add(list3);
      
      //2c
      MenuArray[] menu = new MenuArray[3];
      menu[0]= new MenuArray();
      menu[1]= new MenuArray();
      menu[2]= new MenuArray();

      menu[0].id = 1;
      menu[0].food = "Nasi Lemak";
      menu[0].price = 2.00; 
      menu[1].id = 2;
      menu[1].food = "Roti";
      menu[1].price = 1.00;
      menu[2].id = 3;
      menu[2].food = "Teh Tarik";
      menu[2].price = 1.50;
  }

}
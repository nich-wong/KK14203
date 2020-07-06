class Finance{
   private byte sem;
   private String session, lastPayDate;
   private double fees, totalCredit, remainingDebit, lastCredit;
   
   void setSem(byte s){
      sem = s;
   }
   void setSession(String se){
      session = se;
   }
   void setLastPayDate(String lpd){
      lastPayDate = lpd;
   }
   void setFees(double f){
      fees = f;
   }
   void setTotalCredit(double tc){
      totalCredit = tc;
   }
   void setRemainingDebit(double rm){
      remainingDebit = rm;
   } 
   void setLastCredit(double lc){
      lastCredit = lc;
   }
   
   
   byte getSem(){
      return sem;
   }
   String getSession(){
      return session;
   }
   String getLastPayDate(){
      return lastPayDate;
   }
   double getFees(){
      return fees;
   }
   double getTotalCredit(){
      return totalCredit;
   }
   double getRemainingDebit(){
      return remainingDebit;
   }
   double getLastCredit(){
      return lastCredit;
   }
   
   void calculateDebit(){
      remainingDebit = (fees - totalCredit);
   }
   
   void payment(){
      //accepts lastcredit and lastpaydate, assign to correct fields
      totalCredit += lastCredit;
      calculateDebit();
   }
   public Finance(){
      sem = 1;
      session = " ";
      lastPayDate = " ";
      totalCredit = 0;
      lastCredit = 0;
      fees = 2000;
      remainingDebit = 2000;
   }
   public Finance(byte s, String se, double f, double lc, String lpd){
      sem = s;
      session = se;
      fees = f;
      lastCredit = lc;
      lastPayDate = lpd;  
      payment();   
   }
   void print(){
      System.out.println("Sem: " + sem);
      System.out.println("Session: " + session);
      System.out.println("Fees: " + fees);
      System.out.println("Remaining: " + remainingDebit);
      System.out.println("Last Payment: " +  lastCredit + " on " + lastPayDate);
   }
}

public class demoFinance{
   public static void main(String[] args){
      Finance init = new Finance();
      Finance sem1 = new Finance((byte)1, "2019/2020", 3000, 1000, "20/10/2020");

      Finance sem2 = new Finance((byte)2, "2019/2020", 3000, 2000, "12/11/2020");
      sem1.print();
      sem2.print(); //remaining debit is independent of different objects
      
   }
}
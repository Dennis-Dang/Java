wpublic class MoneyCalculator
{
   public static void main(String[] args)
   {
      int quarters = 12;
      int dimes = 20;
      int nickels = 30;
      int pennies = 150;
      
      int totalPennies = calculatePennies(quarters, dimes, nickels, pennies);
      int totalDollars = calculateDollars(totalPennies);
      int totalQuarters = calculateQuarters(totalPennies);
      int totalDimes = calculateDimes(totalPennies);
      int totalNickels = calculateNickels(totalPennies);
      
      input(quarters, dimes, nickels, pennies);
      output(totalDollars, totalQuarters, totalDimes, totalNickels, totalPennies);
   }
   
   public static int calculatePennies(int quarters, int dimes, int nickels, int pennies)
   {
      return quarters*25 + dimes*10 + nickels*5 + pennies;
   }
   
   public static int calculateDollars(int pennies)
   {
      return pennies / 100;   
   }
   
   public static int calculateQuarters(int pennies)
   {
      return pennies / 25;
   }
   
   public static int calculateNickels(int pennies)
   {
      return pennies / 5; 
   }
   
   public static int calculateDimes(int pennies)
   {
      return pennies / 10;
   }   
   
   public static void input(int quarters, int dimes, int nickels, int pennies) 
   {  
      System.out.println("You have : ");
      System.out.println("\t" + quarters + " quarters");
      System.out.println("\t" + dimes + " dimes");
      System.out.println("\t" + nickels + " nickels");
      System.out.println("\t" + pennies + " pennies");
   }
   
   public static void output(int totalDollars, int totalQuarters, int totalDimes, int totalNickels, int totalPennies)
   {
      for (int i = 1; i <= 40; i++)
      {
            System.out.print("-");
      }
      System.out.println();   
      System.out.println("The amount of your money in dollar is: " + totalDollars);
      System.out.println("The amount of your money in quarter is: " + totalQuarters);
      System.out.println("The amount of your money in dime is: " + totalDimes);
      System.out.println("The amount of your money in nickel is: " + totalNickels);
      System.out.println("The amount of your money in penny is: " + totalPennies);
      for (int i = 1; i <= 40; i++)
      {
            System.out.print("-");
      }
   }
      
}      
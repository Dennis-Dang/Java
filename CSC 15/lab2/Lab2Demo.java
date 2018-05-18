public class Lab2Demo
{
   public static void main(String[] args)
   {
      calories();
      System.out.println();
      student();
      System.out.println();
      position();
   }
   public static void calories()
   {  
      //Declaring variables
      int runningMet = 10;
      int basketballMet = 8;
      int sleepMet = 1;
      double pounds = 150;
      double kilo = pounds/2.2;
      int time = 30;
      int timeSlept = 360;
      double constant = 0.0175;
     
      // Calories / Minute = 0.0175 x MET x Weight in Kg
      // Calories = 0.0175 x MET x Weight x Minute
      
      // Calculations
      double run = constant * runningMet * kilo * time;
      double basketball = constant * basketballMet * kilo * time;
      double slept = constant * sleepMet * kilo * timeSlept;
      double total = run + slept + basketball;
      
      System.out.println("Run: " + (int)run + " calories");
      System.out.println("Basketball: " + (int)basketball + " calories");
      System.out.println("slept: " + (int)slept + " calories");
      System.out.println("Total: " + (int)total + " calories");
   }
   public static void student()
   {
      String name = "Alex Zhang";
      String status = "Freshman";
      int units = 15;
      double GPA = 3.97;
      
      // Printing data
      System.out.println("Name: " + name);
      System.out.println("Status: " + status);
      System.out.println("Units: " + units);
      System.out.println("GPA: " + GPA);
   }
   public static void position()
   { 
      // Initialization of variables
      double s;
      double s0 = 12.0;
      double v0 = 3.5;
      double a = 9.8;
      int t = 10;
      
      // Computation for final position
      s = s0 + (v0 * t) + (0.5 * a * (t*t));
      
      // Printing final position
      System.out.print("The final position is: " + (int)s);
   }   
}      
      
      
/* Author: Dennis Dang
   Description: This program calculates and outputs 
   the total number of calories burned for a 150-pound person who: 
      
      Runs 6 MPH for 30 minutes 
      Plays basketball for 30 minutes 
      Sleeps for 6 hours
*/
public class lab3_1
{     
   public static void main(String[] args)
   {
      double calories;
      double weight;
      double runningMets;
      double basketballMets;
      double sleepingMets;
   
      // Calculations
      weight = 150 / 2.2;              // lbs to kg conversion
      runningMets = 10 * 30;
      basketballMets = 8 * 30;
      sleepingMets = 1 * 360;
      
      // Total Calories calculation in a more condensed form
      calories = (0.0175 * weight) * (runningMets + basketballMets + sleepingMets);
      
      // Print calories
      System.out.println("The total calories is: " + calories);
   }
}
         
      
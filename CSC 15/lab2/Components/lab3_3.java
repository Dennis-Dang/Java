/* Author: Dennis Dang
   Description:   This program calculates the final position of an object
                  using a physics equation.
*/
public class lab3_3
{
   public static void main(String[] args)
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
      System.out.print("The final position is: " + s);
   }
}      
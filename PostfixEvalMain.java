/*
 * PostfixEvalMain is a calculator that only takes postfix expressions.
 * It will only support addition (+), multiplication (*), dvision (/), & subtraction (-) operations.
 *
 * The calculator will terminate when "exit" is entered (case-sensitive) by the user as input.
 * Any other input will be treated as an illegal postfix expression and will print "Error".
 *
 * Author: Dennis Dang
 * Date: 16 November 2017
 */
import java.util.Scanner;
public class PostfixEvalMain
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      boolean done = false;

      while(!done)
      {
         System.out.print("> ");
         Scanner token = new Scanner(in.nextLine());
         LinkedDeque<Integer> d = new LinkedDeque<>();   // A deque to store a set of integers to perform operations with.

         try
         {
            int countInt = 0;          // Counts how many integer tokens there are.
            int countOp = 0;           // Counter of operations ran.
            String s = "";
            while(token.hasNext())     // While tokens remain
            {
                  s = token.next();

                  if(isInteger(s))     // It is an Integer
                  {
                     d.push(Integer.parseInt(s));
                     countInt++;
                  }
                  else if(s.equals("exit"))
                  {
                     done = true;
                     break;
                  }
                  else                 // It is an operation
                  {
                     if (s.equals("+"))
                        d.push(d.pop() + d.pop());
                     else if (s.equals("-")) // Subtraction is not comutative.
                     {
                        int num1 = d.pop();
                        int num2 = d.pop();
                        d.push(num2-num1);
                     }
                     else if (s.equals("/")) // Division is not comutative.
                     {
                        int num1 = d.pop();
                        int num2 = d.pop();
                        d.push(num2/num1);
                     }
                     else if (s.equals("*"))
                        d.push(d.pop() * d.pop());
                     else
                        throw new IllegalArgumentException();

                     countOp++;
                  }
            }
            // Post-condition: By now, stack should contain a result.

               if (!done && countInt - 1 != countOp)      // If no operations have been made
                  throw new IllegalArgumentException();
               if (!done)
                  System.out.println(d.pop());
         }
         catch(Exception e)
               { System.out.println("Error"); }
      }
      System.out.println("Good-bye!");
   }

   /*
    *  A helper method that checks if the string inputed is a valid integer.
    *  Returns true if it is a valid integer.
    */
   private static boolean isInteger(String s)
   {
      try
      {
         int i = Integer.parseInt(s);
      }
      catch(NumberFormatException e)
      {
         return false;
      }
      return true;
   }
}
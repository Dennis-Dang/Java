/* Author:        Dennis Dang
 * Description:   This program prompts the user to enter data taken as a string and then returns its potential 
                  corresponding data types.
 *
 * Note:          This program is limited to only primitive data types, excluding Strings.
*/

import java.util.*;
public class PrintDataValue
{
   public static void main(String[] args)
   {
      Scanner kb = new Scanner(System.in);
      String askAgain = "";
      boolean repeat = false;
      do
      {
         boolean booleanPresent = false;
         boolean StringPresent = false;
         boolean intPresent = false;
         boolean doublePresent = false;
         boolean charPresent = false;
         String s = "";

         System.out.print("Type in an input, then a data type will display: ");
         String input = kb.nextLine();
         s += "\"" + input + "\" is: ";

         if(hasBoolean(input))
         {
            booleanPresent = true;
            s += "boolean, ";
         }
         if(hasInt(input))
         {
            intPresent = true;
            s += "int, ";
         }
         if(hasDouble(input))
         {
            doublePresent = true;
            s += "double, ";
         }
         if(hasChar(input))
         {
            charPresent = true;
            s += "char, ";
         }
         System.out.println(s + "possibly a String."); // Any input given is a String

         do
         {
            System.out.print("Do you want to run again? [y/n] ");
            askAgain = kb.next();
            kb.nextLine(); // In case user inputs two or more words in 1 entry. ex: "asdf asdf"
         } while(!(askAgain.equalsIgnoreCase("y") || askAgain.equalsIgnoreCase("n")));

         if (askAgain.equalsIgnoreCase("Y"))
            repeat = true;
         else if(askAgain.equalsIgnoreCase("N"))
            repeat = false;
         else
            System.out.println("ERROR");

      } while (repeat);
      System.out.print("This program will now terminate...");

   }

   public static boolean hasBoolean(String input)
   {
      /*
      if(input.equalsIgnoreCase("true")||input.equalsIgnoreCase("false"))
         return true;
      else
         return false;
      */
      
      Scanner kb = new Scanner(input);
      if (kb.hasNextBoolean())
         return true;
      else
         return false;
   }

   public static boolean hasInt(String input)
   {
      /*
      for (int i = 0; i < input.length(); i++)
      {
         if (((int)(input.charAt(i)) < 65 || (int)(input.charAt(i)) > 122) || input.endsWith("0");  // A = 65, z = 122 in ASCII
            return true;
      }
      return false;
      */
      
      Scanner kb = new Scanner(input);
      if (kb.hasNextInt())
         return true;
      else
         return false;
   }

   public static boolean hasDouble(String input)
   {
      /*
      for (int i = 0; i < input.length(); i++)
      {
         if (input.charAt(i) == '.' && i != input.length()-1 && hasInt(input))
            return true;
      }
      return false;
      */
      
      Scanner kb = new Scanner(input);
      if (kb.hasNextDouble())
         return true;
      else
         return false;
   }

   public static boolean hasChar(String input)
   {
      if (input.length() == 1 && !hasDouble(input))
         return true;
      else
         return false;
   }
}

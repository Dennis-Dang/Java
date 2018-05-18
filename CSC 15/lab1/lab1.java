/* Author: Dennis Dang
   This program outputs a drawing of a pair of lanterns 
*/

public class lab1 
   {
      public static void main(String[] args) 
      {
            cap();
            System.out.println();
            cap();
            bar();
            largeStar();
            cap();
            System.out.println();
            cap();
            smallStar();
            bar();
            bar();
            smallStar();
            smallStar();
      }
      public static void smallStar() 
      {
            System.out.print("    *****    ");
            shift();
            System.out.println("    *****    ");
      }
      public static void mediumStar() 
         {
            System.out.print("  *********  ");
            shift();
            System.out.println("  *********  ");
         }
      public static void largeStar() 
         {
            System.out.print("*************");
            shift();
            System.out.println("*************");
         }
      public static void cap() 
         {
            smallStar();
            mediumStar();
            largeStar();
         }
      public static void bar() 
         {
            System.out.print("* | | | | | *");
            shift();
            System.out.println("* | | | | | *");
         }
      public static void shift() 
         {
            System.out.print("\t    ");
         }
   }
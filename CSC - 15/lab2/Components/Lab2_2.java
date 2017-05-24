/* Author: Dennis Dang
   Description: This program draws an hourglass as output. */

public class Lab2_2
{
   public static final int SIZE = 4;
   public static void main(String[] args)
   {
         drawLine();
         drawTop();
         drawMid();
         drawBottom();
         drawLine();
   }
   public static void drawLine()
   {
      System.out.print("|");
      for (int i = 1; i <= SIZE * 2  + 2; i++)
      {
         System.out.print("\"");
      }
      System.out.println("|");      
   }
   public static void drawTop()
   {
      for (int line = 1; line <= SIZE; line++)
      {
         for (int i = 1; i <= line; i++)
         {
            System.out.print(" ");
         }
         System.out.print("\\");
         for (int i = 1; i <= (-2 * line + (SIZE * 2 + 2)); i++)
         {
            System.out.print(":");
         }
         System.out.println("/");
     }
   }
   public static void drawMid()
   {
      for (int spaces = 1; spaces <= SIZE + 1; spaces++)
      {
      	System.out.print(" ");
      }
      System.out.print("||");
      for (int spaces = 1; spaces <= SIZE + 1; spaces++)
      {
      	System.out.print(" ");
      }
      System.out.println();
   }   
   public static void drawBottom()
   {
      for (int line = SIZE; line >= 1; line--)
      {
         for (int i = 1; i <= line; i++)
         {
            System.out.print(" ");
         }
         System.out.print("/");
         for (int i = 1; i <= ((SIZE * 2 + 2) - 2 * line); i++)
         {
            System.out.print(":");
         }
         System.out.println("\\");
      }
   }      
}         

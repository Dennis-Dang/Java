import java.util.Scanner;
public class Chapter3Part2
{
   public static void main(String[] args)
   {
      Scanner kb = new Scanner(System.in);
      int number;
      
      
      System.out.print("How many different websites do you have: ");
      number = kb.nextInt();
      kb.nextLine();
      for ( int i = 1; i <= number; i++)
      {
         String siteName = siteName(kb);
         System.out.println("The name of the website you entered is: " + siteName);
         System.out.println();    
      }   
      for (int i = 1; i <= 67; i++)
      {
         System.out.print('*');
      }
      System.out.println();
       
      System.out.print("How many encrypted words do you have> ");
      number = kb.nextInt();
      kb.nextLine();
      for (int i = 1; i <= number; i++)
      {
         String decrypt = decrypt(kb);
         System.out.println("Here is the decryped word: " + decrypt);
         System.out.println();
      }
      for (int i = 1; i <= 67; i++)
      {
         System.out.print('*');
      }
      System.out.println();
      
      System.out.print("Enter your first and last name seperated by a space: ");
      String reverse = reverse(kb);
      System.out.println("Here is your name in the reverse order: "+ reverse);
      System.out.println();
      for (int i = 1; i <= 67; i++)
      {
         System.out.print('*');
      }
      System.out.println();
      
      System.out.print("How many different investments do you have> ");
      number = kb.nextInt();
      kb.nextLine();
      System.out.println();
      for (int i = 1; i <= number; i++)
      {
         System.out.print(futureValue(kb) + "\n");
         System.out.println();
      }   
      
   }
   
   
   public static String siteName(Scanner kb)
   {
      System.out.print("Enter a URL: ");
      String siteName = kb.nextLine();
      int start = siteName.indexOf('.');
      int end = siteName.lastIndexOf('.');
      siteName = siteName.substring(start + 1, end);
      return siteName;
   }
   
   public static String decrypt(Scanner kb)
   {
      System.out.print("Enter the encrypted word: ");
      String encryption = kb.nextLine();
      
      int length = encryption.length();
      
      String decrypt = "";
      for (int i = 0; i <= length  - 1; i = i + 2)
      {
         decrypt = decrypt + encryption.charAt(i);
      }   
      decrypt = decrypt.toUpperCase();
      return decrypt;
   }
   
   public static String reverse(Scanner kb)
   {
      String phrase = kb.nextLine();
      int spaceLocation = phrase.indexOf(' ');
      String firstName = "";
      for (int i = 0; i <= spaceLocation - 1; i++)
      {
         firstName = firstName + phrase.charAt(i);
      }
      String lastName = "";
      for (int i = spaceLocation + 1; i <= phrase.length() - 1; i++)
      {
         lastName = lastName + phrase.charAt(i);
      }   
      phrase = lastName + " " + firstName;
      return phrase;
   }
   
   public static int futureValue(Scanner kb)
   {
      double investment;
      double interestRate;
      int years;
      System.out.print("Enter the investment: ");
      investment = kb.nextDouble();
      System.out.print("Enter the interest rate: ");
      interestRate = kb.nextDouble();
      System.out.print("Enter the number of years: ");
      years = kb.nextInt();
      System.out.println();
      int futureValue = (int) (investment * Math.pow((1 + interestRate), years));
      System.out.println("With an investment of " + investment);
      System.out.println("at an interest rate of compounded annually: " + interestRate);
      System.out.print("the future value in " + years + " years is ");
      return futureValue;
   }
    
}
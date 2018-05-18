/*
   Author:        Dennis Dang
   Description:   This is a program for bank account transactions utilizing practices of input validation.
                  This was written for a lab activity for CSC 15 at Sacramento CSU.
*/


import java.util.Scanner;
public class Lab5
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      String choice ="";
      double balance = 0;
      description();
      
      boolean repeat = true;
      String answer = "";
      boolean account = false;
      while (repeat)  //As long as there is another user
      {
         balance = 0;
         choice = "";
         account = false;
         
         while (!choice.equalsIgnoreCase("Q"))// As long as the user has not selected quit
         {
            // Conditional Statements corresponding the choices inputed my the User.
            displayChoices();
            choice = validChoice(input);
            
            if (choice.equalsIgnoreCase("C"))
            {
               if (!account)
               {
                  balance = create(input);
                  account = true;
               }   
               else
                  System.out.println("You already have an account");   
            }   
            else if (choice.equalsIgnoreCase("D"))
            {
               balance = deposit(input, balance);
            }   
            else if (choice.equalsIgnoreCase("W"))
            {
               balance = withdraw(input, balance);
            }   
            else if (choice.equalsIgnoreCase("B"))
            {
               System.out.println("Balance: " + balance);
            }   
            else if (choice.equalsIgnoreCase("Q"))
            {   
               System.out.print("Is there another user? ");
               if (input.next().equalsIgnoreCase("y"))
               {
                  balance = 0;
                  choice = "";
                  account = false;
               }
               else
               {
                  repeat = false;
               }
            }
            System.out.println();
            System.out.print("Hit the enter key to continue");
            input.nextLine();
            input.nextLine();
            System.out.println();
         } 
      }
      System.out.print("The system is about to shut down");

   }
   
   /* This method accepts a Scanner object and the balance of the money that the person has as its parameter
   prompt the user to enter the amount of the money to withdraw
   call the method dataValiation to get the user's input
   if the user's input is more than the balance display that the user cannot withdraw that amount
   if the  balance - the user's input is less than 100 then no withdraw can be done
   otherwise the withdraw can be done therefore the user's input must be subtracted from the balance. then return the new balance*/
   
   public static double withdraw(Scanner kb, double balance)
   {
      double withdrawAmt = dataValidation("How much do you want to take out? ", kb);
      
      if (withdrawAmt <= balance)
         balance -= withdrawAmt;
      else
      {
         System.out.println("Too much money, you dont have that much to take out.");
         System.out.println("You only have " + balance);
      }
      
      return balance;    
   }
   
   /*This method prompt the user for the amount to deposit
   call the method dataValidation to get the user's input
   add the amount to the balance, return the new balance*/
   public static double deposit(Scanner kb, double balance)
   {
      double depositAmt = dataValidation("How much do you want to deposit to your account? ", kb);
      
      return balance + depositAmt;
   }
   
   /*
   this method prompts the user to enter the initial amount of the money to create the account
   call the method dataValidation
   if the user's input is less than 100, the account cannot be created
   otherwise the account will be cretaed and a message will be displayed
   indicating that the account has been cretaed, the initial amount of the money will be returned
   */
   public static double create(Scanner kb)
   {
      String answer = "";
   
      System.out.println("Lets make an account for you.");
      double initialAmt = dataValidation("Enter the initial amount of money: ", kb);
      
      if (initialAmt < 100)
      {
         System.out.println("You must deposit 100 or more to create a new account.");
         return 0;
      }   
      else
      {
         System.out.print("Do you want to create a new account? ");
         answer = kb.next();
         if (answer.equalsIgnoreCase("yes"))
         {
            System.out.println("Thank you for choosing Bank of America");
            System.out.println("Your account has been successfully created");
            return initialAmt;
         }
         else
            return 0;
      }         
      
   }
   
   /*
   This method outputs Welcome to the Bank of America message including all the backslashes
   */
   public static void description()
   {
      System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
      System.out.println("\\\\     Welcome to the Bank of America      \\\\");
      System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
   }
   
   /*
      This method displays the choices that the user has
   */
   public static void displayChoices()
   {
      System.out.println("Select one of the following options:");
      System.out.println("Press C to create a new account");
      System.out.println("Press D to deposit");
      System.out.println("Press W to withdraw");
      System.out.println("Press B for Balance");
      System.out.println("Press Q to quit");
   }
   
   /*this method prompts the user to enter the choice
   as long as the user does not have a valid choice, it will keep prompting the user
   for a valid choice*/     
   public static String validChoice(Scanner kb)
   {
      boolean falseValue = true;
      System.out.print("Enter your choice--> ");
      String choice = "";
      
      while (falseValue)
      {
         choice = kb.next();
        
         if (choice.equalsIgnoreCase("C") || choice.equalsIgnoreCase("D") || choice.equalsIgnoreCase("B") || choice.equalsIgnoreCase("W") || choice.equalsIgnoreCase("Q"))
            falseValue = false;
         else
            System.out.print("Sorry, invalid choice. Try again. "); 
      }
      
      return choice;
   } 
   
   /*This method accepts the scanner object and a message to be displayed on the screen
   Outputs the prompt on the screen asking the user to enter the amount
   As long as the amount is less than zero and as long as the user is entering an invalid 
   double value, this method should keep prompting the user for a valid amount.
   return the valid amount*/
   
   public static double dataValidation(String prompt, Scanner kb)
   {
      double amt = -1;
      int timesThrough = 0;
      kb.nextLine();
      
      
      while (amt < 0)
      {
         if (timesThrough == 0)
         {
            System.out.print(prompt);
         }
         else if (timesThrough > 0)
         {
            System.out.print("Sorry, you must have a positive number ");
         }
         while (!kb.hasNextDouble())
         {
            System.out.print(prompt);
            kb.nextLine();
         }
         amt = kb.nextDouble();
         timesThrough++;
      }
      
      return amt;
   }  
} 
/* SAMPLE OUTPUT
____________________________________________________________________________________________________

\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
\\     Welcome to the Bank of America      \\
\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

Select one of the following options:
Press C to create a new account
press D to deposit
press W to withdraw
press B for Balance
Press Q to quit
Enter your choice ---> r
Enter a valid choice ---> t
Enter a valid choice ---> c
lets create an account for you.
Enter the initial amount of money--> -20
You must enter a positive amount of money. 
Enter a valid amount: 80
You must deposit 100 or more to create a new account
Do you want to cretae a new account? yes
Enter the initial amount of money--> 100
Your account has been cretaed successfully

Select one of the following options
Press C to create a new account
press D to deposit
press W to withdraw
press B for Balance
Press Q to quit
Enter your choice ---> w
Enter the amount of the withdraw--> 20
Your balance cannot go below 100 dollars. 
your balance after withdraw will be :80.0
The amount of the money that you have is-->100.0

Hit enter key to continue --> 

Select one of the following options
Press C to create a new account
press D to deposit
press W to withdraw
press B for Balance
Press Q to quit
Enter your choice ---> w
Enter the amount of the withdraw--> 100
Your balance cannot go below 100 dollars. 
your balance after withdraw will be :0.0
The amount of the money that you have is-->100.0

Hit enter key to continue --> 

Select one of the following options
Press C to create a new account
press D to deposit
press W to withdraw
press B for Balance
Press Q to quit
Enter your choice ---> d
Your balance is--> 100.0
Enter the amount of the money to deposit--> 200
Your new balance after deposit is: 300.0

Hit enter key to continue --> 

Select one of the following options
Press C to create a new account
press D to deposit
press W to withdraw
press B for Balance
Press Q to quit
Enter your choice ---> w
Enter the amount of the withdraw--> 150
The amount of the money you have--> 300.0
The amount of the money that you have is-->150.0

Hit enter key to continue --> 

Select one of the following options
Press C to create a new account
press D to deposit
press W to withdraw
press B for Balance
Press Q to quit
Enter your choice ---> c
You already have an account.

Hit enter key to continue --> 

Select one of the following options
Press C to create a new account
press D to deposit
press W to withdraw
press B for Balance
Press Q to quit
Enter your choice ---> B
Your balance is --> 150.0

Hit enter key to continue --> 

Select one of the following options
Press C to create a new account
press D to deposit
press W to withdraw
press B for Balance
Press Q to quit
Enter your choice ---> w
Enter the amount of the withdraw--> 200
You do not have enough money to withdraw
The amount of the money that you have is-->150.0

Hit enter key to continue --> 

Select one of the following options
Press C to create a new account
press D to deposit
press W to withdraw
press B for Balance
Press Q to quit
Enter your choice ---> w
Enter the amount of the withdraw--> 51
Your balance cannot go below 100 dollars. 
your balance after withdraw will be :99.0
The amount of the money that you have is-->150.0

Hit enter key to continue --> 

Select one of the following options
Press C to create a new account
press D to deposit
press W to withdraw
press B for Balance
Press Q to quit
Enter your choice ---> q
Thanks for being our loyal customer.
Is there another user?yes/no yes

Select one of the following options
Press C to create a new account
press D to deposit
press W to withdraw
press B for Balance
Press Q to quit
Enter your choice ---> C
lets cretae an account for you.
Enter the initial amount of money--> 100
Your account has been cretaed successfully

Select one of the following options
Press C to create a new account
press D to deposit
press W to withdraw
press B for Balance
Press Q to quit
Enter your choice ---> q
Thanks for being our loyal customer.
Is there another user?yes/no no
The system is about to shut down

_____________________________________________________________________________________________________
*/
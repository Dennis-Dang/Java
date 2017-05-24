/* Author:  Dennis Dang
   Description: This is a program the prints the calendar.
                This program especially utilizes dataValidation, count-controlled, 
                condition-controlled statements, and other methods of programming.
                This was created for a CSC15 course at CSU Sacramento. 
*/
import java.util.Scanner;
public class PrintCalenderShell
{
   public static void main(String[] args)
   {
      int year = 0;
      int month;
      String monthName = "";
      String repeat = "";
      Scanner kb = new Scanner(System.in);
     
      do 
      {
         do
         {
            System.out.print("Enter a valid year after 1800: ");
            while (!kb.hasNextInt())
            {
               System.out.print("Enter a valid year after 1800: ");
               kb.nextLine();
            }
            year = kb.nextInt(); 
         } while (year < 1800);
         
         System.out.println("Select one of the followiing options: ");
         System.out.println("To get the month calendar press m or M ");
         System.out.println("To get the calendar for the year enter y or Y ");
         System.out.print("Enter your choice: ");
         
         String choice = kb.next();
         
         
         if (choice.equalsIgnoreCase("m"))
         {
            do
            {
            System.out.print("Which month: ");
            if (!kb.hasNextInt())
            {
               monthName = kb.next();
               month = getMonthNumber(monthName);
            }
            else 
            {
               month = kb.nextInt();
            }

            }while (!((month >= 1) && (month <= 12)));
            
            printMonth(year, month); 
         }
         
         else if (choice.equalsIgnoreCase("y"))
         {
            for (int i = 1; i <= 12; i++)
            {
               printMonth(year, i);
            }
         }
         
         else 
         {
            System.out.println("Invalid choice");
         }
         
         do
         {
            System.out.print("Do you have another year to print the calendar of? (yes/no) ");
            repeat = kb.next();
         
         }while (!(repeat.equalsIgnoreCase("Yes") || repeat.equalsIgnoreCase("No")));
         
      }while ((repeat.equalsIgnoreCase("Yes")));
      
      System.out.print("Good-bye"); 
   }   
   
   /*this method prints the body of the calender for the given month*/
   public static void printMonth(int year, int month)
   {
      
      printMonthTitle(year, month); //call the method printTitle with the values year and month
		printMonthBody(year, month); //call the method printMonthBody with the values year and month 
            
   }
   
   /*this method prints the title of the days in each week(sunday Mon Tues Wed Thur Fir Sat)*/
   
   public static void printMonthTitle(int year, int month)
   {
      
      //output the title for each month of the year
      
      //call getMonthName
      System.out.print("\t\t ");
      System.out.printf("%-9s",getMonthName(month));
      System.out.println(" " + year);

      for (int i = 1; i <= 28; i++)
      {
        
         System.out.print("-");
      
      }
      System.out.println();
      System.out.println("Sun Mon Tue Wed Thu Fri Sat");
   }  
   
	// Prints the calendar for each month of the year
   
   public static void printMonthBody(int year, int month)
   {
	   int startDay = getStartDay(year, month);
      print(startDay, year, month); 
      
   }
   
   // Prints the Callendar for the given month
   public static void print(int startDay, int year, int month)
   {
      int totalDays = getNumberOfDaysInMonth(year, month);
      int thanksgivingDay;
      int dayOfWeek = startDay; // Identifies the first day of the month as the first day of the week.
      
      // Prints spaces up to the start day for each month
      for (int spaces = 1; spaces < startDay; spaces++)
      {
         System.out.print("    ");
      }
      // Prints the rest of the days in the calendar
      for (int i = 1; i <= totalDays; i++)
      {
         System.out.printf("%3s ", i); //This prints out the number of the day with a placeholder of 3 characters wide, right aligned.
         if (dayOfWeek % 7 == 0 || dayOfWeek == totalDays) // If it reaches Saturday, or the total amt of days.
         {
            System.out.println(); // Advance to the next line, starting a new week
         }
         if (dayOfWeek == 7) // If it's saturday, make it reset.
            dayOfWeek = 0;
         dayOfWeek++; // Advances the Day of The Week by 1 day, after printing out the current number day.
      }
      System.out.println(); // Advance to new line once the month is finished.
         
      // If the month is November, tell the user when it occurs.
      if (month == 11)
      {
         thanksgivingDay = thanksgiving(startDay);
         System.out.println("Thanksgiving is on the " + thanksgivingDay + "th");
      }
   }
	
	/*Thanksgiving is always on fourth Thursday of November. 
   Depending on the first day of the month a constant is added to 3 * 7, which is three weeks.*/
   
	public static int thanksgiving(int startDay)
	{
      switch (startDay)
      {
         case 1: return 5 + 3*7;
         case 2: return 4 + 3*7;
         case 3: return 3 + 3*7;
         case 4: return 2 + 3*7;
         case 5: return 1 + 3*7;
         case 6: return 7 + 3*7;
         default: return 6 + 3*7;
      }
	}
     	    
   public static String getMonthName(int month)
   {
       
      if(month == 1)
      {
         return "January";
      }
      else if(month == 2)
      {
         return "Febuary";
      }
      else if(month == 3)
      {
         return "March";
      }
      else if(month == 4)
      {
         return "April";
      }   
      else if(month == 5)
      {
         return "May";
      }   
      else if(month == 6)
      {
         return "June";
      }   
      else if(month == 7)
      {
         return "July";
      }   
      else if(month == 8)
      {
         return "August";
      }   
      else if(month == 9)
      {
         return "September";
      }   
      else if(month == 10)
      {
         return "October";
      }   
      else if(month == 11)
      {
         return "November";
      }
      else 
      {
         return "December";
      }
      
   }
	
   public static int getMonthNumber(String monthString)
   {
      monthString = monthString.toLowerCase();
      switch (monthString)
      {
         case "january":
         {
            return 1;
         }
         case "february":
         {
           return 2;
         }
         case "march":
         {
            return 3;
         }
         case "april":
         {
            return 4;
         }
         case "may":
         {
            return 5;
         }
         case "june":
         {
            return 6;
         }
         case "july":
         {
            return 7;
         }
         case "august":
         {
            return 8;
         }
         case "september":
         {
            return 9;
         }
         case "october":
         {
            return 10;
         }
         case "november":
         {
            return 11;
         }
         case "december":
         {
            return 12;
         }
         default:
         {
            return 0; 
         }
      }    
   }

	// Returns the day of the month it starts on
   public static int getStartDay(int year, int month)
   {
	   //call the method getTotalNumberOfDays and store it in a variable called start
      int start = getTotalNumberOfDays(year, month);
		//add 3 to the variable start
      start = start + 3;
		//return start % 7
      return (start % 7) + 1;
   }
   
	// Returns the total number of the days up to the given month in the given year
   public static int getTotalNumberOfDays(int year, int month)
   {
      int sum = 0;
      
      for (int i = 1800; i < year; i++)
      {
         if (isLeapYear(i))
            sum = sum + 366;
         else
            sum = sum + 365;
      }
      for (int j = 1; j < month; j++)
      {
         sum = sum + getNumberOfDaysInMonth(year, j);
      }
      return sum;
   }
   
   // Determines the total number of Days in their corresponding Months
   public static int getNumberOfDaysInMonth(int year, int month)
   {
      switch (month)
      {
         case 1:
            return 31;
         case 2:
         {
            if (isLeapYear(year))
               return 29;
            else 
               return 28;
         }
         case 3:
            return 31;
         case 5:
            return 31;
         case 7:
            return 31;
         case 8:
            return 31;
         case 10:
            return 31;
         case 12:
            return 31;
         default:
            return 30;
      }
      /* This is an alternative to the switch statement above:
      if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
         return 31;
      else if (month == 2)
      {   
         if (isLeapYear(year))
            return 29;
         else
            return 28;
      }      
      else
         return 30;
      */            
   }
   
	// Determines whether the year is a leap year.
   public static boolean isLeapYear(int year) 
   {
       //Refer to the Project Description for the Leap year formula  
       if (year % 400 == 0 || (!(year % 100 == 0)) && year % 4 == 0)
         return true;
       else 
         return false;
   }
}   
/*
   Author: Dennis Dang
   This program prompts the user to:
      Input the Month, Day, and Year.
      The output will return the corresponding date according to the gregorian calendar and also with its own Holidays.
      
   NOTE: This program does not include ALL of the holidays. This was developed for a Lab Assignment for CSC 15.   
*/

import java.util.Scanner;
public class Lab4
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      int month;
      String name;
      
      printDirections();
      System.out.print("Enter an integer of how many times this program to repeat: ");
      int iterations = input.nextInt();
      input.nextLine();
      
      for (int i = 1; i <= iterations; i++)
      {
         System.out.print("Enter the month: ");
         if (input.hasNextInt())
         {
            month = input.nextInt();
            name = getMonthString(month);
         }
         else 
         {
            name = input.next();
            month = getMonthNumber(name);
         }
         
         System.out.print("Enter a day: ");
         int day = input.nextInt();
         System.out.print("Enter a year: ");
         int year = input.nextInt();
        
         System.out.println("The Date is: " + month + "/" + day + "/" + year + "\t" + getMonthString(month) + " " + day + ", " + year + "\t" + getHoliday(month, day, year));
         
      }
      
      
   }
   
   public static void printDirections()
   {
      System.out.println("This program will ask you for a month, day, and year");
      System.out.println("and will print the corresponding date in two standard dat formats.");
      System.out.println("You may enter the month as:");
      System.out.println("\t a numeric value (1..12)");
      System.out.println("\t\t or as");
      System.out.println("\t an unabbreviated month name (January or February etc...");
   }
   
   public static String getMonthString(int monthInt)
   {
      switch (monthInt)
      {
         case 1:
         {
            return "January";
         }         
         case 2:
         {
           return "February";
         }
         case 3:
         {
            return "March";
         }
         case 4:
         {
            return "April";
         }
         
         case 5:
         {
             return "May";
         }
         
         case 6:
         {
            return "June";
         }
         
         case 7:
         {
            return "July";
         }
         
         case 8:
         {
            return "August";
         }
         
         case 9:
         {
            return "September";
         }
         
         case 10:
         {
            return "October";
         }
         
         case 11:
         {
            return "November";
         }
         
         case 12:
         {
            return "December";
         }
         
         default:
         {
            return "Error with finding integer \"month\"";
         }
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
   
   public static boolean isEaster(int month, int day, int year)
   {
      int goldenNumber = (year % 19) + 1;
      int a = (24 + 19*(goldenNumber - 1)) % 30;
      int b = a - a/28;
      int c = (year + year/4 + b - 13) % 7;
      int d = b - c;
      
      int easterMonth = 3 + (d + 40)/44;
      int easterDay = d + 28 - 31*(easterMonth/4);
      
      if (easterMonth == month && easterDay == day)
      {
         return true;
      }
      else
      {
         return false;
      }      
   }

   /*
   =======HOLIDAYS============//M//D//=======
   New Year's Day               01 01
   Martin Luther King Jr. Day   01 15
   Ground Hog Day;              02 02
   Abraham Lincoln's Birthday   02 12
   St. Valeninte's Day          02 14
   George washington            02 22
   St. Patrick's Day            03 17  
   April Fool's Day             04 01
   Grandma's Birthday           04 04
   Earth Day                    04 22
   Arbor Day                    04 28
   May Day                      05 01
   Cinco de Mayo                05 05
   Independence Day             07 04
   International Friendship Day 08 06
   Columbus Day                 10 09
   Halloween                    10 31
   Vereran's Day                11 11
   Christmas                    12 25
   New Year's Eve               12 31
   Easter                       (May Vary)
   */
   public static String getHoliday(int month, int day, int year)
   {
      String getString = "";
      switch (month)
      {
         case 1: switch (day)
         {
            case 1: getString = "New Year's Day";
            break;
            case 15: getString = "Martin Luther King Jr";
            break;
            case 29: getString = "Dennis's Birthday";
            break;
         }
         break;
         
         case 2: switch (day)
         {
            case 2: getString = "Ground Hog Day";
            break;
            case 12: getString = "Abraham Lincoln's Birthday";
            break;
            case 14: getString = "St. Valentine's Day";
            break;
            case 22: getString = "George Washington's Birthday";
            break;
         }
         break;
         
         case 3: switch (day)
         {
            case 17: getString = "St. Patrick's Day";
            break;
         }
         break;
         
         case 4: switch (day)
         {
            case 1: getString = "April Fool's Day";
            break;
            case 4: getString = "Grandma's Birthday";
            break;
            case 22: getString = "Earth Day";
            break;
            case 28: getString = "Arbor Day";
            break;
         }
         break;
         
         case 5: switch (day)
         {
            case 1: getString = "May Day";
            break;
            case 5: getString = "Cinco de Mayo";
            break;
         }
         break;
         
         case 7: switch (day)
         {
            case 4: getString = "Independence Day";
            break;
         }
         break;
         
         case 8: switch (day)
         {
            case 6: getString = "International Friendship Day";
            break;
         }
         break;
         
         case 10: switch (day)
         {
            case 9: getString = "Columbus Day";
            break;
            case 31: getString = "Halloween";
            break;
         }
         break;
         
         case 11: switch (day)
         {
            case 11: getString = "Veteran's Day";
            break;
         }
         break;
         
         case 12: switch (day)
         {
            case 25: getString = "Christmas";
            break;
            case 31: getString = "New Year's Eve";
            break;
         }
         break;
         
         default: getString = "";  
         break;
      }
      
      
      if (isEaster(month, day, year) && getString.length() != 0)
      {
         return "Easter " + getString;
      }
      else 
      {
         return getString;
      }       
     
   }              
}               
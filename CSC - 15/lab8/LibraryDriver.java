/*
 *  Name:         Dennis Dang
 *  Assignment:   LAB 8 - Object Oriented Programming
 *  Description:  This is a program that analyzes a depository of book characteristics in a .txt file
 *                and then utilizes my LibraryBook class to simulate a Library-like transaction.
 */
import java.util.*;
import java.io.*;
public class LibraryDriver
{
   public static void main(String[] args) throws FileNotFoundException
   {
      Scanner kb = new Scanner(System.in);
      LibraryBook[] books = new LibraryBook[7];
      books = fillArray(books);
      String askRepeat = "";
      boolean repeat = true;
      int choice;
   
      System.out.println("---------WECLOME TO THE CSUS LIBRARY---------");
      while (repeat)
      {
         do
         {
            //display the options to check in or check out a book
            System.out.println();
            System.out.println("Enter 1 to check out a book.");
            System.out.println("Enter 2 to return a book.");
            
            //get the user's choice
            System.out.print("\nPlease enter your choice: ");
            while (!kb.hasNextInt())
            {
               System.out.print("\nPlease Enter the valid choice, as shown above: ");
               kb.nextLine();
            }
            choice = kb.nextInt();
            kb.nextLine(); // clears the buffer
         } while (!(choice == 1 || choice == 2));   
      
         //if choice is 1
         if (choice == 1)
         {
            //display the books
            displayBooks(books);
            System.out.println();
            //call the method getChoice
            getChoice(books, kb);
            System.out.println();
         }
         //else
         else 
         {
            //display the books
            displayBooks(books);
            //call the method check in
            checkIn(books, kb);
         }
         //ask the user if there is another transaction
         
         do
         {
            System.out.print("Would you like another transaction? (y/n) ");
            askRepeat = kb.next();
            kb.nextLine();
         } while(!(askRepeat.equalsIgnoreCase("n") || askRepeat.equalsIgnoreCase("y")));
      
         if(askRepeat.equalsIgnoreCase("n"))
         {
            repeat = false;
         }
         else if(askRepeat.equalsIgnoreCase("y"))
         {
            repeat = true;
         }         
         // Did not verify for y, because repeat is already true. There's no point in reassigning the same value again.
      }
      System.out.println("The program will now close.");
   }
   public static void checkIn(LibraryBook[] books, Scanner kb)
   {
      System.out.print("\nEnter the id of the book you wish to return: ");
      boolean found = false;
      String id = kb.next();
      int i = 0;
      
      //as long as i is less than the length of the array book and found is false
      while(i < books.length && !found)
      {
         //get the id of the book at the index i
         if (books[i].getId().equals(id)) // Note: check if this makes sense.
         {
            //if the borrowed date and returned date is not null
            if (books[i].getBorrowedDate() != null && books[i].getReturnDate() != null)
            {
               //call the method setDateNull from the LibraryBook class to set the dates to null
               books[i].setDateNull();
               //set found to true
               found = true;
            }    
            //else if you find the book in the list and the returned date is null
            else
            {
               //output invalid id
               System.out.println("Invalid ID");
               //break out of the loop, not needed because we can utilize the boolean value; found
            }
         }   
         //update the index i   
         i++;
      }
      //if the book was not found
      if (!found)
      //display that the id for the book is invalid
         System.out.println("Invalid ID");
      else
         System.out.println("This book has been successfully returned");
   }
   //this method reads the info for the books from a file and stores it in the array
   public static LibraryBook[] fillArray(LibraryBook[] books) throws FileNotFoundException
   {
      File libraryData = new File("input.txt");
      Scanner reader = new Scanner(libraryData);
      
      int i = 0;
      while (i < books.length && reader.hasNextLine())
      {
         LibraryBook b = new LibraryBook(reader.nextLine(), reader.nextLine(), reader.nextLine());
      
         books[i] = b;
         i++;
      }
      return books;
   } 
   //this method displays the info about the books and their avaiability
   public static void displayBooks(LibraryBook[] books)
   {
      System.out.println("List of books: ");
      for (int i = 0; i < books.length; i++)
      {
         System.out.print((i+1) + ". " + books[i].toString());
         
         if (books[i].getReturnDate() == null)
            System.out.println(", Available");
         else
            System.out.println(", Not Available");
      }
   }
   //this method allows the user to choose a book from the list. as long as the selected book is checked out
   //the user will be prompted for a valid book 
   public static void getChoice(LibraryBook[] books, Scanner kb)
   {
      boolean found;
      
      System.out.println("Choose one of the available books,");
   
      int num = -1;
      do
      {
         System.out.print("Enter the number assosiated with the book: ");
         while (!kb.hasNextInt())
         {
            System.out.println("Invalid data, we wanted an integer.");
            System.out.print("Please enter a valid option: ");
            kb.nextLine();
         }   
         num = kb.nextInt();
         kb.nextLine();
         if (num > books.length || num < 1)
         {
            System.out.println("Invalid, we wanted a number between 1 and " + books.length);
            System.out.print("Please enter a valid option: ");
            num = kb.nextInt();
            kb.nextLine();
         }   
      }while (num > books.length || num < 1);
      
      
      // as long as the book is not available
      while (books[num - 1].getReturnDate() != null)
      {
         //display the due date for the selected book
         System.out.println("Sorry, the book is already taken.");
         System.out.println("The due date for this book is on: " + books[num - 1].getReturnDate());
         //ask the user to enter a new book number
         System.out.print("Please provide another book to look for: ");
         num = kb.nextInt();
         kb.nextLine();
         while (num > books.length || num < 1)
         {
            System.out.println("Sorry, there are no such books that we can find that fits your requirements.");
            System.out.print("Please enter a valid option: ");
            num = kb.nextInt();
            kb.nextLine();
         }   
      }
      
      // call the method setdateBorrowed and setDateReturn
      books[num - 1].setDateBorrowed();
      books[num - 1].setDateReturn();
      // display the info of the book that the user is borrowing
      System.out.println("\nYou have checked out:\n" + books[num - 1].toString());
      // display the return date for the book
      System.out.println("Return this book by: " + books[num - 1].getReturnDate());
   }
}
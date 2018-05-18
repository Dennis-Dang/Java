import java.util.*;
public class LibraryBook
{
   //declare all the instance variables such as title, author, borrower, id 
   
   private String title;
   private String author;
   private String borrower;
   private String id;
   
   private Date dateBorrowed;
   private Date dateReturn;
   //initilalize the instance variables using the parameter being passed to this method
   public LibraryBook(String t, String a, String i)
   {
      title = t;
      author = a;
      id = i;
   }
   //initialize the instance variable borrower to the new value
   public void borrowBook(String b)
   {
      borrower = b;
   } 
   public void setDateBorrowed()
   {
      Calendar calendar = Calendar.getInstance();
      dateBorrowed = calendar.getTime();
   }
   public void setDateReturn()
   {
      Calendar calendar = Calendar.getInstance();
      calendar.add(Calendar.DATE, 15);
      dateReturn = calendar.getTime();
   }
   //this method states both dateBorrowed and dateReturned to null which indicates that the book is avaiable
   public void setDateNull()
   {
      dateBorrowed = null;
      dateReturn = null;
   } 
   //accessor method returns the id
   public String getId()
   {
      return id;
   }
   //returns the date that the book was borrowed     
   public Date getBorrowedDate()
   {
       return dateBorrowed;
   }
   //returns the return date
   public Date getReturnDate()
   {
      return dateReturn; 
   } 
   //sets the borrower to null when the book is returned     
   public  void returnBook()
   {
      borrower = null;
   }
   //returns the title of the book 
   public String getTitle()
   {
      return title;
   }
   //returns the author of the book
   public String getAuthor()
   {
       return author;
   }
   public String getBorrower()
   {
      return borrower;
   }
   //compares two books, if they have the same id return true, otherwise return false
   public  boolean equals(LibraryBook b)
   {
      /* Alternate Code
      if (this.getId() == b.getId())
      {
         return true;
      }
      else
         return false;
      */
      
      return this.id.equals(b);
   }
   //returns a string representing a book, including the id, title and author
   public String toString()
   {
      String s = "";
      s = id + ", " + title + ", " + author;
      return s;
   }
}
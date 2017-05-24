import java.util.*;

public class PlayMemoryGame
{
   MemoryGameBoard game = new MemoryGameBoard();

   public static void main(String[] args)
   {
      // Declare Variables
      int bestScore; //Track player's best score; number of turns to find all matches
                     // Smaller the score, the better.

      int turnCount; //Tracking how many turns taking to find all matches
      int pairsLeft; //Tracking how many matching pairs still left to be found

      Scanner kb = new Scanner(System.in);
      MemoryGameBoard game = new MemoryGameBoard();
      boolean repeat = false;
      String askAgain = "";
      
      // Print Headings and Goal of Game
      System.out.println("CSC 15 - Dennis Dang");
      System.out.println("\nWelcome to the Memory Game.");
      System.out.println("The goal is to find all the matching pairs in as few turns as possible.");
      System.out.println("At each turn, select two different positions on the board to see if they match.");
      System.out.print("\nPress any key to start the game.");
      kb.nextLine();
      
      game.shuffleCards(); // Shuffle first, and then debug
      

      do
      {
         //game.shuffleCards();
         game.displayGameBoardValues(); // Debugging
         bestScore = 0;
         turnCount = 0;
         pairsLeft = (int)(Math.pow(MemoryGameBoard.BOARD_SIZE,2)/2);
         while (pairsLeft > 0) // While there are still pairs left to find in the game..
         {
            game.showBoard();
            System.out.println("Round: " + (++turnCount));
            int row1, col1, row2, col2;
            System.out.println("Where is the first card you wish to see?");
            row1 = getValidInt(kb, "Row: ", 1, MemoryGameBoard.BOARD_SIZE + 1);
            col1 = getValidInt(kb, "Col: ", 1, MemoryGameBoard.BOARD_SIZE + 1);
            System.out.println("Where is the second card you wish to see?");
            row2 = getValidInt(kb, "Row: ", 1, MemoryGameBoard.BOARD_SIZE + 1);
            col2 = getValidInt(kb, "Col: ", 1, MemoryGameBoard.BOARD_SIZE + 1);
            //Flip the 1st card, passing valid-offsetted col and row values.
            game.flipCard(row1, col1);
            //Flip the 1st card, passing valid-offsetted col and row values.
            game.flipCard(row2, col2);

            game.showBoard();
            if(game.cardsMatch(row1, col1, row2, col2))
            {
               System.out.println("MATCH");
               pairsLeft--;
            }
            else
            {
               System.out.println("No match found..");
               game.flipCard(row1, col1);
               game.flipCard(row2, col2);
            }
            System.out.print("Press Enter to advance to the next round.");
            kb.nextLine();
         }

         System.out.println("You finished this game in "+ turnCount + " moves.");
         
         if (bestScore != 0 && turnCount < bestScore) // Work on this
            System.out.println("Your best score: " + bestScore);
         else if (bestScore == 0)
            bestScore = turnCount;

         do
         {
            System.out.print("Do you want to play again? (y/n) ");
            askAgain = kb.next();
            kb.nextLine();
         } while (!(askAgain.equalsIgnoreCase("y") || askAgain.equalsIgnoreCase("n")));
         
         // Postcondition: it's safe to assume that askAgain is either y or n.
         if (askAgain.equalsIgnoreCase("y"))
         {
            repeat = true;
            game.shuffleCards();
         }
         else if (askAgain.equalsIgnoreCase("n"))
            repeat = false;
            
               
      } while(repeat);
      System.out.println("\nThank you for Playing.");
   }

   public static int getValidInt(Scanner kb, String prompt, int min, int max)
   {
      int num = -1;
      while(num < min || num > max)
      {
         System.out.print(prompt);
         if (kb.hasNextInt())
         {
            num = kb.nextInt();
            kb.nextLine();
         }
         else
         {
            kb.nextLine();
         }
      }
      return num;
   }
}
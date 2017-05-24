import java.util.Random;

public class MemoryGameBoard
{
   public static final int BOARD_SIZE = 4;
   public static final int NUM_SWAPS = 1000;

   // Creates the Board size, index is adjusted by one so that each starting row and collumn starts at 1.
   private Card[][] gameBoard = new Card[BOARD_SIZE + 1][BOARD_SIZE + 1];
   public MemoryGameBoard()
   {
      Card[][] gameBoard = new Card[BOARD_SIZE + 1][BOARD_SIZE + 1];
      initializeCards();
   }

   public void shuffleCards()
   {
      Random rand = new Random();
      Card temp;
      int row1,col1, row2, col2;
      turnCardsFaceDown();
      for (int i = 0; i < NUM_SWAPS; i++)
      {
         row1 = rand.nextInt(BOARD_SIZE) + 1;
         col1 = rand.nextInt(BOARD_SIZE) + 1;
         row2 = rand.nextInt(BOARD_SIZE) + 1;
         col2 = rand.nextInt(BOARD_SIZE) + 1;
      
         // Swap cards at random locations generated for row1, col1; row2, col2.
         temp = gameBoard[col1][row1];
         gameBoard[col1][row1] = gameBoard[col2][row2];
         gameBoard[col2][row2] = temp;
      }
   }
   
   // Hides, then reveals the board. (Mainly for the purposes of entering a new round.
   public void showBoard()
   {
      hideBoard();
      System.out.print(toString());
   }

   public boolean cardsMatch(int row1, int col1, int row2, int col2)
   {
      if (gameBoard[row1][col1].equals(gameBoard[row2][col2]))
         return true;
      else
         return false;
   }

   public boolean isFaceUp(int row, int col)
   {
      return gameBoard[row][col].isFaceUp();
   }

   public void flipCard(int row, int col)
   {
      gameBoard[row][col].flipCard();
   }
   
   // Prints the Board
   public String toString()
   {
      //String s = "    1 2 3 4"; // You still need to print out the col numbers, this is hard-coding
      String s = "    ";
      for (int rows = 1; rows < gameBoard.length; rows++)
      {
         s += " " + rows;
      }
      s += "\n    ";
      for (int rows = 1; rows < gameBoard.length*2; rows++)
      {
         s += "=";
      }
      s+= "\n";
   
      for (int rows = 1; rows < gameBoard.length; rows++)
      {
         s += (rows) + "  | ";
         for (int cols = 1; cols < gameBoard[rows].length; cols++)
         {
            s += gameBoard[rows][cols].toString() + " ";
         }
         s += "|\n";
      }
      s += "    ";
      
      for (int rows = 1; rows < gameBoard.length*2; rows++)      
      {
         s += "=";
      }
      s += "\n";
      return s;
   }
   
   // Sets all cards to a number.
   public void initializeCards()
   {
      int count = 1;
      for(int rows = 1; rows < gameBoard.length; rows++)
      {
         for (int cols = 1; cols < gameBoard[rows].length; cols++)
         {
            gameBoard[rows][cols] = new Card(count++);
            if (count == (BOARD_SIZE * 2)+1)
               count = 1;      
         }
      }
   }
   
   public void hideBoard()
   {
      for (int i = 0; i <= 8; i++)
      {
         System.out.println();
      }
   }
   
   public void turnCardsFaceDown()
   {
      for (int rows = 1; rows < gameBoard.length; rows++)
      {
         for (int cols = 1; cols < gameBoard[rows].length; cols++)
         {
            gameBoard[rows][cols].setFaceDown();
         }
      }
   }

   // For debug and testing purposes in dev.
   public void displayGameBoardValues()
   {
      System.out.println("Displaying Game Board Values.. [DEBUG TEST]");
      for (int rows = 1; rows < gameBoard.length; rows++)
      {
         for (int cols = 1; cols < gameBoard[rows].length; cols++)
         {
            gameBoard[rows][cols].setFaceUp();
         }
      }
      System.out.print(toString());
      turnCardsFaceDown();
   }

}
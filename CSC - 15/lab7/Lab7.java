import java.io.*;
import java.util.*;

public class Lab7
{
   public static void main(String[] args)
   throws FileNotFoundException 
   {
     String[] correct = new String[20];        //declare two arrays of String with the size 20
     String[] incorrect = new String[20];
     //description();                          //call the method description
           
     fillArray(correct, incorrect);            //call the method fillArray
     play(correct, incorrect );                //call the method play
   }
   public static void description()
   {
      System.out.println("");
      System.out.println("");
      System.out.println("");
      System.out.println("");
   }
   /*this method reads the file and fills in the array*/
   public static void fillArray(String[] correct, String[] incorrect)
   throws FileNotFoundException
   {
      File f = new File("one.txt"); // Under the current directory, look for one.txt
      Scanner good = new Scanner(f); // Read all of the values inside the file
      int i = 0;
      while(good.hasNext())
      {
         correct[i] = good.next();
         i++;
      }
      //System.out.println(Arrays.toString(correct));
      
      
      File g = new File("two.txt"); // Under the current directory, look for one.txt
      Scanner bad = new Scanner(g); // Read all of the values inside the file
      int j = 0;
      while(bad.hasNext())
      {
         incorrect[j] = bad.next();
         j++;
      }
      //System.out.println(Arrays.toString(incorrect));
      
      //create two file objects with the .txt file that you have
      //use scanner object to fill in the arrays
   }
   public static void play(String[] correct, String[] incorrect)
   {
      Scanner keyBoard = new Scanner(System.in);
      Random random = new Random();
      
      int point = 0;
      int correctAnswer = 0;
      String answer;
      int randnum = 0;
      int list = 0; //chooses if the word will be from the correct or incorrect list
      String replay = "y";
      int replayCorrect = 0;
      int timesplayed = 0; 
      String repeat = "y";
      
      while(repeat.equalsIgnoreCase("y"))
      {
        timesplayed = 0;
         while(replay.equals("y") && timesplayed  < 5)
         {   
            timesplayed++;
            randnum = random.nextInt(2); //generate a random number 0 or 1
            if (randnum == 0)            //if the random number is zero 
            {
                randnum = random.nextInt(20);   //generate a random number 0-19
                while (correct[randnum] == null)//as long as the array at the given index is null
                {
                      randnum = random.nextInt(20); //generate a random number 0-19
                }
                
                System.out.println("The word is: " + correct[randnum]);      //display the word at the index from the correct list
                System.out.println("Is the word spelled correctly? (y/n) "); //ask the user if it is spelled correctly
                answer = keyBoard.next();
                if (answer.equalsIgnoreCase("y"))
                {
                  System.out.println("Correct!");
                  correctAnswer++;
                  point++;
                }
                else if (answer.equalsIgnoreCase("n"))
                {
                  System.out.println("Incorrect!");
                  point--;
                }   
                correct[randnum] = null; //store null at the given index to remove the word from the lists
                //update the points earned based on the user's answer 
            } 
            
            else
            {
               randnum = random.nextInt(20);       //generate a random number 0-19
               while (incorrect[randnum] == null)  //as long as the array at the given index is null
               {
                     randnum = random.nextInt(20); //generate a random number 0-19
               }
                
               System.out.println("The word is: " + incorrect[randnum]); //display the word at the index from the correct list
               System.out.println("Is the word spelled correctly? (y/n) ");    //ask the user if it is spelled correctly
               answer = keyBoard.next();
               if (answer.equalsIgnoreCase("n"))
               {
                 System.out.println("Correct!");
                 correctAnswer++;
                 point++;
               }
               else if (answer.equalsIgnoreCase("y"))
               {
                  System.out.println("Incorrect!");
                  point--;
               }   
                 
               correct[randnum] = null; //store null at the given index to remove the word from the lists
               
               //update the points earned based on the user's answer
               
            }
            
        }
        
         if (timesplayed <= 5)//if the user played maximum number of times
         {
            System.out.println("You scored: " + point + " with " + correctAnswer + " correct answers.");
            System.out.println("You've played " + timesplayed + " times, give someone else a turn!"); //display the appropriate messages      
            System.out.print("Do you want to play again? "); //ask the user if she/he wants to play again
            replay = keyBoard.next();
            if (replay.equalsIgnoreCase("y"))
               {
               //reset all the needed variables   
                  replay = "y";
                  timesplayed = 0;
                  correctAnswer = 0;
                  point = 0;
               }
            else if (replay.equalsIgnoreCase("n"))
            {
               repeat = "n";
               replay = "n";
            }  
         }
               
      }   
   }
}
/*Sample output
 The word is: Token
 mis-spelled? y/n :y
 Incorrect!
 The word is: File
 mis-spelled? y/n :y
 Incorrect!
 Here is the word: Ermahgerd
 Mis-speeled?  y/n :y
 Correct!
 The word is: Throws
 mis-spelled? y/n :y
 Incorrect!
 The word is: Preceding
 mis-spelled? y/n :y
 Incorrect!
 You've played 5 times, give someone else a turn!
 You got 0 points.
 Would you like to play again? y/n 
 fdf
 Please enter "n" or "y".
 fddf
 Please enter "n" or "y".
 y
 Here is the word: Werd
 Mis-speeled?  y/n :y
 Correct!
 The word is: Numbers
 mis-spelled? y/n :n
 Correct!
 Here is the word: Werld
 Mis-speeled?  y/n :y
 Correct!
 Here is the word: Amurica
 Mis-speeled?  y/n :n
 Incorrect!!
 Here is the word: Unicron
 Mis-speeled?  y/n :n
 Incorrect!!
 You've played 5 times, give someone else a turn!
 You got 1 points.
 Would you like to play again? y/n 
 yes
 Please enter "n" or "y".
 y
 Here is the word: Incorect
 Mis-speeled?  y/n :y
 Correct!
 The word is: Program
 mis-spelled? y/n :n
 Correct!
 Here is the word: Progrems
 Mis-speeled?  y/n :y
 Correct!
 Here is the word: Fiyuhl
 Mis-speeled?  y/n :n
 Incorrect!!
 The word is: Exception
 mis-spelled? y/n :y
 Incorrect!
 You've played 5 times, give someone else a turn!
 You got 1 points.
 Would you like to play again? y/n 
 n
 
  ----jGRASP: operation complete.
 



*/
import java.io.*;
import java.util.*;

public class Alphabetizer
{
   public static void main(String[] args)
   throws FileNotFoundException{
      Scanner wordReader = new Scanner(new File("input.txt"));
      int count = 0;
      
      while (wordReader.hasNext())
      {
         wordReader.next();
         count++;
      }
      Scanner wordReader2 = new Scanner(new File("input.txt"));
      String[] wordList = new String[count];
      for (int i = 0; i < wordList.length; i++)
      {
         wordList[i] = wordReader2.next();
      }
      Arrays.sort(wordList);
      
      PrintStream wordWriter = new PrintStream(new File("output.txt"));
      for (int i = 0; i < wordList.length; i++)
      {
         wordWriter.println(wordList[i]);
      }   
   }
}         
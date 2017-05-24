public class Card
{
   private int value;
   private boolean faceUp;
   
   // Initializes value to initValue and faceUp to false
   public Card(int initValue)
   {
      value = initValue;
      faceUp = false;
      
   }
   
   // Returns the value of the instance variable value
   public int getValue()
   {
      return value;
   }
   
   // Returns the value of the variable faceUp
   public boolean isFaceUp()
   {
      return faceUp;
   }
   
   public void flipCard()
   {
      if (faceUp)
         faceUp = false;
      else
         faceUp = true;
          
   }
   
   public void setFaceUp()
   {
      faceUp = true;
   }
   
   public void setFaceDown()
   {
      faceUp = false;
   }
   
   public boolean equals(Card otherCard)
   {
      return (this.value == otherCard.value);
   }
   
   public String toString()
   {
      String s = "";
      if (faceUp)
         return s + value;
      else
         return "*";
   }
}      
public class Car
{
   //instance variables
   private String make;
   private String model;
   private int mile;
   private int mpg;
   
   //constructor
   public Car(String ma,String mo, int mi, int mp)
   {
    
     make = ma;
     model = mo;
     if(mi > 0) 
        mile = mi;
     else
     {
          System.out.println("Your milage is not valid"); 
     }        
     if(mp > 0)   
        mpg = mp;
     
   }
   // Mutator methods, mutate or change specific the state of the object.
   public void setMile(int m)
   {
     mile = m;
   }
   public void setModel(String m)
   {
      model = m;
   }
   public void setMake(String m)
   {
      make = m;
   }
   public void setMpg(int m)
   {
     mpg = m;
   }
   // Accessor methods, Access the state of the object and returns a value back for the user to see it.
   public String getMake()
   {
      return make;
   }
   
   public String getModel()
   {
      return model;
   }
   
   public int getMile()
   {
      return mile;
   }
   
   public int getMpg()
   {
      return mpg;
   }            
   public String toString()
   {
     String s = "";
     s = s + "\nMake: " + make;
     s = s + "\nModel: "+ model;
     s = s + "\nMilage: " + mile;
     s = s + "\nMPG: "+ mpg;
     return s;
   }
}
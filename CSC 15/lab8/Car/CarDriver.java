import java.util.*;
public class CarDriver
{
   
   public static void main(String[] args)
   {
     /*
     // Car[] cars = new Car[10];
     Car c = new Car("Honda","Accord",-100000,23);
     Car c1 = new Car("Toyota","Rav4", 23000,34);
     /*c.make = "Honda";
     c.model = "Accord";
     c.mile = -1000;
     c.mpg = 23;/
     //System.out.println(c);
     //System.out.println(c1);
     
     //c.setMile(10000);
     //System.out.println(c);
 
     // change the make of the car c to Ford
     c1.setMake("Ford");
     // output the object c
     System.out.println(c1);
     // change the model of the car c1 to civic
     c1.setModel("Civic");
     // output the object c1 on the screen
     System.out.println(c1);
     // create a new object with the state of your own car
     Car myCar = new Car("Toyota", "Corolla", 1000, 20);
     System.out.println(c1);
     System.out.println(myCar.getMake());
     System.out.println(c.getMile());
     System.out.println(myCar.getMpg());
     */
      Scanner kb = new Scanner(System.in);
      System.out.print("Enter total amt of cars: ");
      while(!kb.hasNextInt())
      {
         kb.nextLine();
         System.out.print("Enter total amt of cars: ");
      }
      int x = kb.nextInt();   
      // declare an array of Car with x amt of cars
      Car[] cars = new Car[x];
      //call the method fillArray to populate the Array of Car
      fillArray(cars, kb);
      print(cars);
   }
   
   public static void fillArray(Car[] cars, Scanner kb)
   {
      
      String model = "";
      String make = "";
      int mile;
      int mpg;
      for (int i = 0; i < cars.length; i++)
      {
         //get the model
         System.out.print("\nEnter a model: ");
         model = kb.next();
         //get the make
         System.out.print("Enter the make: ");
         make = kb.next();
         //get the mile
         System.out.print("Enter the mile: ");
         mile = kb.nextInt();
         //get the mpg
         System.out.print("Enter the mpg: ");
         mpg = kb.nextInt();
         //create an object of Car
         Car c = new Car(model, make, mile, mpg);
         //store the car refrence that you just created in the array
         cars[i] = c;
      }   
   }
   
   public static void print(Car[] cars)
   {
      System.out.print("\nHere are your cars: ");
      for (int i = 0; i < cars.length; i++)
      {
         System.out.print(cars[i].toString());
         System.out.println();
      }   
         
   }      
}   
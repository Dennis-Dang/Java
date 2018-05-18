public class output
{
   public static void main(String[] args)
   {
      System.out.println("TESTING CONSTRUCTORS:");
      Circle c1 = new Circle(0,0,1);
      System.out.println("No-Argument circle: " + c1.toString());
      Circle c2 = new Circle(15,25,50);
      System.out.println("Circle instantiated using center at (15, 25) and a radius of 50 is: " + c2.toString());
      Circle c3 = new Circle(15,25,-5);
      System.out.println("Circle instantiated using center at (15, 25) and a radius of -5 is: " + c3.toString());
      
      System.out.println("TESTING ACCESSOR METHODS:");
      System.out.println("x-coordinate of the center is: " + c3.getCenterX());
      System.out.println("y-coordinate of the center is: " + c3.getCenterY());
      System.out.println("radius is: " + c3.getRadius());
      System.out.println("perimeter is: " + c3.getPerimeter());
      System.out.println("area is: " + c3.getArea());
      
      System.out.println();
      
      System.out.println("TESTING MUTATOR METHODS:");
      System.out.println("After using the set methods to change the center to: (1,2) and the radius to 10:");
      c3.setCenterX(1);
      c3.setCenterY(2);
      c3.setRadius(10);
      System.out.println("The circle is: " + c3.toString());
      System.out.println("After changing the radius to -15:");
      c3.setRadius(-15);
      System.out.println("The circle is: " + c3.toString());
      
      System.out.println();
      
      System.out.println("TESTING EQUALS METHOD:");
      Circle c4 = new Circle(1,1,1);
      System.out.println("circle1 is: " + c4.toString());
      Circle c5 = new Circle(2,2,2);
      System.out.println("circle2 is: " + c5.toString());
      Circle c6 = new Circle(1,2,1);
      System.out.println("circle3 is: " + c6.toString());
      Circle c7 = new Circle(2,2,2);
      System.out.println("circle4 is: " + c7.toString());
      
      System.out.println();
      
      System.out.println("circle1 " + c4.printEquals(c5) + "circle2");
      System.out.println("circle1 " + c4.printEquals(c6) + "circle3");
      System.out.println("circle2 "+ c5.printEquals(c7) + "circle4");
   }
   
   
}
      
public class Circle
{
   // INSTANCE VARIABLES
   private double x;
   private double y;
   private double radius;
   
   // CONSTRUCTOR METHODS
   public Circle()
   {
      x = 0;
      y = 0;
      radius = 1;
   }
   public Circle(double initCenterX, double initCenterY, double initRadius)
   {
      this.x = initCenterX;
      this.y = initCenterY;
      this.radius = initRadius;
      
      if (initRadius >= 0)
      {
         this.radius = initRadius;
      }
      else
      {
         this.radius = 0;
      }
   }
   
   // ACCESSOR METHODS
   public double getCenterX()
   {
      return x;
   }
   
   public double getCenterY()
   {
      return y;
   }
   
   public double getRadius()
   {
      return radius;
   }
   
   public double getPerimeter()
   {
      return 2 * Math.PI * radius;
   }
   
   public double getArea()
   {
      return Math.PI * Math.pow(radius,2);
   }
   
   // MUTATOR METHODS
   public void setCenterX(double newCenterX)
   {
      x = newCenterX;
   }
   
   public void setCenterY(double newCenterY)
   {
      y = newCenterY;
   }
   
   public void setRadius(double newRadius)
   {
      if (newRadius >= 0)
      {
         this.radius = newRadius;
      }
      else
      {
         this.radius = 0;
      }
   }
   
   public boolean equals(Circle otherCircle)
   {
      return (this.radius == otherCircle.radius && this.x == otherCircle.x && this.y == otherCircle.y);
   }
   
   public String printEquals(Circle otherCircle)
   {
      if (equals(otherCircle)) return (" equals ");
         else return (" does not equal ");    
   }           
   public String toString()
   {
      String s = "";
      s += "Center: (" + x + ", " + y + ") Radius: " + radius;
      return s;
   }
}
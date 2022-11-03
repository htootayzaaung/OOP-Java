import java.util.Scanner;
public class Circle
{
    private double radius;

    public Circle(double r)
    {
        if (r <= 0)
        {
            throw new IllegalArgumentException("Invalid radius");
        }
        else 
        {
            radius = r;
        }
    }
    public Circle()
    {
        radius = 1.0;
    }
    public double getRadius ()
    {
        return radius;
    }
    public double area()
    {
        return Math.PI * Math.pow(radius, 2);
    }
    public double perimeter()
    {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString()
    {
        return String.format("Circle(radius=%.4f)", radius);
    }
    @Override
    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        else if (obj instanceof Circle)
        {
            Circle nextCircle = (Circle)obj;
            if (radius >= nextCircle.radius)
            {
                return ((radius - nextCircle.radius) < 0.00005);
            }
            else
            {
                return ((nextCircle.radius - radius) < 0.00005);
            }      
        }
        else 
        {
            return false;
        }
    }
}
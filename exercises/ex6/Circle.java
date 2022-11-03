import java.util.Scanner;
public class Circle
{
    private double radius;

    public Circle(double radius)
    {
        this.radius = radius;
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
}
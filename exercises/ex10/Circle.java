import java.io.IOException;
import java.io.Writer;

public class Circle implements Writeable 
{
	private double radius;

	public Circle(double radius) 
	{
		this.radius = radius;
	}
	public double getRadius() 
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
	public void writeTo(Writer destination) throws IOException 
	{
		String result = String.format("Circle: r=%.4f\n" , this.getRadius());  
		destination.write(result); 
	}
}

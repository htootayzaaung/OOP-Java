import java.util.Scanner;

public class Spheroid {
	public static void main(String[] agrs) 
	{
		
		System.out.print("Enter equatorial radius in km: ");
		Scanner input = new Scanner(System.in);
		double equatorial_radius = input.nextDouble();

		System.out.print("Enter polar radius in km: ");
		double polar_radius = input.nextDouble();
		
		double eccentricity = Math.sqrt((1 - (Math.pow(polar_radius, 2)/Math.pow(equatorial_radius, 2))));
		double volume = (4 * Math.PI * Math.pow(equatorial_radius, 2) * polar_radius) / 3;
		
		System.out.printf("Eccentricity = %.3f \n", eccentricity);
		System.out.printf("Volume = %g cubic km", volume);
	}
}

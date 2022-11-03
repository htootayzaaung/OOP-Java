import java.util.Scanner;

public class Weight {
	public static void main(String[] agrs) {
		System.out.print("Enter weight in kilograms: ");
		Scanner input = new Scanner(System.in);
		double kg = input.nextDouble();
		
		double total_lbs = kg * 2.20462;
		double kg_to_oz = ((kg * 2.20462) - Math.floor(kg /0.45359237));
		double actual_lbs = total_lbs - kg_to_oz;
		double difference = (int)actual_lbs;
		System.out.printf("Equivalent imperial weight is %.0f lb %.1f oz", difference, (kg_to_oz * 16));
	}
}

import java.util.Scanner;

public class CircleDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.print("Radius \t = ");
        double radius = sc.nextDouble();
        Circle mycircle = new Circle(radius);
        System.out.printf("Perimeter = %.3f \n", mycircle.perimeter());
        System.out.printf("Area \t = %.3f \n" ,mycircle.area());
    }
    
}


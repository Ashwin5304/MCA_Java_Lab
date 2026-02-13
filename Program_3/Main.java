import shapes.*;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the side of the square: ");
        double side = sc.nextDouble();
        Square s = new Square(side);

        System.out.println("Enter the base  of the triangle: ");
        double base = sc.nextDouble();
        System.out.println("Enter the height  of the triangle: ");
        double height = sc.nextDouble();
        Triangle t = new Triangle (base, height);

        System.out.println("Enter the radius of the circle: ");
        double radius = sc.nextDouble();
        Circle c = new Circle(radius);

        System.out.println(s.getArea());
        System.out.println(t.getArea());
        System.out.println(c.getArea());
        
        sc.close();
    }
}

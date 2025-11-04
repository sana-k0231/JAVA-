import java.util.Scanner;

class InputScanner {
    
    Scanner sc = new Scanner(System.in); 
    
    public int getInt(String message) {
        System.out.print(message);
        return sc.nextInt();
    }

    public double getDouble(String message) {
        System.out.print(message);
       
        return sc.nextDouble(); 
    }
}


abstract class Shape extends InputScanner {
    int dim1, dim2; 
    abstract void printArea(); 
}

class Rectangle extends Shape {
    void input() {
        dim1 = getInt("Enter length of rectangle: ");
        dim2 = getInt("Enter breadth of rectangle: ");
    }

    void printArea() {
        System.out.println("Area of Rectangle = " + (dim1 * dim2));
    }
}


class Triangle extends Shape {
    void input() {
        dim1 = getInt("Enter base of triangle: ");
        dim2 = getInt("Enter height of triangle: ");
    }

    void printArea() {
       
        double area = 0.5 * dim1 * dim2; 
        System.out.println("Area of Triangle = " + area);
    }
}


class Circle extends Shape {
    void input() {
        
        System.out.print("Enter radius (integer part) of circle: ");
        
        dim1 = sc.nextInt(); 
        
    }
    
    void printArea() {
       
        double area = Math.PI * dim1 * dim1; 
        System.out.println("Area of Circle = " + area);
    }
}


public class MainClass {
    public static void main(String[] args) {
        System.out.println("--- Rectangle ---");
        Rectangle rect = new Rectangle();
        rect.input();
        rect.printArea();

        System.out.println("\n--- Triangle ---");
        Triangle tri = new Triangle();
        tri.input();
        tri.printArea();

        System.out.println("\n--- Circle ---");
        Circle cir = new Circle();
        cir.input();
        cir.printArea();
    }
}
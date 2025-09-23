import java.util.Scanner;
class QUADRATIC{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("enter a");
        double a=sc.nextDouble();
        System.out.println("enter b");

        double b =sc.nextDouble();
        System.out.println("enter c");
        double c =sc.nextDouble();
        if(a==0){
            System.out.println("not a quadratic equation");
        }
        else{
            Double d;double r1;double r2;
            d=b*b-4*a*c;
            if(d==0){
                r1=(-b)/(2*a);
                System.out.println("roots are equal");
                System.out.println("roots are"+ r1);
            }
            else if(d>0){
                   System.out.println("Roots are real and distinct"); 
                    r1= (-(b) + Math.sqrt(d)) /(2*a);
                    r2 = (-(b)- Math.sqrt(d)) / (2*a);
                System.out.println("Root 1 is" + r1 +"and Root2 is" + r2);
            }
            else{
                System.out.println("Roots are imaginary");
                 r1 = (-b)/(2*a);
                 r2 = Math.sqrt(-d) / (2 * a);  
                 System.out.println("Root 1 is" + r1 +"and Root2 is" + r2);
                }
            }        
        }                       
    }
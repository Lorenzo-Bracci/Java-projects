
import java.util.Locale;
import java.util.Scanner;

public class Assignment2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		in.useLocale(Locale.US);
		System.out.println("lenght = ");
		double b = in.nextInt();
		System.out.println("altitude = ");
		double c = in.nextInt();
		double result = area (b,c);

		System.out.println("The area of the triangle is: " + result);
		
		System.out.println("adjactent side 1a = ");	
		double b1 = in.nextInt();
		System.out.println("adjactent side 1b = ");
		double c1 = in.nextInt();
		System.out.println("angle1 = ");
		double alpha = in.nextInt();
		double result1 = bisector (b1,c1,alpha);
		System.out.println("the bisector1 is: " + result1);
		
		System.out.println("adjactent side 2a = ");	
		double b5 = in.nextInt();
		System.out.println("adjactent side 2b = ");
		double c5 = in.nextInt();
		System.out.println("angle2 = ");
		double alpha5 = in.nextInt();
		double result5 = bisector (b5,c5,alpha5);
		System.out.println("the bisector2 is: " + result5);
		
		System.out.println("adjactent side 3a = ");	
		double b6 = in.nextInt();
		System.out.println("adjactent side 3b = ");
		double c6 = in.nextInt();
		System.out.println("angle3 = ");
		double alpha6 = in.nextInt();
		double result6 = bisector (b6,c6,alpha6);
		System.out.println("the bisector3 is: " + result6);
		/*
		System.out.println("adjactent side 2a = ");	
		double b2 = in.nextInt();
		System.out.println("adjactent side 2b = ");
		double c2 = in.nextInt();
		System.out.println("angle2 = ");
		double alpha2 = in.nextInt();
		double result2 = bisector (b2,c2,alpha2);
		System.out.println("the bisector2 is: " + result2);
		
		System.out.println("adjactent side 3a = ");	
		double b3 = in.nextInt();
		System.out.println("adjactent side 3b = ");
		double c3 = in.nextInt();
		System.out.println("angle3 = ");
		double alpha3 = in.nextInt();
		double result3 = bisector (b3,c3,alpha3);
		System.out.println("the bisector3 is: " + result3);
		*/ 
		
		

	}

	public static double area(double b, double c) {

		double area = (b * c) / 2;

		return area;
	}

	public static double bisector(double b1, double c1, double alpha) {
		double p = 2 * b1 * c1 * Math.cos(alpha / 2);
		double bis = p / (b1 + c1);
		return bis;
	}
	/*
	public static double bisector1(double b2, double c2, double alpha2) {
		double p1 = 2 * b2 * c2 * Math.cos(alpha2 / 2);
		double bis1 = p1 / (b2 + c2);
		return bis1;
	}
	public static double bisector2(double b3, double c3, double alpha3) {
		double p2 = 2 * b3 * c3 * Math.cos(alpha3 / 2);
		double bis2 = p2 / (b3 + c3);
		return bis2;
	}
	*/ 
}
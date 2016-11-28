import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class C4E2CircleDistance {
	public C4E2CircleDistance(){
		System.out.println("Enter point 1 (latitude and longitude) in degrees: ");
		Scanner input = new Scanner(System.in);
		
		boolean isCorrect = false;
		
		String point1 = input.nextLine();
		
		while(point1.indexOf(',')==-1 || point1.indexOf('(')!=-1 || point1.indexOf(')')!=-1){//there is no , in this line
			System.out.println("You should input a correct point coordinate");
			System.out.println("Using a comma and a space to seperate latitude and longitude without parentheses(like 0, 0): ");
			point1 = input.nextLine();
		}
		
		String[] i1 = point1.split(",");

		double x1 = Math.toRadians(Double.parseDouble(i1[0].trim())); //convert degree to radians
		double y1 = Math.toRadians(Double.parseDouble(i1[1].trim()));
		System.out.println("The coordinate of point 1 is: " + i1[0] + " " + i1[1]);
		
		System.out.println("Enter point 2 (latitude and longitude) in degrees: ");
		
		String point2 = input.nextLine();
		
		while(point2.indexOf(',')==-1 || point2.indexOf('(')!=-1 || point2.indexOf(')')!=-1){//there is no , in this line
			System.out.println("You should input a correct point coordinate");
			System.out.println("Using a comma and a space to seperate latitude and longitude without parentheses(like 0, 0): ");
			point2 = input.nextLine();
		}
		
		String[] i2 = point2.split(",");
		
		double x2 = Math.toRadians(Double.parseDouble(i2[0].trim())); //convert degree to radians
		double y2 = Math.toRadians(Double.parseDouble(i2[1].trim()));
		System.out.println("The coordinate of point 2 is: " + i2[0] + " " + i2[1]);
		
		double radius = 6371.01;
		double dis = radius * Math.acos(
				Math.sin(x1) * Math.sin(x2)
				+ Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));
		
		System.out.println("The distance between the two points is " + dis + " km");
		
	}

	public static void main(String[] args) {
		/*exercise 4.2 Great Circle Distance*/
		boolean repeat = true;
		System.out.println("Geometry: great circle distance");
		System.out.println("Count the circle distance between point1 and point2");
		
		while(repeat){
			C4E2CircleDistance c1 = new C4E2CircleDistance();
			int repeatInt = JOptionPane.showConfirmDialog(null, "Repeat Program?");
			if(repeatInt == JOptionPane.NO_OPTION) repeat = false;
		}
	}

}

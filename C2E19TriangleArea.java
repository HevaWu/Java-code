import java.text.DecimalFormat;
import java.util.Scanner;
import javax.swing.*;

public class C2E19TriangleArea {

	public static void main(String[] args) {
		//*exercise 2.19*/
		System.out.println("Geometry: area of a triangle");
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter three points for a triangle: ");
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		double x3 = input.nextDouble();
		double y3 = input.nextDouble();
		
		double side1 = Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
		double side2 = Math.sqrt(Math.pow(x2-x3, 2)+Math.pow(y2-y3, 2));
		double side3 = Math.sqrt(Math.pow(x3-x1, 2)+Math.pow(y3-y1, 2));
		
		if(side1+side2<=side3 || side1+side3<=side2 || side2+side3<=side1){
			System.out.println("These three points cannot be a triangle.");
			// JOptionPane.showMessageDialog(frame, "These three points cannot be a trangle.");
			return;
		}
		
		double s = (side1 + side2 + side3)/2;
		double area = Math.sqrt(
				s * (s - side1) * (s - side2) * (s-side3));
		
		DecimalFormat df = new DecimalFormat("0.0");
		System.out.println("The area of the triangle is " + df.format(area));
	}

}

import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class C3E32PointPosition {
	public C3E32PointPosition(){
		System.out.println("Enter three points for p0, p1, and p2: ");
		Scanner input = new Scanner(System.in);
		
		double x0 = input.nextDouble();
		double y0 = input.nextDouble();
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		
		double pos = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
		DecimalFormat df = new DecimalFormat("0.0");
		if(pos > 0){
			System.out.println("(" + df.format(x2) + ", " + df.format(y2) + ") is on the left side of the line from ("
					+ df.format(x0) + ", " + df.format(y0) + ") to (" + df.format(x1) + ", " + df.format(y1) + ")");
		} else if (pos == 0){
			System.out.println("(" + df.format(x2) + ", " + df.format(y2) + ") is on the line from ("
					+ df.format(x0) + ", " + df.format(y0) + ") to (" + df.format(x1) + ", " + df.format(y1) + ")");
		} else if (pos < 0){
			System.out.println("(" + df.format(x2) + ", " + df.format(y2) + ") is on the right side of the line from ("
					+ df.format(x0) + ", " + df.format(y0) + ") to (" + df.format(x1) + ", " + df.format(y1) + ")");
		}
	}

	public static void main(String[] args) {
		/*exercise 3.32 Geometry: point position*/
		boolean repeat = true;
		System.out.println("Geometry: point position");
		System.out.println("Check whether p2 is on the left of the line from p0 to p1, on the right, or on the same line");
		System.out.println("The line is defined by P1 and P2. P3 is the test point.");
		System.out.println("The test equation is: (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0)");
		
		while(repeat){
			C3E32PointPosition c1 = new C3E32PointPosition();
			int repeatInt = JOptionPane.showConfirmDialog(null, "Repeat Program?");
			if(repeatInt == JOptionPane.NO_OPTION) repeat = false;
		}
	}

}

import java.util.Scanner;

import javax.swing.JOptionPane;

public class C3E3LinearEquation {
	public C3E3LinearEquation(){
		System.out.println("Enter a, b, c, d, e, f: ");
		Scanner input = new Scanner(System.in);
		
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		double d = input.nextDouble();
		double e = input.nextDouble();
		double f = input.nextDouble();
		
		if(a * d - b * c == 0){
			System.out.println("The equation has no solution");
			return;
		} else {
			double x = (e * d - b * f) / (a * d - b * c);
			double y = (a * f - e * c) / (a * d - b * c);
			System.out.println("x is " + x + " and y is " + y);
		}
	}

	public static void main(String[] args) {
		/*exercise 3.3 Linear Equation*/
		boolean repeat = true;
		System.out.println("Algebra: solve 2 * 2 linear equations");
		System.out.println("The two equations are: ");
		System.out.println("  ax + by = e ");
		System.out.println("  cx + dy = f ");
		System.out.println("Start counting the value of x and y ");
		
		while(repeat){
			C3E3LinearEquation c1 = new C3E3LinearEquation();
			int repeatInt = JOptionPane.showConfirmDialog(null, "Repeat Program?");
			if(repeatInt == JOptionPane.NO_OPTION) repeat = false;
		}

	}

}

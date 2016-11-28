
public class C1E13SoleveLinearEquations {

	public static void main(String[] args) {
		//*exercise 1.13*/
		System.out.println("Algebrea: solve 2*2 linear equations: ");
		
		double a = 3.4, b = 50.2, e = 44.5,
				c = 2.1, d = 0.55, f = 5.9;
		
		System.out.println("The first equation is: " + 
				a + "x + " + b + "y = " + e);
		
		System.out.println("The second equation is: " + 
				c + "x + " + d + "y = " + f);
		
		double x = (e * d - b * f) / (a * d - b * c),
				y = (a * f - e * c) / (a * d - b * c);
		
		System.out.println("The value for x is: " + x);
		System.out.println("The value for y is: " + y);
		System.out.println();
	}

}

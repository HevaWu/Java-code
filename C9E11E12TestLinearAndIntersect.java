
import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class C9E11E12TestLinearAndIntersect {
	public C9E11E12TestLinearAndIntersect(){
		Scanner input = new Scanner(System.in);
		
		while(true){
			try{
				System.out.println("Enter number for what operation you want to do: ");
				System.out.println("   1: Exercise 9.11: Calculate 2 * 2 linear equations");
				System.out.println("   2: Exercise 9.12: Find intersecting point of two lines");	
				
				int operation = input.nextInt();
				
				if(operation == 1){
					System.out.println("Algebra: solve 2 * 2 linear equations");
					System.out.println("The two equations are: ");
					System.out.println("  ax + by = e ");
					System.out.println("  cx + dy = f ");
					System.out.println("Start counting the value of x and y ");
					
					double a = 1.0, b = 1.0, c = 1.0, d = 1.0, e = 1.0, f = 1.0;
					while(true){
						try{
							System.out.println("Enter a, b, c, d, e, f(use space to seperate each of them): ");
							a = input.nextDouble();
							b = input.nextDouble();
							c = input.nextDouble();
							d = input.nextDouble();
							e = input.nextDouble();
							f = input.nextDouble();
							break;
						} catch(Exception error){
							System.out.println("You should input a double number");
							input.nextLine();
						}
					}
					
					C9E11E12LinearAndIntersect l1 = new C9E11E12LinearAndIntersect(a,b,c,d,e,f);
					l1.print();
					
					if(!l1.isSolvable()){
						System.out.println("The equation has no solution");
					} else {
						double x = l1.getX();
						double y = l1.getY();
						System.out.println("x is " + x + " and y is " + y);
					}
					System.out.println();
					break;
					
				} else if(operation == 2){
					System.out.println("Geometry: Find intersecting point of two lines");
					System.out.println("Two points on line 1 are given as (x1,y1) and (x2,y2)");
					System.out.println("Two poitns on line 2 are given as (x3,y3) and (x4,y4)");
					System.out.println("The two lines are: ");
					System.out.println("  (y1-y2)x - (x1-x2)y = (y1-y2)x1 - (x1-x2)y1 ");
					System.out.println("  (y3-y4)x - (x3-x4)y = (y3-y4)x3 - (x3-x4)y3 ");
					System.out.println("If there is a intersecting point, we will output the point(x,y)");
					System.out.println("If not, then these two lines are parallel");
					System.out.println("Start counting the intersecting point(x,y) of two lines");
					
					double x1 = 1.0, x2 = 1.0, x3 = 1.0, x4 = 1.0;
					double y1 = 1.0, y2 = 1.0, y3 = 1.0, y4 = 1.0;
					while(true){
						try{
							System.out.println("Enter x1, y1, x2, y2, x3, y3, x4, y4(use space to seperate each of them): ");
							x1 = input.nextDouble();
							y1 = input.nextDouble();
							x2 = input.nextDouble();
							y2 = input.nextDouble();
							x3 = input.nextDouble();
							y3 = input.nextDouble();
							x4 = input.nextDouble();
							y4 = input.nextDouble();
							break;
						} catch(Exception error){
							System.out.println("You should input a double number");
							input.nextLine();
						}
					}
					
					double a = y1-y2;
					double b = x2-x1;
					double c = y3-y4;
					double d = x4-x3;
					double e = (y1-y2)*x1 - (x1-x2)*y1;
					double f = (y3-y4)*x3 - (x3-x4)*y3;
					
					C9E11E12LinearAndIntersect l2 = new C9E11E12LinearAndIntersect(a,b,c,d,e,f);
					l2.print();
					
					if(!l2.isSolvable()){
						System.out.println("The two lines are parallel");
					} else {
						double x = l2.getX();
						double y = l2.getY();
						System.out.println("The intersecting point is at (" + x + ", " + y + ")");
					}
					System.out.println();
					break;
					
				} 
			} catch(Exception e){
				System.out.println("Please input 1 or 2");
				input.nextLine();
			}
		}
	}

	public static void main(String[] args) {
		/* exercise 9.11 Algebra: 2 * 2 linear equations
		 * exercise 9.12 Geometry: intersecting point*/
		
		boolean repeat = true;
		while(repeat){
			C9E11E12TestLinearAndIntersect c1 = new C9E11E12TestLinearAndIntersect();
			int repeatInt = JOptionPane.showConfirmDialog(null, "Repeat Program?");
			if(repeatInt == JOptionPane.NO_OPTION) repeat = false;
		}

	}

}

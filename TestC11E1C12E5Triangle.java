import java.util.Scanner;

import javax.swing.JOptionPane;

public class TestC11E1C12E5Triangle {
	public TestC11E1C12E5Triangle(){
		System.out.println("User Test: ");
		System.out.println("Enter a triangle param for test");

		Scanner input = new Scanner(System.in);
		C11E1C12E5Triangle tria = new C11E1C12E5Triangle();
		
		while(true){
			double side1 = 1.0;
			while(true){
				try{
					System.out.println("Enter the side1 of this triangle: ");
					side1 = input.nextDouble();
					try{
						tria.setSide1(side1);
						System.out.println("Set Triangle Side1 Success");
						break;
					} catch (Exception e){
						System.out.println("Set Triangle Side1 Fail, Throw Exception: " + tria.getErrorMessage());
					}
				} catch(Exception e){
					System.out.println("You should input a double number");
					input.nextLine();
				}
			}
			double side2 = 1.0;
			while(true){
				try{
					System.out.println("Enter the side2 of this triangle: ");
					side2 = input.nextDouble();
					try{
						tria.setSide2(side2);
						System.out.println("Set Triangle Side2 Success");
						break;
					} catch (Exception e){
						System.out.println("Set Triangle Side2 Fail, Throw Exception: " + tria.getErrorMessage());
					}
				} catch(Exception e){
					System.out.println("You should input a double number");
					input.nextLine();
				}
			}
			
			double side3 = 1.0;
			while(true){
				try{
					System.out.println("Enter the side3 of this triangle: ");
					side3 = input.nextDouble();
					try{
						tria.setSide1(side3);
						System.out.println("Set Triangle Side3 Success");
						break;
					} catch (Exception e){
						System.out.println("Set Triangle Side3 Fail, Throw Exception: " + tria.getErrorMessage());
					}
				} catch(Exception e){
					System.out.println("You should input a double number");
					input.nextLine();
				}
			}
			
			try{
				tria = new C11E1C12E5Triangle(side1, side2, side3);
				System.out.println("Current " + tria.toString());
				break;
			}catch(Exception e){
				System.out.println(e);
			}
		}
		
		while(true){
			System.out.println("Want to set the color for this triangle? (Y/N)(Y for Yes, N for No)");
			String ifcolor = input.next().trim();
			input.nextLine();
			if(ifcolor.equals("Y")){
				System.out.println("Input the color of this triangle: ");
				String color = input.next();
				tria.setColor(color);
				break;
			} else if(ifcolor.equals("N")){
				break;
			} else {
				System.out.println("You should input Y or N");
			}
		}
		
		while(true){
			System.out.println("Does this triangle filled? (T/F)(T for True, F for False)");
			String iffill = input.next().trim();
			input.nextLine();
			if(iffill.equals("T")){
				tria.setFilled(true);
				break;
			} else if(iffill.equals("F")){
				tria.setFilled(false);
				break;
			} else {
				System.out.println("You should input T or F");
			}
		}
		
		tria.print();
		System.out.println("The area of this triangle is: " + tria.getArea());
		System.out.println("The perimeter of this triangle is: " + tria.getPerimeter());
		
	}
	
	public static void main(String[] args) {
		/* Exercise 11.1 The Triangle class
		 * Exercise 12.5 IllegalTriangleException*/
		
		System.out.println("Exercise 11.1 The Triangle class");
		System.out.println("Exercise 12.5 Illegal Triangle Exception");
		
		System.out.println("Input three sides of a triangle, a color, and a boolean value to indicate whether the triangle is filled");
		System.out.println("Program will output the area, peimeter, color and true or false to indicate wheter this triangle is filled or not");
		System.out.println("For example: if the input triangle is (3, 4, 5, blue, true)(side1 = 3, side2 = 4, side3 = 5, color = blue, filled = true(is filled))");
		System.out.println("             this triangle is valid, program will output its area(6), perimeter(12), color(blue), filled(true)");
		System.out.println("             if the input triangle is invalid, program will show the invalid message");
		
		boolean repeat = true;
		while(repeat){
			TestC11E1C12E5Triangle c1 = new TestC11E1C12E5Triangle();
			int repeatInt = JOptionPane.showConfirmDialog(null, "Repeat Program?");
			if(repeatInt == JOptionPane.NO_OPTION) repeat = false;
		}
	}
}

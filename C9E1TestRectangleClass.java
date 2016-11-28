import java.util.Scanner;

import javax.swing.JOptionPane;

public class C9E1TestRectangleClass {
	public C9E1TestRectangleClass(){
		System.out.println("User Test: ");
		System.out.println("This program is to count the Area and Perimeter of a Rectangle");
		Scanner input = new Scanner(System.in);
		C9E1RectangleClass rec = new C9E1RectangleClass();
			
		double width = 1.0;
		while(true){
			try{
				System.out.println("Enter the width for a Rectangle: ");
				width = input.nextDouble();
				try{
					rec.setWidth(width);
					System.out.println("Set Rectangular Width Success");
					break;
				} catch (Exception e){
					System.out.println("Set Rectangular Width Fail, Throw Exception: " + rec.getErroeMessage());
				}
			} catch(Exception e){
				System.out.println("You should input a double number");
				input.nextLine();
			}
		}
		
		double height = 1.0;
		while(true){
			try{
				System.out.println("Enter the height for a Rectangle: ");
				height = input.nextDouble();
				try{
					rec.setHeight(height);
					System.out.println("Set Rectangular Height Success");
					break;
				} catch (Exception e){
					System.out.println("Set Rectangular Height Fail, Throw Exception: " + rec.getErroeMessage());
				}
			} catch(Exception e){
				System.out.println("You should input a double number");
				input.nextLine();
			}
		}

		System.out.println("Currecnt Rectangular Information: ");
		rec.print();
		
		System.out.println("The area of this rectangular is: " + rec.getArea());
		System.out.println("The perimeter of this rectangular is: " + rec.getPerimeter());
		System.out.println();
	}
	
	public static void main(String[] args) {
		/*exercise 9.1 The Rectangle Class*/
		
		System.out.println("Exercise 9.1 The Rectangle Class");
		
		run();
		boolean repeat = true;
		while(repeat){
			C9E1TestRectangleClass c1 = new C9E1TestRectangleClass();
			int repeatInt = JOptionPane.showConfirmDialog(null, "Repeat Program?");
			if(repeatInt == JOptionPane.NO_OPTION) repeat = false;
		}
	}
	
	public static void run(){
		System.out.println("Before users test, we first check two rectangles in exercise 9-1");
		System.out.println("Rectangle1: Width 4, Height 40");
		C9E1RectangleClass rec1 = new C9E1RectangleClass();
		double width1 = 4;
		double height1 = 40;
		try{
			rec1.setWidth(width1);
			System.out.println("Set Rectangular Width Success");
		} catch (Exception e){
			System.out.println("Set Rectangular Width Fail, Throw Exception: " + rec1.getErroeMessage());
		}
		try{
			rec1.setHeight(height1);
			System.out.println("Set Rectangular Height Success");
		} catch (Exception e){
			System.out.println("Set Rectangular Height Fail, Throw Exception: " + rec1.getErroeMessage());
		}
		System.out.println("Currecnt Rectangular Information: ");
		rec1.print();
		System.out.println("The area of this rectangular is: " + rec1.getArea());
		System.out.println("The perimeter of this rectangular is: " + rec1.getPerimeter());
		System.out.println();	
		
		System.out.println("Rectangle2: Width 3.5, Height 35.9");
		C9E1RectangleClass rec2 = new C9E1RectangleClass();
		double width2 = 3.5;
		double height2 = 35.9;
		try{
			rec2.setWidth(width2);
			System.out.println("Set Rectangular Width Success");
		} catch (Exception e){
			System.out.println("Set Rectangular Width Fail, Throw Exception: " + rec2.getErroeMessage());
		}
		try{
			rec2.setHeight(height2);
			System.out.println("Set Rectangular Height Success");
		} catch (Exception e){
			System.out.println("Set Rectangular Height Fail, Throw Exception: " + rec2.getErroeMessage());
		}
		System.out.println("Currecnt Rectangular Information: ");
		rec2.print();
		System.out.println("The area of this rectangular is: " + rec2.getArea());
		System.out.println("The perimeter of this rectangular is: " + rec2.getPerimeter());
		System.out.println();
	}
}

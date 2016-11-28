import java.util.Scanner;

import javax.swing.JOptionPane;

public class TestC10E13Rectangle2D {
	public TestC10E13Rectangle2D(){
		System.out.println("User Test: ");
		Scanner input = new Scanner(System.in);
		
		while(true){
			System.out.println();
			System.out.println("Enter a original rectangle for test");
			C10E13Rectangle2D rec = new C10E13Rectangle2D();
			
			double x = 0.0;
			while(true){
				try{
					System.out.println("Enter x-axes of this rectangle: ");
					x = input.nextDouble();
					rec.setX(x);
					System.out.println("Set X Success");
					break;
				} catch(Exception e){
					System.out.println("You should input a double number");
					input.nextLine();
				}
			}
			
			double y = 0.0;
			while(true){
				try{
					System.out.println("Enter y-axes of this rectangle: ");
					y = input.nextDouble();
					rec.setY(y);
					System.out.println("Set Y Success");
					break;
				} catch(Exception e){
					System.out.println("You should input a double number");
					input.nextLine();
				}
			}
			
			double width = 1.0;
			while(true){
				try{
					System.out.println("Enter the width of this rectangle: ");
					width = input.nextDouble();
					try{
						rec.setWidth(width);
						System.out.println("Set Rectangular Width Success");
						break;
					} catch (Exception e){
						System.out.println("Set Rectangular Width Fail, Throw Exception: " + rec.getErrorMessage());
					}
				} catch(Exception e){
					System.out.println("You should input a double number");
					input.nextLine();
				}
			}
			
			double height = 1.0;
			while(true){
				try{
					System.out.println("Enter the height of this rectangle: ");
					height = input.nextDouble();
					try{
						rec.setHeight(height);
						System.out.println("Set Rectangular Height Success");
						break;
					} catch (Exception e){
						System.out.println("Set Rectangular Height Fail, Throw Exception: " + rec.getErrorMessage());
					}
				} catch(Exception e){
					System.out.println("You should input a double number");
					input.nextLine();
				}
			}
			
			System.out.println("Original Rectangle Information: ");
			System.out.println(rec.toString());
			
			System.out.println("The area of this rectangular is: " + rec.getArea());
			System.out.println("The perimeter of this rectangular is: " + rec.getPerimeter());
			
			
			while(true){
				System.out.println();
				
				System.out.println("Please input a point for test(Point can be inside or out of the original rectangle): ");
				double xx = 0.0;
				while(true){
					try{
						System.out.println("Enter x-axes of this point: ");
						xx = input.nextDouble();
						break;
					} catch(Exception e){
						System.out.println("You should input a double number");
						input.nextLine();
					}
				}
				
				double yy = 0.0;
				while(true){
					try{
						System.out.println("Enter y-axes of this point: ");
						yy = input.nextDouble();
						break;
					} catch(Exception e){
						System.out.println("You should input a double number");
						input.nextLine();
					}
				}
				
				System.out.println("The point you input is (" + xx + "," + yy + ")");
				boolean ifpoint = rec.contains(xx, yy);
				System.out.println(rec.getContainMessage());
				
				System.out.println();
				System.out.println("Please input a rectangle for test(check if the input rectangle is INSIDE, OVERLAP, EQUAL to original rectangle): ");
				C10E13Rectangle2D rec1 = new C10E13Rectangle2D();
				
				double x1 = 0.0;
				while(true){
					try{
						System.out.println("Enter x-axes for test rectangle: ");
						x1 = input.nextDouble();
						rec1.setX(x1);
						System.out.println("Set X Success");
						break;
					} catch(Exception e){
						System.out.println("You should input a double number");
						input.nextLine();
					}
				}
				
				double y1 = 0.0;
				while(true){
					try{
						System.out.println("Enter y-axes for test rectangle: ");
						y1 = input.nextDouble();
						rec1.setY(y1);
						System.out.println("Set Y Success");
						break;
					} catch(Exception e){
						System.out.println("You should input a double number");
						input.nextLine();
					}
				}
				
				double width1 = 1.0;
				while(true){
					try{
						System.out.println("Enter the width for test rectangle: ");
						width1 = input.nextDouble();
						try{
							rec1.setWidth(width1);
							System.out.println("Set Rectangular Width Success");
							break;
						} catch (Exception e){
							System.out.println("Set Rectangular Width Fail, Throw Exception: " + rec1.getErrorMessage());
						}
					} catch(Exception e){
						System.out.println("You should input a double number");
						input.nextLine();
					}
				}
				
				double height1 = 1.0;
				while(true){
					try{
						System.out.println("Enter the height for test rectangle: ");
						height1 = input.nextDouble();
						try{
							rec1.setHeight(height1);
							System.out.println("Set Rectangular Height Success");
							break;
						} catch (Exception e){
							System.out.println("Set Rectangular Height Fail, Throw Exception: " + rec1.getErrorMessage());
						}
					} catch(Exception e){
						System.out.println("You should input a double number");
						input.nextLine();
					}
				}
				
				System.out.println("The test rectangle you input is " + rec1.toString());
				System.out.println("The area of test rectangular is: " + rec1.getArea());
				System.out.println("The perimeter of test rectangular is: " + rec1.getPerimeter());
				
				boolean ifrec = rec.overlaps(rec1);
				System.out.println(rec.getOverMessage());
				
				boolean ifcontinueCur = true;
				while(true){
					System.out.println();
					System.out.println("Do you want to test the position of a point and another rectangle in original rectangle? (Y/N)(Y for Yes, N for No)");
					String iftest = input.next().trim();
					input.nextLine();
					if(iftest.equals("Y")){
						ifcontinueCur = true;
						break;
					} else if(iftest.equals("N")){
						ifcontinueCur = false;
						break;
					} else {
						System.out.println("You should input Y or N");
					}
				}
				
				if(ifcontinueCur){
					continue;
				} else {
					break;
				}
			}
			
			boolean ifdoanother = true;
			while(true){
				System.out.println();
				System.out.println("Do you want to try again for changing original rectangle? (Y/N)(Y for Yes, N for No)");
				String diffString = input.next().trim();
				input.nextLine();
				if(diffString.equals("Y")){
					ifdoanother = true;
					break;
				} else if(diffString.equals("N")){
					ifdoanother = false;
					break;
				} else {
					System.out.println("You should input Y or N");
				}
			}
			
			if(ifdoanother){
				continue;
			} else {
				break;
			}
		}
	}

	public static void main(String[] args) {
		/*exercise 10.13 Geometry: the MyRectangle2D class*/
		
		System.out.println("Exercise 10.13 Geometry: the MyRectangle2D class");
		System.out.println("Input a rectangle, output its area and perimeter, and check if it contains a point or contains/overlap another rectangle");
		System.out.println("First, input a valid rectangle(its x-axes, y-axes, width and height)(width>0 height>0)");
		System.out.println("Then, choose which you want to test, points or rectangle");
		System.out.println("      If you choose point, input the point(x-axes, y-axes)");
		System.out.println("      If you choose rectangel, input a valid test rectangle(its x-axes, y-axes, width and height)(width>0 height>0)");
		System.out.println("The program will output the result");
		System.out.println("For example: if the input rectangle is (2, 2, 4, 4)(x=2, y=2, width=4, height=4)(this rectangle is covered by (0,0) (4,0) (0,4) (4,4) )");
		System.out.println("             this rectangle is valid, program will output its area(16) and perimeter(16)");
		System.out.println("             if you want to test a point, input the point (1, 1)(x=1, y=1), program will output \"This point INSIDE the rectangle\"");
		System.out.println("             if you want to test a rectangle, input the rectangle (1, 1, 4, 4)(x=1, y=1, width=4, height=4)(this rectangle is covered by (-1,-1) (3,-1) (-1,3) (3,3) )");
		System.out.println("             program will output two rectangle OVERLAPS");
		System.out.println("             if the input rectangle is invalid, program will show the invalid message");
		
		boolean repeat = true;
		while(repeat){
			TestC10E13Rectangle2D c1 = new TestC10E13Rectangle2D();
			int repeatInt = JOptionPane.showConfirmDialog(null, "Repeat Program?");
			if(repeatInt == JOptionPane.NO_OPTION) repeat = false;
		}
	}

}

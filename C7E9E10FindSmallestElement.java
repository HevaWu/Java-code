import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class C7E9E10FindSmallestElement {
	private int Number_of_Items = 10;
	
	public static double min(double[] array){
		double minNumber = array[0];
		for(int i = 1; i < array.length; ++i){
			if(array[i] < minNumber){
				minNumber = array[i];
			}
		}
		return minNumber;
	}
	
	public static int indexOfSmallestElement(double[] array){
		int minIndex = 0; //search from the start of array
		double minNumber = array[0];
		for(int i = 1; i < array.length; ++i){
			if(array[i] < minNumber){
				minIndex = i;
				minNumber = array[i];
			}
		}
		return minIndex;
	}
	
	public C7E9E10FindSmallestElement(){
		boolean correctInput = true;
		
		while(correctInput){
			System.out.println("Enter number for what operation you want to do: ");
			System.out.println("   1: Exercise 7.9:  Find the smallest element in an array, return the smallest number");
			System.out.println("   2: Exercise 7.10: Find the index of the smallest element in an array, return the index and smallest number");
			System.out.println("                     If this array contains duplicates smallest element, return the smallest index");
			
			Scanner input = new Scanner(System.in);
			int operation = input.nextInt();
			boolean isCorrect = false;
			
			if (operation == 1){
				//Find the smallest element in an array
				System.out.println();
//				int Number_of_Items = 10; //test ten numbers
				System.out.println("Enter ten numbers for test(seperate each number for one space): ");
				double[] testArray = new double[Number_of_Items];
				for(int i = 0; i < Number_of_Items; ++i){
					testArray[i] = input.nextDouble();
				}
				double minNumber = min(testArray);
				System.out.println("The smallest number is: " + minNumber);
				System.out.println();
				
			} else if(operation == 2){
				//Find the index of the smallest element in an array
				System.out.println();
//				int Number_of_Items = 10; //test ten numbers
				System.out.println("Enter ten numbers for test(seperate each number for one space): ");
				double[] testArray = new double[Number_of_Items];
				for(int i = 0; i < Number_of_Items; ++i){
					testArray[i] = input.nextDouble();
				}
				int minIndex = indexOfSmallestElement(testArray);
				System.out.println("The index of the smallest number is: " + minIndex);
				System.out.println("The correspond smallest number is: " + testArray[minIndex]);
				System.out.println();
				
			} else {
				System.out.println("Please input 1 or 2");
				isCorrect = true;
			}
			correctInput = isCorrect;
		}

	}

	public static void main(String[] args) {
		/*exercise 7.9 Find the smallest element
		 *exercise 7.10 Find the index of the smallest element*/
		
		System.out.println("Exercise 7.9 & 7.10 Find the smallest element and its index");
		boolean repeat = true;
		while(repeat){
			C7E9E10FindSmallestElement c1 = new C7E9E10FindSmallestElement();
			int repeatInt = JOptionPane.showConfirmDialog(null, "Repeat Program?");
			if(repeatInt == JOptionPane.NO_OPTION) repeat = false;
		}
	}

}

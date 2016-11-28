import java.util.Scanner;

import javax.swing.JOptionPane;

public class C7E20ReviseSelectionSort {
	public static void reviseSelectionSort(double[] array){
		for(int i = array.length-1; i >= 0; --i){
			//Find the largest numbers in array
			double curMax = array[i];
			int curMaxIndex = i;
			
			for(int j = 0; j <= i; ++j){
				if(curMax < array[j]){
					curMax = array[j];
					curMaxIndex = j;
				}
			}
			
			//swap the largest number with the last
			if(curMaxIndex != i){
				array[curMaxIndex] = array[i];
				array[i] = curMax;
			}
		}
	}
	
	public C7E20ReviseSelectionSort(){
		System.out.println("Sort the array using revise selection sort. ");
		System.out.println("Enter ten numbers for test(seperate each number for one space): ");
		
		Scanner input = new Scanner(System.in);
		int Number_of_Items = 10; //enter ten numbers for test
		double[] testArray = new double[Number_of_Items];
		for(int i = 0; i < Number_of_Items; ++i){
			testArray[i] = input.nextDouble();
		}
		
		System.out.println("The array before sort is: ");
		for(int i = 0; i < testArray.length; ++i){
			System.out.print(testArray[i] + " ");
		}
		System.out.println();
		
		reviseSelectionSort(testArray);
		System.out.println("The array after sort is: ");
		for(int i = 0; i < testArray.length; ++i){
			System.out.print(testArray[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		/*exercise 7.20 Revise Selection Sort*/
		
		System.out.println("Exercise 7.20 Revise Selection Sort");
		boolean repeat = true;
		while(repeat){
			C7E20ReviseSelectionSort c1 = new C7E20ReviseSelectionSort();
			int repeatInt = JOptionPane.showConfirmDialog(null, "Repeat Program?");
			if(repeatInt == JOptionPane.NO_OPTION) repeat = false;
		}
	}

}

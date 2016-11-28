import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class C5E16C5E20C6E10DisplayPrime {
	public class CountPrime{
		private List<Integer> factor;
		private List<Integer> prime;
		
		public CountPrime(){
			factor = new ArrayList<Integer>();
			prime = new ArrayList<Integer>();
		}
		
		public List<Integer> getFactor(){
			return factor;
		}
		
		public List<Integer> getPrime(){
			return prime;
		}
		
		public void countPrime(int a, int b){
			//search the prime number between a and b
			for(int i = a; i <= b; ++i){
				boolean isPrime = isPrime(i);
				if(isPrime){
					prime.add(i);
				}
			}
		}
		
		public int countPrime(int a){
			//search the prime number under a
			final int NUMBER_OF_PRIMES = 1000; //count only the first 1000
			int count = 0;
			for(int i = 2; i <= a; ++i){
				boolean isPrime = isPrime(i);
				if(isPrime){
					if(count < NUMBER_OF_PRIMES){
						prime.add(i);
					}
					count++;
				}
			}
			return count;
		}
		
		public void countFactor(int a){
			//search the factor of number a
			for(int i = 2; i <= a; ++i){
				while(a % i == 0){
					a = a / i;
					factor.add(i);    //this number is a factor of a
//					System.out.println(i + " " + a);
				}
			}
		}
		
		public boolean isPrime(int n){
			//check if number n is a prime number
			for(int i = 2; i <= n/2; ++i){
				if(n % i == 0){
					return false;
				}
			}
			return true;
		}
	}

	public C5E16C5E20C6E10DisplayPrime(){
		boolean correctInput = true;
		
		while(correctInput){
			System.out.println("Enter number for what operation you want to do: ");
			System.out.println("   1: Exercise 5.16: Find the factors of an integer");
			System.out.println("   2: Exercise 5.20: Display prime numbers between 2 and 1000");
			System.out.println("   3: Exercise 6.10: Find the number of prime numbers less than 10000");
			
			Scanner input = new Scanner(System.in);
			int operation = input.nextInt();
			boolean isCorrect = false;
			
			if(operation == 1){
				//Find the factors of an integer
				System.out.println();
				System.out.println("Start finding the factors of an integer");
				System.out.println("Enter an integer: ");
				int number = input.nextInt();
				CountPrime p1 = new CountPrime();
				p1.countFactor(number);
				List<Integer> factorP1 = p1.getFactor();
				Object[] arrP1 = factorP1.toArray();
				System.out.println("Display all factors of " +  number + " in increasing order");
				System.out.println(Arrays.toString(arrP1));
				System.out.println();
				
			} else if(operation == 2){
				//Display prime numbers between 2 and 1000
				System.out.println();
				CountPrime p2 = new CountPrime();
				p2.countPrime(2, 1000);
				List<Integer> primeP2 = p2.getPrime();
				Object[] arrP2 = primeP2.toArray();
				System.out.println("Display prime numbers between 2 and 1000");
				System.out.println("There are " + arrP2.length + " prime numbers in this range. They are(eight numbers per line): ");
				for(int i = 0; i < arrP2.length; ++i){
					if((i+1)%8 == 0){
						System.out.println(arrP2[i]);
					} else {
						System.out.print(arrP2[i] + " ");
					}
				}
				System.out.println();

				List<Integer> primeP2_50 = primeP2.subList(0, 50);
				Object[] arrP2_50 = primeP2_50.toArray();
				System.out.println("Display the first 50 prime numbers between 2 and 1000(eight numbers per line): ");
				for(int i = 0; i < arrP2_50.length; ++i){
					if((i+1)%8 == 0){
						System.out.println(arrP2_50[i]);
					} else {
						System.out.print(arrP2_50[i] + " ");
					}
				}
				System.out.println();
				
			} else if(operation == 3){
				//Find the number of prime numbers less than 10000
				System.out.println();
				CountPrime p3 = new CountPrime();
				int count = p3.countPrime(10000);
				List<Integer> primeP3 = p3.getPrime();
				Object[] arrP3 = primeP3.toArray();
				System.out.println("Display prime numbers less than 10000");
				System.out.println("There are " + count + " prime numbers less than 10000");
				System.out.println("We only store " + arrP3.length + " prime numbers in the array list");
				
				List<Integer> primeP3_50 = primeP3.subList(0, 50);
				Object[] arrP3_50 = primeP3_50.toArray();
				System.out.println("The first 50 prime numbers less than 10000 are(eight numbers per line): ");
				for(int i = 0; i < arrP3_50.length; ++i){
					if((i+1)%8 == 0){
						System.out.println(arrP3_50[i]);
					} else {
						System.out.print(arrP3_50[i] + " ");
					}
				}
				
				boolean iftestLoop = true;
				while(iftestLoop){
					System.out.println();
					input.nextLine();
					System.out.println("Do you want to enter a number to test if it is prime? (Y/N)(Y for Yes/N for No)");
					String iftest = input.nextLine().trim();
					if(iftest.equals("Y")){
						System.out.println("Enter a number (2 to 1000) you want to test: ");
						int num = input.nextInt();
						boolean numIsPrime = primeP3.contains(num);
						if(numIsPrime){
							System.out.print(num + " is a prime number");
						} else {
							System.out.print(num + " is not a prime number");
						}
						
					} else if(iftest.equals("N")){
						iftestLoop = false;
					} else {
						System.out.println("You should input Y or N");
					}
				}
				System.out.println();
				
			} else {
				System.out.println("Please input 1 or 2 or 3");
				isCorrect = true;
			}
			
			correctInput = isCorrect;
		}
		
	}
	
	public static void main(String[] args) {
		/*exercise 5.16 Find the factors of an integer
		 *exercise 5.20 Display prime numbers between 2 and 1000
		 *exercise 6.10 FInd the number of prime numbers less than 10000*/
		
		System.out.println("Exercise 5.16 & 5.20 & 6.10 Find the factors and primes");
		boolean repeat = true;
		while(repeat){
			C5E16C5E20C6E10DisplayPrime c1 = new C5E16C5E20C6E10DisplayPrime();
			int repeatInt = JOptionPane.showConfirmDialog(null, "Repeat Program?");
			if(repeatInt == JOptionPane.NO_OPTION) repeat = false;
		}
	}

}

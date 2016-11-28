import java.util.Scanner;

import javax.swing.JOptionPane;

public class C6E23OccurenceChar {
	public static int count(String str, char a){
		int countChar = 0;
		for(char c: str.toCharArray()){
			if(c==a){
				countChar++;
			}
		}
		return countChar==0 ? -1 : countChar;
	}
	
	public C6E23OccurenceChar(){
		Scanner input = new Scanner(System.in);
		
		while(true){
			System.out.println();
			System.out.println("Enter a string for test");
			String str = input.nextLine();
			
			while(true){		
				char c = ' ';
				
				System.out.println();
				System.out.println("Current string is: " + str);
				System.out.println("Enter one character you want to test: ");
				c = input.nextLine().charAt(0);
		
				int countChar = count(str, c);
				System.out.println("The occurrences of the character \'" + c + "\' in the string \"" 
				+ str + "\" is: " + countChar);
				if(countChar==-1){
					System.out.println("The string \"" + str + "\" does not contain character \'" + c + "\'");
				}
				System.out.println();
				
				System.out.println("Do you want to count the occurences of another character in string \"" + str + "\" ? (Y/N)(Y for Yes, N for No)");
				String sameString = input.next().trim();
				input.nextLine();
				if(sameString.equals("Y")){
					continue;
				} else if(sameString.equals("N")){
					break;
				} else {
					System.out.println("You should input Y or N");
				}
			}
			
			System.out.println();
			System.out.println("Do you want to enter another string for test? (Y/N)(Y for Yes, N for No)");
			String diffString = input.next().trim();
			input.nextLine();
			if(diffString.equals("Y")){
				continue;
			} else if(diffString.equals("N")){
				break;
			} else {
				System.out.println("You should input Y or N");
			}
		}
	}

	public static void main(String[] args) {
		/*exercise 6.23 Occurrences of a specified character*/
		
		System.out.println("Exercise 6.23 Occurrences of a specified character");
		System.out.println("Count the occurrences of the character in the string");
		System.out.println("If this character exist in the string, return the occurrences");
		System.out.println("If not, return -1");
		System.out.println("For example: if the input string is \"Welcome\", and the input char is \'e\', the program will return 2");
		System.out.println("             if the input string is \"Welcome\", and the input char is \'a\', the program will return -1");
		
		boolean repeat = true;
		while(repeat){
			C6E23OccurenceChar c1 = new C6E23OccurenceChar();
			int repeatInt = JOptionPane.showConfirmDialog(null, "Repeat Program?");
			if(repeatInt == JOptionPane.NO_OPTION) repeat = false;
		}
	}

}

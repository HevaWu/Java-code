import java.io.File;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class C12E13CountInFile {
	public class countLine{
		private int letter = 0;
		private int word = 0;
		private int number = 0;
		private int special = 0;
		
		public countLine(String line){
			for(char c: line.toCharArray()){
				if((c>='a' && c<='z') || (c>='A' && c<='Z')){
					letter++;
				} else if(c>='0' && c<='9'){
					number++;
				} else {
					special++;
				}
			}
			
			String[] str = line.split(" ");
			for(int i = 0; i < str.length; i++){
				if(str[i].length() > 0){
					word++;
				}
			}
		}
		
		public int getLetter(){return letter;}
		public int getNumber(){return number;}
		public int getWord(){return word;}
		public int getSpecial(){return special;}
	}
	
	public C12E13CountInFile(){
		
		while(true){
			
			try{
				System.out.println();
				System.out.println("Choose a TXT file for test");
				
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
				        "Text files", "txt");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(null);
				File fileData = null;
				
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					try{
						System.out.println("You chose to open this file: " +
								chooser.getSelectedFile().getName());
						String fileName = chooser.getSelectedFile().getName();
						try{
							String substr = fileName.substring(fileName.indexOf("."));
							if(!substr.equals(".txt")){
								System.out.println("You need to choose a txt File");
								continue;
							}
						}catch(Exception e){
							System.out.println("Please choose a correct format file");
							continue;
						}
						fileData = chooser.getSelectedFile();
						System.out.println("Get File \"" + fileName + "\" successfully");
					} catch(Exception e){
						System.out.println("Get File in program Error: " + e);
						continue;
					}
					
					Scanner input = new Scanner(fileData);
					int countWord = 0;
					int countLine = 0;
					int countLetter = 0;
					int countNumber = 0;
					int countSpecial = 0;
					while(input.hasNextLine()){	
						String line = input.nextLine();
						countLine cl1 = new countLine(line);
						countWord += cl1.getWord();
						countLine ++;
						countLetter += cl1.getLetter();
						countNumber += cl1.getNumber();
						countSpecial += cl1.getSpecial();
					}
					System.out.println("File " + fileData.getName() + " has: ");
					System.out.println("     " + countLetter + " Letters");
					System.out.println("     " + countNumber + " Numbers");
					System.out.println("     " + countSpecial + " Special characterss(like ' ', '%', '$')");
					System.out.println("     " + (countLetter+countNumber+countSpecial) + " Characters");
					System.out.println("     " + countWord + " Words");
					System.out.println("     " + countLine + " Lines");
					break; 

				} else if(returnVal == JFileChooser.CANCEL_OPTION){
					break;
				} else {
					System.out.println("You need to choose a txt file for test");
				}
			}catch(Exception ex){
				System.out.println("Open File Error: " + ex);
			}
		}
	}

	public static void main(String[] args) {
		/*exercise 12.13 Count characters, words, and lines in a file*/
		
		System.out.println("Exercise 12.13 Count characters, words, and lines in a file");
		System.out.println("Input the file through command-line argument, and count the characters, words, and lines in it");
		System.out.println("If this file exists and it is a txt file, count and return the number for each");
		System.out.println("If not, throw an exception");
		
		boolean repeat = true;
		while(repeat){
			C12E13CountInFile c1 = new C12E13CountInFile();
			int repeatInt = JOptionPane.showConfirmDialog(null, "Repeat Program?");
			if(repeatInt == JOptionPane.NO_OPTION) repeat = false;
		}
	}

}

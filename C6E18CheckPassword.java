import javax.swing.JOptionPane;

public class C6E18CheckPassword {
	public static void main(String[] args) {
		/*exercise 6.18 Check Password*/
		
		System.out.println("Exercise 6.18 Check Password");
		System.out.println("Check if the input password is valid, the passwords rules are as follows: ");
		System.out.println("	A password mush have at least eight characters");
		System.out.println("	A password consists of only letters and digits");
		System.out.println("	A password must contain at least two digits");
		System.out.println("If the input password is valid, it will show \"Valid Password\"");
		System.out.println("If the input password is not valid, it will show why it is invalid");
		
		int option=JOptionPane.YES_OPTION;
		while(option==JOptionPane.YES_OPTION){
			try{
				String password=JOptionPane.showInputDialog(
						"Enter a Password: \nMust at least eight characters \nConsists of only letters and digits \nContian at least two digits");
				isValidPassword(password);
				option=JOptionPane.showConfirmDialog(null,
					"Valid Password: " + password + "\nDo you want to continue");
				}
			catch(Exception ex){
				String outputStr = " Invalid Password: " + 
						ex.getMessage() + 
						"\nDo you want to continue? ";
				option = JOptionPane.showConfirmDialog(null, outputStr);
			}
		}
	}
	
	private static void isValidPassword(String str)throws Exception{
		if(str.length() < 8){
			throw new Exception("Password should contain at least eight characters");
		}
		int digit = 0;
		for(char c: str.toCharArray()){
			if((c>='a' && c<='z') || (c>='A' && c<='Z')) continue;
			if(c>='0' && c<='9'){
				digit++;
				continue;
			}
			throw new Exception("Password should consists of only letters and digits");
		}
		if(digit < 2){
			throw new Exception("Password should contain at least two digits");
		}
	}
}

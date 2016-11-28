import javax.swing.JOptionPane;

public class C9E5TestGregorianCalendar {
	public C9E5TestGregorianCalendar(){
		C9E5GregorianCalendar c1 = new C9E5GregorianCalendar();
		System.out.println("Display the current year, month, and day");
		c1.print();
		System.out.println();
		
		try {
			System.out.println("After Set the value 1234567898765L : ");
			c1.setTimeInMillis(1234567898765L);
		} catch (Exception e) {
			System.out.println("SetTimeInMillis Fail");
		}
		c1.print();
	}
	
	
	public static void main(String[] args) {
		/*exercise 9.5 GregorianCalendar*/
		
		System.out.println("Exercise 9.5 GregorianCalendar");
		
		boolean repeat = true;
		while(repeat){
			C9E5TestGregorianCalendar c1 = new C9E5TestGregorianCalendar();
			int repeatInt = JOptionPane.showConfirmDialog(null, "Repeat Program?");
			if(repeatInt == JOptionPane.NO_OPTION) repeat = false;
		}
	}
}

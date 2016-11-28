
import java.util.Date;
import java.util.GregorianCalendar;

public class C9E5GregorianCalendar {
	private GregorianCalendar c1 = new GregorianCalendar();
	private String errorMessage = "";
	
	public C9E5GregorianCalendar(){
		Date trialTime = new Date();
		c1.setTime(trialTime);
	}
	public C9E5GregorianCalendar(GregorianCalendar c){
		c1 = c;
	}
	
	public int getYear(){return c1.get(c1.YEAR);}
	public int getMonth(){return c1.get(c1.MONTH);}
	public int getDayOfMonth(){return c1.get(c1.DAY_OF_MONTH);}
	
	public void setTimeInMillis(long millis) throws Exception{
		if(!isValidMills(millis)){
			Exception e = new Exception(errorMessage);
			throw e;
		}
		c1.setTimeInMillis(millis);
	}
	
	public boolean isValidMills(long millis){
		if(millis > 0) return true;
		errorMessage = "Invalid Millis: Millis should be > 0";
		return false;
	}
	
	public void print(){
		System.out.println("Year: " + this.getYear());
		System.out.println("Month: " + this.getMonth() + " (this number is suggest in get(calendar.Month))");
		System.out.println("	  the correspond actual month should be " + (this.getMonth()+1));
		System.out.println("Day: " + this.getDayOfMonth());
	}
}

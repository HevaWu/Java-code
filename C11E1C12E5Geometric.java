import java.util.Date;

public class C11E1C12E5Geometric {
	private String color = "white";
	private boolean filled = false;
	private Date dateCreated;
	
	public C11E1C12E5Geometric(){dateCreated = new Date();}
	public C11E1C12E5Geometric(String _color, boolean _filled){
		dateCreated = new Date();
		setColor(_color);
		setFilled(_filled);
	}
	
	public String getColor(){return color;}
	public boolean getFilled(){return filled;}
	public Date getDate(){return dateCreated;}
	
	public void setColor(String _color){color = _color;}
	public void setFilled(boolean _filled){filled = _filled;}
	
	public String toString(){
		return "created on " + dateCreated + "\ncolor: " + color + " --- filled: " + filled;
	}
}

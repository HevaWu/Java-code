
public class C9E1RectangleClass {
	private double width = 1.0;
	private double height = 1.0;
	
	private String errorMessage = "";

	public C9E1RectangleClass(){}
	
	public C9E1RectangleClass(double _width, double _height) throws Exception{
		setWidth(_width);
		setHeight(_height);
	}
	
	public double getWidth(){return width;}
	public double getHeight(){return height;}
	public String getErroeMessage(){return errorMessage;}
	
	public String toString(){return "Rectangle: Width = " + width + " Height = " + height;}
	public boolean equals(Object o){
		if(o==null) return false;
		String s = o.getClass().getName();
		if(!s.equals("C9E1RectangleClass")) return false;
		
		C9E1RectangleClass r = (C9E1RectangleClass) o;
		if(!(width == r.getWidth())) return false;
		if(!(height == r.getHeight())) return false;
		
		return true;
	}
	
	public void print(){
		System.out.println("Width of Rectangle = " + width);
		System.out.println("Height of Rectangle = " + height);
	}
	
	public void setWidth(double _width) throws Exception{
		if(!isValidWidth(_width)){
			Exception e = new Exception(errorMessage);
			throw e;
		}
		width = _width;
	}
	
	public void setHeight(double _height) throws Exception{
		if(!isValidHeight(_height)){
			Exception e = new Exception(errorMessage);
			throw e;
		}
		height = _height;
	}
	
	public boolean isValidWidth(double _width){
		if(_width > 0) return true;
		errorMessage = "Invalid Width: Width should be > 0";
		return false;
	}
	
	public boolean isValidHeight(double _height){
		if(_height > 0) return true;
		errorMessage = "Invalid Height: Height should be > 0";
		return false;
	}
	
	public double getArea(){
		return width * height;
	}
	
	public double getPerimeter(){
		return 2 * (width + height);
	}
}

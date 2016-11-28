
public class C10E13Rectangle2D {
	private double x = 0;
	private double y = 0;
	private double width = 1.0;
	private double height = 1.0;
	
	private String errorMessage = "";
	private String containMessage = "";
	private String overMessage = "";

	public C10E13Rectangle2D(){}
	public C10E13Rectangle2D(double _x, double _y, double _width, double _height) throws Exception{
		setX(_x);
		setY(_y);
		setWidth(_width);
		setHeight(_height);
	}
	
	public double getX(){return x;}
	public double getY(){return y;}
	public double getWidth(){return width;}
	public double getHeight(){return height;}
	public String getErrorMessage(){return errorMessage;}
	public String getContainMessage(){return containMessage;}
	public String getOverMessage(){return overMessage;}
	
	public double setX(double _x){return x = _x;}
	public double setY(double _y){return y = _y;}
	
	public void setWidth(double _width) throws Exception{
		if(!isValidWidth(_width)){
			Exception e = new Exception(errorMessage);
			throw e;
		}
		width = _width;
	}
	
	public void setHeight(double _height) throws Exception{
		if(!isValidWidth(_height)){
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
	
	public String toString(){
		return "Rectangle: Covered By (" + (x-width/2) + "," + (y-height/2)
								+ ") (" + (x+width/2) + "," + (y-height/2)
								+ ") (" + (x-width/2) + "," + (y+height/2)
								+ ") (" + (x+width/2) + "," + (y+height/2) + ")";}
	public boolean equals(Object o){
		if(o==null) return false;
		String s = o.getClass().getName();
		if(!s.equals("C10E13Rectangle2D")) return false;
		
		C10E13Rectangle2D r = (C10E13Rectangle2D) o;
		if(!(x == r.getX())) return false;
		if(!(y == r.getY())) return false;
		if(!(width == r.getWidth())) return false;
		if(!(height == r.getHeight())) return false;
		
		return true;
	}
	
	public void print(){
		System.out.println("Width of Rectangle = " + width);
		System.out.println("Height of Rectangle = " + height);
	}
	
	public double getArea(){
		return width * height;
	}
	
	public double getPerimeter(){
		return 2 * (width + height);
	}
	
	public boolean contains(double x1, double y1){
		if(x1>x-width/2 && x1<x+width/2 && y1>y-height/2 && y1<y+height/2){
			containMessage = "Points (" + x1 + "," + y1 + ") is INSIDE current rectangle " + this.toString();
			return true;
		} else if(x1==x-width/2 || x1==x+width/2 || y1==y-height/2 || y1==y+height/2){
			containMessage = "Points (" + x1 + "," + y1 + ") is ON the edge of current rectangle " + this.toString();
			return true;
		} else {
			containMessage = "Points (" + x1 + "," + y1 + ") is OUT of current rectangle " + this.toString();
			return false;
		}
	}
	
	public boolean contains(C10E13Rectangle2D r){
		if(this.equals(r)){
			containMessage = "The input rectangle " + r.toString() + "\nis EQUAL to current rectangle " + this.toString();
			return true;
		} else if(r.getX()-r.getWidth()/2>=x-width/2
				&& r.getY()-r.getHeight()/2>=y-height/2
				&& r.getX()+r.getWidth()/2<=x+width/2
				&& r.getY()+r.getHeight()/2<=y+height/2){
			containMessage = "The input rectangle " + r.toString() + "\nis INSIDE current rectangle " + this.toString();
			return true;
		} else {
			containMessage = "The input rectangle " + r.toString() + "\nis OUT of current rectangle " + this.toString();
			return false;
		}
	}
	
	public boolean overlaps(C10E13Rectangle2D r){
		if(this.equals(r)){
			overMessage = "The input rectangle " + r.toString() + "\nis EQUAL to current rectangle " + this.toString();
			return true;
		} else if(this.contains(r)){
			overMessage = "The input rectangle " + r.toString() + "\nis INSIDE current rectangle " + this.toString();
			return true;
		} else if(this.contains(r.getX()-r.getWidth()/2, r.getY()-r.getHeight()/2) 
				|| this.contains(r.getX()+r.getWidth()/2, r.getY()-r.getHeight()/2)
				|| this.contains(r.getX()-r.getWidth()/2, r.getY()+r.getHeight()/2) 
				|| this.contains(r.getX()+r.getWidth()/2, r.getY()+r.getHeight()/2)){
			overMessage = "The input rectangle " + r.toString() + "\n OVERLAPS with current rectangle " + this.toString();
			return true;
		} else {
			overMessage = "The input rectangle " + r.toString() + "\nis OUT of current rectangle " + this.toString();
			return false;
		}
	}
}



public class C11E1C12E5Triangle extends C11E1C12E5Geometric{
	private double side1 = 1.0;
	private double side2 = 1.0;
	private double side3 = 1.0;
	
	private String errorMessage = "";
	
	public C11E1C12E5Triangle(){}
	public C11E1C12E5Triangle(double _side1, double _side2, double _side3) throws Exception{
		setSide1(_side1);
		setSide2(_side2);
		setSide3(_side3);
		if((side1+side2>side3) && (side1+side3>side2) && (side2+side3)>side2){
			return;
		} else {
			throw new C11E1C12E5InvalidTriangleException(side1, side2, side3);
		}
	}
	
	public double getSide1(){return side1;}
	public double getSide2(){return side2;}
	public double getSide3(){return side3;}
	public String getErrorMessage(){return errorMessage;}
	
	public void setSide1(double _side1)throws Exception{
		if(!isValidSide(_side1)){
			Exception e = new Exception(errorMessage);
			throw e;
		}
		side1 = _side1;
	}
	public void setSide2(double _side2)throws Exception{
		if(!isValidSide(_side2)){
			Exception e = new Exception(errorMessage);
			throw e;
		}
		side2 = _side2;
	}
	public void setSide3(double _side3)throws Exception{
		if(!isValidSide(_side3)){
			Exception e = new Exception(errorMessage);
			throw e;
		}
		side3 = _side3;
	}
	
	public boolean isValidSide(double _side){
		if(_side > 0) return true;
		errorMessage = "Invalid Side: Side should be > 0";
		return false;
	}
	
	public double getArea(){
		double p = (side1+side2+side3)/2;
		return Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
	}
	
	public double getPerimeter(){
		return side1+side2+side3;
	}
	
	@Override
	public String toString(){
		return "Triangle: side1 = " + side1 + "  side2 = " + side2 + "  side3 = " + side3;
	}
	
	public void print(){
		System.out.println(this.toString());
		System.out.println("This triangle " + super.toString());
	}
	
	public boolean equals(Object o){
		if(o==null) return false;
		String s = o.getClass().getName();
		if(!s.equals("C11E1C12E5Triangle")) return false;
		
		C11E1C12E5Triangle r = (C11E1C12E5Triangle) o;
		if(!(side1 == r.getSide1())) return false;
		if(!(side2 == r.getSide2())) return false;
		if(!(side3 == r.getSide3())) return false;
		
		return true;
	}
}


public class C11E1C12E5InvalidTriangleException extends Exception{
	private double side1 = 1.0;
	private double side2 = 1.0;
	private double side3 = 1.0;
	
	public C11E1C12E5InvalidTriangleException(double _side1, double _side2, double _side3){
		super("Illegal Triangle: side1=" + _side1 + "  side2 = " + _side2 + "  side3 = " + _side3 + " cannot build a triangle");
		side1 = _side1;
		side2 = _side2;
		side3 = _side3;
	}
	
	public double getSide1(){return side1;}
	public double getSide2(){return side2;}
	public double getSide3(){return side3;}
}

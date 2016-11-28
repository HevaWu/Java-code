
public class C9E11E12LinearAndIntersect {
	private double a = 1.0;
	private double b = 1.0;
	private double c = 1.0;
	private double d = 1.0;
	private double e = 1.0;
	private double f = 1.0;
	
	public C9E11E12LinearAndIntersect(){}
	public C9E11E12LinearAndIntersect(double _a, double _b, double _c, double _d, double _e, double _f){
		seta(_a);
		setb(_b);
		setc(_c);
		setd(_d);
		sete(_e);
		setf(_f);
	}
	
	public void seta(double _a){a = _a;}
	public void setb(double _b){b = _b;}
	public void setc(double _c){c = _c;}
	public void setd(double _d){d = _d;}
	public void sete(double _e){e = _e;}
	public void setf(double _f){f = _f;}
	
	public double geta(){return a;}
	public double getb(){return b;}
	public double getc(){return c;}
	public double getd(){return d;}
	public double gete(){return e;}
	public double getf(){return f;}
	
	public void print(){
		System.out.println("Current 2 * 2 linear equations are: ");
		System.out.println(a + " * x + " + b + " * y = " + e);
		System.out.println(c + " * x + " + d + " * y = " + f);
	}
	
	public boolean isSolvable(){
		if(a*d-b*c != 0) return true;
		return false;
	}
	
	public double getX(){
		return (e*d-b*f)/(a*d-b*c);
	}
	
	public double getY(){
		return (a*f-e*c)/(a*d-b*c);
	}
}

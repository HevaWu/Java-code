import javax.swing.JOptionPane;

public class C4E3EstimateAreas {
	public static double radius = 6371.01;
	
	public static double countDis(double xa, double ya, double xb, double yb){
		return radius * Math.acos( Math.sin(xa) * Math.sin(xb)
				+ Math.cos(xa) * Math.cos(xb) * Math.cos(ya - yb));
	}
	
	public C4E3EstimateAreas(){
		System.out.println("The degree of Atlanta, Georgia is: (33.7489954, -84.3879824)");
		double x1 = Math.toRadians(33.7489954); //point Atlanta, Georgia
		double y1 = Math.toRadians(-84.3879824);
		
		System.out.println("The degree of Orlando, Florida is: (28.5383355, -81.3792365)");
		double x2 = Math.toRadians(28.5383355); //point Orlando, Florida
		double y2 = Math.toRadians(-81.3792365);
		
		System.out.println("The degree of Savannah, Georgia is: (32.0835407, -81.0998342)");
		double x3 = Math.toRadians(32.0835407); //point Savannah, Georgia
		double y3 = Math.toRadians(-81.0998342);
		
		System.out.println("The degree of Charlotte, North Carolina is: (35.2270869, -80.8431267)");
		double x4 = Math.toRadians(35.2270869); //point Charlotte, North Carolina
		double y4 = Math.toRadians(-80.8431267);
		
		double radius = 6371.01;
		
		//distance between Atlanta and Charlotte
		double dis14 = countDis(x1,y1,x4,y4);
		System.out.println("Distance: Atlanta to Charlotte is : " + dis14 + " km");
		
		//distance between Atlanta and Orlando
		double dis12 = countDis(x1,y1,x2,y2);
		System.out.println("Distance: Atlanta to Orlando is : " + dis12 + " km");
		
		//distance between Atlanta and Savannah
		double dis13 = countDis(x1,y1,x3,y3);
		System.out.println("Distance: Atlanta to Savannah is : " + dis13 + " km");
		
		//distance between Charlotte and Savannah
		double dis34 = countDis(x3,y3,x4,y4);
		System.out.println("Distance: Savannah to Charlotte is : " + dis34 + " km");
		
		//distance between Savannah and Orlando
		double dis23 = countDis(x2,y2,x3,y3);
		System.out.println("Distance: Savannah to Orlando is : " + dis23 + " km");
		
		//divide the polygon into two triangles
		//triangle 1 : Atlanta, Charlotte, Savannah
		double s1 = (dis14 + dis34 + dis13)/2;
		double area1 = Math.sqrt(
				s1 * (s1 - dis14) * (s1 - dis34) * (s1 - dis13));
		System.out.println("Triangle area: enclosed by Atlanta, Charlotte and Savannah is: " + area1 + " km^2");
		
		//triangle 2 : Atlanta, Orlando, Savannah
		double s2 = (dis12 + dis23 + dis13)/2;
		double area2 = Math.sqrt(
				s2 * (s2 - dis12) * (s2 - dis23) * (s2 - dis13));	
		System.out.println("Triangle area: enclosed by Atlanta, Orlando and Savannah is: " + area2 + " km^2");
		
		double area = area1 + area2;
		System.out.println("The estimated area enclosed by Atlanta; "
				+ "Orlando; Savannah; and Charlotte "
				+ "is " + area + " km^2");
			
	}

	public static void main(String[] args) {
		/*exercise 4.3 Estimate Areas*/
		System.out.println("Geography: estimate areas");
		System.out.println("Start calculating the estimated are enclosed by Atlanta, Orlando, Savannahm and Charlotte");
		boolean repeat = true;
		
		while(repeat){
			C4E3EstimateAreas c1 = new C4E3EstimateAreas();
			int repeatInt = JOptionPane.showConfirmDialog(null, "Repeat Program?");
			if(repeatInt == JOptionPane.NO_OPTION) repeat = false;
		}
	}

}

package practice_Set_Problems_Problem1;

public class Cylinder {
	
	public static void main(String[] args) {
		
		//The below line represent's the , Object of the Setter_Getters class
		Setter_Getters sg = new Setter_Getters();
		
		//setting values of pie, height & radius by using setter method with use of other class & by calling it
		sg.setHeight(35);
		sg.setRadius(3.0);
		sg.setPie(3.14);
		
		//getting values of pie, radius & height
		System.out.println("The value  of the Pie      is: " + sg.getPie());
		System.out.println("The height of the cylinder is: " + sg.getHeight() + "  cm");
		System.out.println("The radius of the cylinder is: " + sg.getRadius() + " cm");
		
		 // volume of cylinder => (V = 3.14*(r)^2*h)
		double V = sg.getPie()*(sg.getRadius()*sg.getRadius())*sg.getHeight();
		System.out.println("The volume of the cylinder is: " + V + " cm^3");
		
	}

}

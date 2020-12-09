package practiceProblems;

//a class to implement getter & setter methods for achieving encapsulation
public class Getters_Setters_For_Cylinder {
	
	/*we have to put the variables private to achieve encapsulation*/
	private int height;
	private double radius;
	private double pie;
	
	//setter method to set height of cylinder
	public void setHeight(int height) {
		if(height > 40)			System.out.println(" The height of cylender is to high to to find vol & surface area: ");
		else				this.height = height;
	}
	
	//setter method to set radius of cylinder
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	//setter method to set the value of pie
	public void setPie(double pie) {
		this.pie = pie;
	}
	
	//getter method to get the height of cylinder
	public int getHeight() {
		return height;
	}
		
	//getter method to get the radius of cylinder
	public double getRadius() {
		return radius;
	}
	
	//getter method to get the value of pie
	public double getPie() {
		return pie;
	}
	
	

}

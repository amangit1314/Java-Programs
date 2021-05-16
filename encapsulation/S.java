package encapsulation;

//Student class short name as S
public class S {
	
	/*we have to put the variables private to achieve encapsulation*/
	private int age;
	
	private String name;
	
	//setter methods
	public void setAge(int age) {
		if(age>20)			System.out.println(" You are to old:");
		else				this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	//getter methods
	public int getAge() {
		return age;
	}
		
	public String getName() {
		return name;
	}
}

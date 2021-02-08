package oopsinheritance;

public class MainClass {

	public static void main(String[] args) {
		//Object of teacher class
		Teacher T = new Teacher();
		T.name = "Mr Harry ";
		T.eat();
		T.walk();
		T.teach();
		//Object of singer class
		Singer s = new Singer();
		s.name = "Justin B ";
		s.sing();
		s.eat();
		
	}

}

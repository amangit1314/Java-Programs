package oopspolymorphism;

public class MainClass {

	
	public static void greetings() {
		System.out.println("Hi,there");
	}
	public static void greetings(String s) {
		System.out.println(s);
	}
	public static void greetings(String s, int count) {
		for(int i=0;i<count;i++)
		System.out.println(s);
	}


	
	public static void main(String[] args) {
		greetings();
		Dog d = new Dog();
		Pet p = d;
		@SuppressWarnings("unused")
		Animal a = d;
		d.walk();
		p.walk();
	}

}

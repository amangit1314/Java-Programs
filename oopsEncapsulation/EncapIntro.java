package oopsEncapsulation;

public class EncapIntro {

	public static void main(String[] args) {
		S obj = new S();
		
		obj.setName("Milan");
		obj.setAge(16);
		
		System.out.println(obj.getName());
		System.out.println(obj.getAge());
	}
}

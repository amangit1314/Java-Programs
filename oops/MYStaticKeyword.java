<<<<<<< HEAD
package oops;
import oops.A.C;
public class MYStaticKeyword {

	static {
		System.out.println("in block 1");
	}
	static {
		System.out.println("in block 2");
	}
	
	public static void main(String[] args) {
		
		A objA = new A();
		@SuppressWarnings("unused")
		A.B objB = objA.new B();
		@SuppressWarnings("unused")
		C objC = new A.C();
		System.out.println("inside main");
	}

}
=======
package oops;
import oops.A.C;
public class MYStaticKeyword {

	static {
		System.out.println("in block 1");
	}
	static {
		System.out.println("in block 2");
	}
	
	public static void main(String[] args) {
		
		A objA = new A();
		@SuppressWarnings("unused")
		A.B objB = objA.new B();
		@SuppressWarnings("unused")
		C objC = new A.C();
		System.out.println("inside main");
	}

}
>>>>>>> master

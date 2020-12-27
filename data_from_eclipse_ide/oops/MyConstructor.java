package oops;

public class MyConstructor {

		MyConstructor(){
			System.out.println("Obj is now created");
		}
		public static void main(String[] args) {
			@SuppressWarnings("unused")
			MyConstructor  obj = new MyConstructor();
	}

}

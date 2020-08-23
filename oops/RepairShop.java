package oops;

public class RepairShop {

		
		public static void repair (Watches ws) {
			System.out.println("watch is repaired");
		}
		public static void repair(Sonata sn) {
			System.out.println("watch is repaired");
		}
		public static void main(String[] args) {
			Mor Mo = new Mor();
			Sonata sn = new Sonata();
			
			repair(Mo);
			repair(sn);
			}

}

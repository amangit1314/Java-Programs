package arrays;

//Program to demonstrate the arrays.array of objects

//Cricketer class
class Cricketer{
	public int batting_position;
	public String name;
	
	Cricketer(int batting_position, String name)
	{
		this.batting_position = batting_position;
		this.name = name;
	}
}

//Driver Class
public class Array_of_objects {
	
	//Driver Method
	public static void main(String[] args) {
		
		// Declaring or making the arrays.array of type Cricketer , which is known as Array of Objects
		Cricketer[] arr;
		// arrays.array capacity is of storing 5 elements in it.
		arr = new Cricketer[11];			
		
		arr[0 ]  = new Cricketer(1,   "Rohit Sharma(W.C)");
		arr[1 ]  = new Cricketer(2,   "Shikhar Dhawan");
		arr[2 ]  = new Cricketer(3,   "Virat Kohli(C.)");
		arr[3 ]  = new Cricketer(4,   "K.L Rahul");
		arr[4 ]  = new Cricketer(5,   "Rishabh Pant(W.K)");
		arr[5 ]  = new Cricketer(6,   "Hardik Pandaya");
		arr[6 ]  = new Cricketer(7,   "Bhuvaneshwar Kumar");
		arr[7 ]  = new Cricketer(8,   "Mohammed Shami");
		arr[8 ]  = new Cricketer(9,   "Jaspreet Bumrah");
		arr[9 ]  = new Cricketer(10, "Yuzvendre Chahal");
		arr[10] = new Cricketer(11,  "Kuldeep Yadav");
		
		
		for(int i = 0 ; i < arr.length ; i++) 
			System.out.println("Element at index " +  i + " : " + "Batting Position: " + arr[i].batting_position + " " + "Player Name: " + arr[i].name);	
	}
}

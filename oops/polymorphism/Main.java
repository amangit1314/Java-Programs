package oops.polymorphism;

public class Main {
    public static void greetings(){
        System.out.println("Hi, there");
    }
    public static void greetings(String s){
        System.out.println(s);
    }
    public static void greetings(String s, int count){
        for (int i = 0; i < count; i++)
            System.out.println(s);
    }

    public static void main(String[] args) {
        greetings("Good Morning");
        Dog d = new Dog();
        d.walk();
        ((Pet) d).walk();
    }
}
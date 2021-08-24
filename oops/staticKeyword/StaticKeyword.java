package oops.staticKeyword;

public class StaticKeyword {
    public static void main(String[] args) {
        Person obj = new Person();
        obj.name = "Aman";
        obj.age = 19;
        System.out.println(obj.age + "age");
        System.out.println(obj.name);
        System.out.println(Person.breed);
    }
}
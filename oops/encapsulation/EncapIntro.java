package oops.encapsulation;

public class EncapIntro {
    public static void main(String[] args) {
        S obj = new S();
        obj.setName("Aman");
        obj.setAge(19);

        System.out.println(obj.getName());
        System.out.println(obj.getAge());
    }
}
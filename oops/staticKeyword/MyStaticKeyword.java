package oops.staticKeyword;

public class MyStaticKeyword {
    static {
        System.out.println("in block 1");
    }
    static {
        System.out.println("in bock 2");
    }

    public static void main(String[] args) {
        A objA = new A();
        objA.new B();
        new A.C();
        System.out.println("inside main");
    }
}
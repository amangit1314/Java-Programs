package oops.staticKeyword;
import oops.staticKeyword.A.C;

public class MyStaticKeyword {
    static {
        System.out.println("in block 1");
    }
    static {
        System.out.println("in bock 2");
    }

    public static void main(String[] args) {
        A objA = new A();
        A.B objB = objA.new B();
        C objC = new A.C();
        System.out.println("inside main");
    }
}
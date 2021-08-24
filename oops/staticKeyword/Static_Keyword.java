package oops.staticKeyword;

import oops.staticKeyword.A.C;

public class Static_Keyword {
    public static void main(String[] args) {
        A objA = new A();
        A.B objB = objA.new B();
        C objC = new A.C();
    }
}
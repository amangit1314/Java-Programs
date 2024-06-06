package oops.staticKeyword;

import oops.staticKeyword.A.C;

public class Static_Keyword {
    public static void main(String[] args) {
        A objA = new A();
        @SuppressWarnings("unused")
        A.B objB = objA.new B();
        @SuppressWarnings("unused")
        C objC = new A.C();
    }
}
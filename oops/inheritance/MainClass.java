package oops.inheritance;

public class MainClass {
    public static void main(String[] args) {
        Teacher T = new Teacher();
        T.name = "Mr Harry";
        T.eat();
        T.walk();
        T.teach();

        Singer s = new Singer();
        s.name = "Justin Bieber";
        s.sing();
        s.eat();
    }
}
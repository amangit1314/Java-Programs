package oops.abstraction;

public class Person implements Student,Youtuber{

    @Override
    public void study(){
        System.out.println("Person is studying");
    }

    @Override
    public void makeVideo(){
        System.out.println("Person is making a good video");
    }

    public static void main(String[] args) {
        Person obj = new Person();
        obj.study();
        obj.makeVideo();
    }
}
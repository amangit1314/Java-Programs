package oops.encapsulation;

public class S {
    private int age;
    private String name;

    public void setAge(int age){
        if(age > 20)
            System.out.println("You are to old: ");
        else
            this.age = age;
    }

    public  void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }
}
//package stack_and_queue;
//// Problem Title => Reverse a string using Stack
//
//class Stack{
//    int size;
//    int top;
//    char[] a;
//
//    boolean isEmpty(){
//        return (top < 0);
//    }
//
//    Stack(int n){
//        top = -1;
//        size = n;
//        a = new char[size];
//    }
//
//    //function to push an element in stack
//    boolean push (char x){
//        if(top >= size){
//            System.out.println("Stack overflow");
//            return false;
//        }
//        else {
//            a[++top] = x;
//            return true;
//        }
//    }
//
//    //function to pop an element from stack
//    char pop(){
//        if(top < 0){
//            System.out.println("Stack overflow");
//            return 0;
//        }
//        else
//            return a[top--];
//    }
//}
//public class P7 {
//
//    public static void reverse(StringBuffer str){
//        int n = str.length();
//        Stacks obj = new Stacks(n);
//
//        // Push all characters of string to stack
//        int i;
//        for (i = 0; i < n; i++)
//            obj.push(str.charAt(i));
//
//        // Pop all characters of string and put them back to str
//        for (i = 0; i < n; i++) {
//            char ch = obj.pop();
//            str.setCharAt(i,ch);
//        }
//    }
//    public static void main(String[] args) {
//        //create a new string
//        StringBuffer s= new StringBuffer("GeeksQuiz");
//
//        //call reverse method
//        reverse(s);
//
//        //print the reversed string
//        System.out.println("Reversed string is " + s);
//    }
//}
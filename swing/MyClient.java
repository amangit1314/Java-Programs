package swing;

//MyClient.java
import java.rmi.*;

public class MyClient {
    public static void main(String[] args) {
        int ans;
        try {
            AddServer access = (AddServer) Naming.lookup("rmi://localhost:5000/AS");
            // access.add(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
            System.out.println("Sum = " + access.add(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }
}
package rmi_db;
import java.rmi.*;
public class MyServer{
    public static void main(String[] args) throws Exception{
        Remote r=new BankImpl();
        Naming.rebind("rmi://localhost:3306/root",r);
    }
}
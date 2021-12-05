//package rmi_2;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.rmi.*;
public class ApplicationClient {

    public static void main(String[] args) {

        Authentication authentication;

        try {
            authentication = (Authentication)Naming.lookup("rmi://localhost:5000/AS");

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the username : ");
            String userName = scanner.next();

            System.out.println("Enter the password : ");
            String password = scanner.next();

            boolean status = authentication.authenticate(userName, password);

            if(status) {
                System.out.println("You're authorization is successful ...");
            } else {
                System.out.println("Unauthorized Login Attempt");
            }
            scanner.close();
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
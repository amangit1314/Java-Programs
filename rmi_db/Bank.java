package rmi_db;
import java.rmi.*;
import java.util.*;
interface Bank extends Remote {
    List<rmi_db.Customer> getCustomers() throws RemoteException;
}
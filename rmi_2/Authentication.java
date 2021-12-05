package rmi_2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Authentication extends Remote {

    boolean authenticate(String userName, String password) throws RemoteException ;
}
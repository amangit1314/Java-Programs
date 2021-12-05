package rmi_2;

import java.rmi.*;
import java.rmi.server.*;

public class AuthenticationImpl extends UnicastRemoteObject implements Authentication {

    protected AuthenticationImpl() throws RemoteException {
            super();
    }

    public boolean authenticate(String userName, String password)
            throws RemoteException {

        if ((userName != null && !userName.isEmpty())
                && (password != null && !password.isEmpty())) {

            return (userName.equalsIgnoreCase("admin"))
                    && (password.equalsIgnoreCase("admin"));
        }
        return false;
    }

}
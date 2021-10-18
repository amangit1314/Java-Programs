package swing;

//AddRemote.java
import java.rmi.*;
import java.rmi.server.*;

public class AddRemote extends UnicastRemoteObject implements AddServer {
    AddRemote() throws RemoteException {
        super();
    }

    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
}
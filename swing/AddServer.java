package swing;

//AddServer.java
import java.rmi.*;

public interface AddServer extends Remote {
    public int add(int a, int b) throws RemoteException;
}
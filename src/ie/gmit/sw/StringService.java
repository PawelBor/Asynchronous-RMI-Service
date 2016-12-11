package ie.gmit.sw;

import java.rmi.Remote;
import java.rmi.RemoteException;
//INTERFACE: service compare 2 strings
public interface StringService extends Remote{
	public Resultator compare(String s, String t, String algo) throws RemoteException;
}
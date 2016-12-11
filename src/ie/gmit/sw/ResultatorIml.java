package ie.gmit.sw;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ResultatorIml extends UnicastRemoteObject implements Resultator{
	public ResultatorIml() throws RemoteException {
		super();
		isProcessed = false;
		result = "";
	}
	//Marshalling(CS) - transforming object to data format transmission
	private static final long serialVersionUID = 1L;
    private boolean isProcessed;
    private String result;
	
	//get result val
	public String getResult() throws RemoteException {
		return this.result;
	}
	//sets result string val
	public void setResult(String result) throws RemoteException {
        this.result = result;
		
	}
	//examins if process is/is not processed
	public boolean isProcessed() throws RemoteException {
		return isProcessed;
	}
	//if processed set isProcessed to True
	public void setProcessed() throws RemoteException {
		this.isProcessed = true;
	}
}

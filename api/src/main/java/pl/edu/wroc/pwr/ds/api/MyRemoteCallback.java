package pl.edu.wroc.pwr.ds.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyRemoteCallback extends Remote {
	public void callback(String data) throws RemoteException;
}